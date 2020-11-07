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

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Zhiyong Dai
 */
public class DuelArena {

    public static final int BANISH_AREA = 1;
    public static final int GRAVE_AREA = 2;
    public static final int EXTRA_DECK_AREA = 3;
    public static final int MONSTER_AREA = 4;
    public static final int MAGIC_TRAP_AREA = 5;
    public static final int EXTRA_AREA = 6;
    public static final int FIELD_MAGIC_AREA = 7;

    private final CardArea banish;
    private final CardArea extra;
    private final CardArea grave;
    private final List<CardArea> monsterFields;
    private final List<CardArea> magicTrapFields;
    private final List<CardArea> extraFields;
    private final CardArea fieldMagicField;


    private final Set<Player> players;

    public DuelArena(Set<Player> players) {
        this.players = new HashSet<>(players);
        this.players.forEach(this::add);
        this.banish = new CardArea(BANISH_AREA, 0);
        this.grave = new CardArea(GRAVE_AREA, 1);
        this.extra = new CardArea(EXTRA_DECK_AREA, 2);
        this.monsterFields = createCardFields(5, MONSTER_AREA, 3);
        this.magicTrapFields = createCardFields(5, MAGIC_TRAP_AREA, 8);
        this.extraFields = createCardFields(2, EXTRA_AREA, 10);
        this.fieldMagicField = new CardArea(FIELD_MAGIC_AREA, 11);
    }

    public DuelArena() {
        this(new HashSet<>());
    }

    private List<CardArea> createCardFields(int count, int area, int positionStart) {
        return Collections.unmodifiableList(
                IntStream.range(0, count).mapToObj(i -> new CardArea(area, positionStart + i))
                        .collect(Collectors.toList())
        );
    }

    public CardArea getExtra() {
        return extra;
    }

    public CardArea getGrave() {
        return grave;
    }

    public CardArea getBanish() {
        return banish;
    }

    public List<CardArea> getMonsterFields() {
        return monsterFields;
    }

    public CardArea getMonsterFields(int n) {
        if (n < 1 || n > 5) {
            throw new RuntimeException("Card field index out of bound");
        }
        return monsterFields.get(n - 1);
    }

    public List<CardArea> getMagicTrapFields() {
        return magicTrapFields;
    }

    public CardArea getMagicTrapFields(int n) {
        if (n < 1 || n > 5) {
            throw new RuntimeException("Card field index out of bound");
        }
        return magicTrapFields.get(n - 1);
    }

    public List<CardArea> getExtraFields() {
        return extraFields;
    }

    public CardArea getExtraFields(int n) {
        if (n < 1 || n > 5) {
            throw new RuntimeException("Card field index out of bound");
        }
        return extraFields.get(n - 1);
    }

    public CardArea getFieldMagicField() {
        return fieldMagicField;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void add(Player player) {
        player.setDuelArena(this);
        players.add(player);
    }

    public void remove(Player player) {
        player.setDuelArena(null);
        players.remove(player);
    }

    public boolean contains(Player player) {
        return players.contains(player);
    }

}
