/*
 * Copyright (c) 2020 free-ygo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.freeygo.engine;

import java.util.Objects;

/**
 * @author Zhi yong Dai
 */
public class Player implements Comparable<Player> {

    private final DuelDisk duelDisk;
    private final LifePoint lifePoint;
    private final UserDirectiveReader userDirectiveReader;
    private DuelArena duelArena;
    private String name;
    private int priority; // 回合进行优先级

    public Player(String name, int lifePoint, CardDeck cardDeck, UserDirectiveReader userDirectiveReader, int priority) {
        Objects.requireNonNull(cardDeck);
        Objects.requireNonNull(cardDeck.getCards());
        this.name = name;
        this.lifePoint = new LifePoint(lifePoint);
        this.duelDisk = new DuelDisk(cardDeck.getCards());
        this.priority = priority;
        this.userDirectiveReader = userDirectiveReader;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CardArea getDeck() {
        return duelDisk.getDeck();
    }

    public CardArea getHand() {
        return duelDisk.getHand();
    }

    public LifePoint getLifePoint() {
        return lifePoint;
    }

    /**
     * 回合优先级，值越小，优先级越高。
     *
     * @return 优先级，范围：{@link Integer#MIN_VALUE}-{@link Integer#MAX_VALUE}
     */
    public int getPriority() {
        return priority;
    }

    /**
     * 设置优先级。
     * 值越小，优先级越高。
     *
     * @param priority 优先级
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(Player o) {
        return this.priority - o.priority;
    }

    public DuelArena getDuelArena() {
        return duelArena;
    }

    public void setDuelArena(DuelArena duelArena) {
        this.duelArena = duelArena;
    }

    public UserDirectiveReader getUserDirectiveReader() {
        return userDirectiveReader;
    }

    public boolean hasActiveEffects() {
        return false;
    }
}
