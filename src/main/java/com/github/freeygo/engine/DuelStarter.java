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

/**
 * @author Zhi yong Dai
 */
public class DuelStarter {

    private final PlayerTurn playerTurn;
    private final DuelContext context;
    private boolean finish;

    public DuelStarter(PlayerTurn playerTurn) {
        this.playerTurn = playerTurn;
        this.context = new StandardDuelContext();
    }

    public void start() {
        while (!finish) {
            Player player = playerTurn.nextPlayer();
            startTurn(player);
        }
    }

    private void startTurn(Player player) {
        if (player == null) {
            throw new RuntimeException("玩家人数不足");
        }
        handleEffect(player);
        PlayerCommand pc = null;
        while ((pc = read(player)) != null && !pc.isFinishTurn()) {
            if (pc.isActiveEffect()) {
                chainEffect(player, pc);
            } else {
                execute(pc);
            }
        }
        handleChainEffect();


    }

    private void handleChainEffect() {

    }

    private void chainEffect(Player player, PlayerCommand pc) {
        Player opponent = playerTurn.getOpponent(player);
        PlayerCommand pc2 = pc;
        while (pc2.isActiveEffect()) {
            // 优先权轮流
            pc2 = read(opponent);
        }
    }

    private void handleEffect(Player player) {

    }

    private PlayerCommand read(Player player) {
        return null;
    }

    private void execute(PlayerCommand playerCommand) {
        if (playerCommand == null) return;
        // TODO execute command
    }
}
