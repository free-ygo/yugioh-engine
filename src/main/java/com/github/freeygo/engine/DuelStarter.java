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

import com.github.freeygo.engine.cardscript.Effect;

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
    private boolean gameOver;
    private final Map<Player, DuelArena> arenas;
    private final int basicLifePoint;
    private final LinkedList<TimePointSet> timePointSets;
    private final LinkedList<Effect> effectCards;

    public DuelStarter(int basicLifePoint, PlayerTurn playerTurn) {
        this.playerTurn = playerTurn;
        this.arenas = new HashMap<>();
        this.basicLifePoint = basicLifePoint;
        timePointSets = new LinkedList<>();
        this.effectCards = new LinkedList<>();
    }

    public void start() {
        startGame();
    }

    private void startGame() {
        int turn = 0;
        while (!gameOver) {
            setTurn(++turn);
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

    private void setTurn(int i) {

    }

    private void startTurn(Player player, int[] phrases) {
        for (int phrase : phrases) {
            startPhrase(phrase, player);
        }
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




    private void mainPhrase1Action(Player player) {
        TimePointSet currentTimePointSet = new TimePointSet();
        currentTimePointSet.add(TimePointSet.MAIN_PHRASE_1);
        timePointSets.push(currentTimePointSet);
        if (player == null) {
            throw new RuntimeException("玩家人数不足");
        }
        String test = "";
        // 处理效果
        activeEffectsFlow(effectCards);
        Command cmd;
        List<? extends Command> commands;
        while ((cmd = read(player)) != null && !isFinishTurn(cmd)) {
            if (isActiveEffect(cmd)) {
                commands = chainEffect(player, cmd);
            } else {
                commands = Arrays.asList(cmd);
            }
            handleCommands(commands);
        }
        handleChainEffect();
        if (timePointSets.pop() != currentTimePointSet) {
            throw new RuntimeException();
        }
    }

    private void activeEffectsFlow(LinkedList<Effect> needHandleEffects) {
        while (needHandleEffects != null && !needHandleEffects.isEmpty()) {
            LinkedList<TimePointSet> effectsTps = handleEffects(needHandleEffects);
            LinkedList<Effect> needActiveEffects = notifyTimePoints(effectsTps);
            // TODO 依次发动效果
            needHandleEffects = activeEffects(needActiveEffects);
        }
    }

    private LinkedList<Effect> notifyTimePoints(LinkedList<TimePointSet> effectsTps) {
        return null;
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

    private void handleCommands(List<? extends Command> commands) {

    }

    private void handleChainEffect() {

    }

    private List<ActiveEffectCommand> chainEffect(Player player, Command cmd) {
        TimePointSet current = new TimePointSet();
        timePointSets.push(current);
        Player p = player;
        Command cmd2 = cmd;
        Command lastCmd = cmd;
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
        if (timePointSets.pop() != current) {
            throw new RuntimeException();
        }
        return commands;
    }

    private LinkedList<Effect> activeEffects(LinkedList<Effect> effects) {
        // 按照优先级发动效果

        return effects;
    }

    private boolean isActiveEffect(Command cmd) {
        return cmd.getCommandType() == Command.ACTIVE_EFFECT;
    }

    private boolean isFinishTurn(Command cmd) {
        return cmd.getCommandType() == Command.TURN_FINISH;
    }

    /**
     * 处理效果，并返回处理效果时发生的时点
     */
    private LinkedList<TimePointSet> handleEffects(LinkedList<Effect> effects) {
        ListIterator<Effect> it = effects.listIterator(effects.size());
        LinkedList<TimePointSet> timePointSets = new LinkedList<>();
        while (it.hasPrevious()) {
            Effect effect = it.previous();
            // TODO 这里判断并处理卡片效果
            timePointSets.addAll(effect.action());
        }
        return timePointSets;
    }

    private Command read(Player player) {
        return null;
    }

    private void execute(Command cmd) {
        if (cmd == null) return;
        cmd.execute();
    }
}
