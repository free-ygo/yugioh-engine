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
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author Zhiyong Dai
 */
public class RoundDial {

    private Player[] players;
    private int currentRound;
    private Player roundPlayer;

    public RoundDial(Player[] players, boolean sorted) {
        this.players = players;
        this.currentRound = 0;
        this.players = Arrays.copyOf(players, players.length);
        Arrays.sort(players);
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public void nextRound() {
        this.roundPlayer = players[++currentRound % players.length];
    }

    public Player getRoundPlayer() {
        return roundPlayer;
    }

    public Player getNextPlayer(Player player) {
        for (int i = 0; i < players.length; i++) {
            if (Objects.equals(player, players[(i + 1) % players.length])) {
                return players[(i + 1) % players.length];
            }
        }
        return null;
    }

    public Player[] getPlayers() {
        return Arrays.copyOf(players, players.length);
    }

    /**
     * 从指定的player按游戏顺序开始轮转，直到某个条件成立为止。
     *
     * @param player        开始轮转的玩家（包括）
     * @param stopCondition true：停止轮转，false：继续轮转。
     * @param action        当前轮转的玩家执行的动作。
     */
    public void roundUntil(Player player, Predicate<Player> stopCondition, Consumer<Player> action) {
        int turnNum = getTurnNum(player);
        if (turnNum < 0) {
            throw new RuntimeException("玩家不存在");
        }
        Player nextPlayer = player;
        while (stopCondition.test(nextPlayer)) {
            action.accept(player);
            nextPlayer = getNextPlayer(player);
        }
    }

    public void roundUntil(Player starter, BiFunction<Player, Player, Player> starterSupplier,
                           Predicate<Player> stopCondition, Consumer<Player> action) {
        int turnNum = getTurnNum(starter);
        if (turnNum < 0) {
            throw new RuntimeException("玩家不存在");
        }
        if (!stopCondition.test(starter)) {
            return;
        }
        Player cp;
        Player sp = starter;
        Player np = starter;
        do {
            cp = np;
            action.accept(cp);
            np = getNextPlayer(cp);
            sp = starterSupplier.apply(sp, np);
        } while (!Objects.equals(np, sp) && stopCondition.test(np));
    }

    private int getTurnNum(Player player) {
        for (int i = 0; i < players.length; i++) {
            if (players[i] == player) {
                return i;
            }
        }
        return -1;
    }
}
