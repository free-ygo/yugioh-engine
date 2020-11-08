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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author Zhi yong Dai
 */
public class FlowController {

    private final DuelContext context;
    private final RoundDial roundDial;
    private final List<Flow> flows;
    private int currentFlow;
    private boolean end;


    public FlowController(RoundDial roundDial, List<Flow> flows, DuelContext context) {
        if (flows == null || flows.isEmpty()) {
            throw new RuntimeException("Flows cannot be empty");
        }
        Objects.requireNonNull(roundDial, "roundDial cannot be null");
        Objects.requireNonNull(context, "context cannot be null");
        this.roundDial = roundDial;
        this.flows = new ArrayList<>(flows);
        this.context = context;
        this.currentFlow = 0;
    }

    @Deprecated
    public void nextRound() {
        roundDial.nextRound();
    }

    @Deprecated
    public Player getRoundPlayer() {
        return roundDial.getRoundPlayer();
    }

    @Deprecated
    public Player getNextPlayer(Player player) {
        return roundDial.getNextPlayer(player);
    }

    @Deprecated
    public int getCurrentRound() {
        return roundDial.getCurrentRound();
    }

    @Deprecated
    public Player[] getPlayers() {
        return roundDial.getPlayers().toArray(new Player[0]);
    }

    public void enter() {
        if (!isEnd()) {
            getCurrentFlow().getFlowAction().action(context);
        }
    }

    public void enter(Flow flow) {
        setCurrentFlow(flow);
        enter();
    }

    public Flow getCurrentFlow() {
        return flows.get(currentFlow);
    }

    public void setCurrentFlow(Flow flow) {
        if (flow == null) return;
        for (int i = 0; i < flows.size(); i++) {
            if (Objects.equals(flow, flows.get(i))) {
                currentFlow = i;
                break;
            }
        }
    }

    public Flow next() {
        currentFlow = (currentFlow + 1) % flows.size();
        return getCurrentFlow();
    }


    /**
     * 从指定的player按游戏顺序开始轮转，直到某个条件成立为止。
     *
     * @param player        开始轮转的玩家（包括）
     * @param stopCondition true：停止轮转，false：继续轮转。
     * @param action        当前轮转的玩家执行的动作。
     */
    public void roundUntil(Player player, Predicate<Player> stopCondition, Consumer<Player> action) {
        roundDial.roundUntil(player, stopCondition, action);
    }

    public void roundUntil(Player starter, BiFunction<Player, Player, Player> starterSupplier,
                           Predicate<Player> stopCondition, Consumer<Player> action) {
        roundDial.roundUntil(starter, starterSupplier, stopCondition, action);
    }

    public boolean isEnd() {
        return end;
    }

    public void end() {
        end = true;
    }
}
