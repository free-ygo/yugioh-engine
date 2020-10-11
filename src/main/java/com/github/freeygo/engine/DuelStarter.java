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

import java.util.*;

/**
 * @author Zhi yong Dai
 */
public class DuelStarter {
    public static final int DRAW_PHRASE = 0;
    public static final int PREPARE_PHRASE = 1;
    public static final int MAIN_PHRASE_1 = 2;
    public static final int BATTLE_PHRASE = 3;
    public static final int MAIN_PHRASE_2 = 4;
    public static final int END_PHRASE = 5;


    private final PlayerTurn playerTurn;
    private boolean finish;
    private final Map<Player, DuelArena> arenas;
    private final int basicLifePoint;
    private final LinkedList<TimePoint> timePoints;
    private final LinkedList<Card> effectCards;

    public DuelStarter(int basicLifePoint, PlayerTurn playerTurn) {
        this.playerTurn = playerTurn;
        this.arenas = new HashMap<>();
        this.basicLifePoint = basicLifePoint;
        timePoints = new LinkedList<>();
        this.effectCards = new LinkedList<>();
    }

    public void start() {

    }

    private DuelArena getArena(Player player) {
        DuelArena arena = arenas.get(player);
        if (arena == null) {
            arena = new DuelArena(basicLifePoint, player.getCardDeck());
            arenas.put(player, arena);
        }
        return arena;
    }

    private DuelArena getOpponentArena(Player player) {
        return getArena(playerTurn.getOpponent(player));
    }

    private void startGame() {
        while (!finish) {
            Player player = playerTurn.nextPlayer();
            startTurn(player, new int[]{
                    DRAW_PHRASE,
                    PREPARE_PHRASE,
                    MAIN_PHRASE_1,
                    BATTLE_PHRASE,
                    MAIN_PHRASE_2,
                    END_PHRASE
            });
        }
    }

    private void startTurn(Player player, int[] phrases) {
        for (int phrase : phrases) {
            startPhrase(phrase, player);
        }
    }


    private void mainPhrase1Action(Player player) {
        TimePoint currentTimePoint = new TimePoint();
        currentTimePoint.add(TimePoint.TURN_START);
        timePoints.push(currentTimePoint);
        if (player == null) {
            throw new RuntimeException("玩家人数不足");
        }
        handleEffect(player);
        CardCommand cmd = null;
        List<? extends CardCommand> commands;
        while ((cmd = read(player)) != null && !isFinishTurn(cmd)) {
            if (isActiveEffect(cmd)) {
                commands = chainEffect(player, cmd);
            } else {
                commands = Arrays.asList(cmd);
            }
            handleCommands(commands);
        }
        handleChainEffect();
        if (timePoints.pop() != currentTimePoint) {
            throw new RuntimeException();
        }
    }

    private void startPhrase(int phrase, Player player) {
        switch (phrase) {
            case DRAW_PHRASE:
                drawPhraseAction(player);
                break;
            case PREPARE_PHRASE:
                preparePhraseAction(player);
                break;
            case MAIN_PHRASE_1:
                mainPhrase1Action(player);
                break;
            case BATTLE_PHRASE:
                battlePhraseAction(player);
                break;
            case MAIN_PHRASE_2:
                mainPhrase2Action(player);
                break;
            case END_PHRASE:
                endPhraseAction(player);
                break;
        }
    }

    private void drawPhraseAction(Player player) {
        // 执行抽卡
    }

    private void preparePhraseAction(Player player) {
        // 准备阶段
    }

    private void battlePhraseAction(Player player) {
        // 战斗阶段
    }

    private void mainPhrase2Action(Player player) {
    }

    private void endPhraseAction(Player player) {
    }

    private void handleCommands(List<? extends CardCommand> commands) {

    }

    private void handleChainEffect() {

    }

    private List<ActiveEffectCommand> chainEffect(Player player, CardCommand cmd) {
        TimePoint current = new TimePoint();
        timePoints.push(current);
        Player p = player;
        CardCommand cmd2 = cmd;
        CardCommand lastCmd = cmd;
        List<ActiveEffectCommand> commands = new ArrayList<>();
        while (isActiveEffect(cmd2) || isActiveEffect(lastCmd)) {
            ActiveEffectCommand aec = (ActiveEffectCommand) cmd2;
            commands.add(aec);
            // TODO 优先权轮流
//             TODO 检索是否有可发动的效果
            p = playerTurn.getOpponent(p);
            cmd2 = read(p);
            lastCmd = cmd2;
        }
        if (timePoints.pop() != current) {
            throw new RuntimeException();
        }
        return commands;
    }

    private void activeEffect(Card card) {

    }

    private boolean isActiveEffect(CardCommand cmd) {
        return cmd.getCommandType() == CardCommand.ACTIVE_EFFECT;
    }

    private boolean isFinishTurn(CardCommand cmd) {
        return cmd.getCommandType() == CardCommand.TURN_FINISH;
    }

    private void handleEffect(Player player) {

    }

    private CardCommand read(Player player) {
        return null;
    }

    private void execute(CardCommand cmd) {
        if (cmd == null) return;
        cmd.execute();
    }
}
