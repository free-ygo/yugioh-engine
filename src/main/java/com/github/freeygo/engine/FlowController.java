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
 * @author Zhi yong Dai
 */
public class FlowController {

    private final Player[] players;
    private int currentTurn;
    private Flow flow;


    public FlowController(Player[] players) {
        Objects.requireNonNull(players);
        if (players.length != 2) throw new RuntimeException("人数少于2人");
        if (players[0] == players[1]) throw new RuntimeException("同一个人作为两个玩家");
        this.currentTurn = 0;
        this.players = Arrays.copyOf(players, players.length);
        Arrays.sort(this.players);
    }

    public int nextTurn() {
        return ++this.currentTurn;
    }

    public Player getTurnPlayer() {
        return players[(this.currentTurn - 1) % players.length];
    }

    public Player getNextPlayer(Player player) {
        if (getTurnNum(player) < 0) {
            return null;
        }
        return players[(getTurnNum(player) + 1) % players.length];
    }

    public int getCurrentTurn() {
        return currentTurn;
    }

    public Player[] getPlayers() {
        return Arrays.copyOf(players, players.length);
    }

    public void setCurrentFlow(Flow flow) {
        if (flow == null) return;
        this.flow = flow;
    }

    private int getTurnNum(Player player) {
        for (int i = 0; i < players.length; i++) {
            if (players[i] == player) {
                return i;
            }
        }
        return -1;
    }

    public void startFlow(Flow flow) {

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
}
