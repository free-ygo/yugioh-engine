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

import java.util.Arrays;
import java.util.Objects;

/**
 * @author Zhi yong Dai
 */
public class GameTurn {

    private final Player[] players;
    private int currentTurn;

    public GameTurn(Player[] players) {
        Objects.requireNonNull(players);
        if (players.length != 2) throw new RuntimeException("人数少于2人");
        if (players[0] == players[1]) throw new RuntimeException("同一个人作为两个玩家");

        this.players = players;
        this.currentTurn = 0;
    }

    public int nextTurn() {
        return ++this.currentTurn;
    }

    public Player getTurnPlayer() {
        return players[(this.currentTurn - 1) % players.length];
    }

    public Player getOpponent() {
        return players[this.currentTurn % players.length];
    }

    public int getCurrentTurn() {
        return currentTurn;
    }

    public Player[] getPlayers() {
        return Arrays.copyOf(players, players.length);
    }
}
