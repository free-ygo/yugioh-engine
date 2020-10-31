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
 * @author Zhi yong Dai
 */
public class DuelArena {

    public static final int MONSTER_FIELD = 7;

    private final CardArea banish;
    private final CardArea extra;
    private final CardArea grave;
    private final List<CardField> monsterFields;
    private final List<CardField> magicTrapFields;
    private final List<CardField> extraFields;
    private final CardField fieldMagicField;


    private final Set<Player> players;

    public DuelArena(Set<Player> players) {
        this.players = new HashSet<>(players);
        this.players.forEach(this::add);
        this.banish = new CardArea();
        this.grave = new CardArea();
        this.extra = new CardArea();
        this.monsterFields = createCardFields(5);
        this.magicTrapFields = createCardFields(5);
        this.extraFields = createCardFields(2);
        this.fieldMagicField = new CardField();
    }

    public DuelArena() {
        this(new HashSet<>());
    }

    private List<CardField> createCardFields(int n) {
        return Collections.unmodifiableList(
                IntStream.range(0, n).mapToObj(i -> new CardField())
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

    public List<CardField> getMonsterFields() {
        return monsterFields;
    }

    public CardField getMonsterFields(int n) {
        if (n < 1 || n > 5) {
            throw new RuntimeException("Card field index out of bound");
        }
        return monsterFields.get(n - 1);
    }

    public List<CardField> getMagicTrapFields() {
        return magicTrapFields;
    }

    public CardField getMagicTrapFields(int n) {
        if (n < 1 || n > 5) {
            throw new RuntimeException("Card field index out of bound");
        }
        return magicTrapFields.get(n - 1);
    }

    public List<CardField> getExtraFields() {
        return extraFields;
    }

    public CardField getExtraFields(int n) {
        if (n < 1 || n > 5) {
            throw new RuntimeException("Card field index out of bound");
        }
        return extraFields.get(n - 1);
    }

    public CardField getFieldMagicField() {
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
