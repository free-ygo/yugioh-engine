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

import java.util.HashSet;
import java.util.Set;

/**
 * 决斗对象
 *
 * @author Zhiyong Dai
 */
public class Duel {

    private final DuelArena duelArena1;
    private final DuelArena duelArena2;

    public Duel() {
        this(new DuelArena(), new DuelArena());
    }

    public Duel(DuelArena duelArena1, DuelArena duelArena2) {
        this.duelArena1 = duelArena1;
        this.duelArena2 = duelArena2;
    }

    public DuelArena getDuelArena1() {
        return duelArena1;
    }

    public DuelArena getDuelArena2() {
        return duelArena2;
    }

    public void addDuelArena1(Player player) {
        duelArena1.add(player);
        player.setDuelArena(duelArena1);
    }

    public Set<Player> getOpponentPlayers(Player player) {
        if (anyContains(player)) {
            return duelArena1.contains(player) ? duelArena2.getPlayers() :
                    duelArena1.getPlayers();
        }
        throw new RuntimeException("Both do not contains player " + player);
    }

    public DuelArena getOpponentArena(Player player) {
        if (anyContains(player)) {
            return duelArena1.contains(player) ? duelArena2 : duelArena1;
        }
        throw new RuntimeException("Both do not contains player " + player);
    }

    public Set<Player> getPlayers() {
        HashSet<Player> players = new HashSet<>();
        players.addAll(duelArena1.getPlayers());
        players.addAll(duelArena2.getPlayers());
        return players;
    }

    private boolean anyContains(Player player) {
        return duelArena1.contains(player) && duelArena2.contains(player);
    }
}
