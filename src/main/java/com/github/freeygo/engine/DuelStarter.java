///*
// * Copyright (c) 2020 free-ygo
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *     http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//package com.github.freeygo.engine;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
///**
// * 决斗启动器
// *
// * @author Zhi yong Dai
// */
//public class DuelStarter {
//    public static final int DRAW_PHRASE = 0;
//    public static final int PREPARE_PHRASE = 1;
//    public static final int MAIN_PHRASE_1 = 2;
//    public static final int BATTLE_PHRASE = 3;
//    public static final int MAIN_PHRASE_2 = 4;
//    public static final int END_PHRASE = 5;
//
//
//    private final DuelContext context;
//    private final GameTurn gameTurn;
//    private boolean gameOver;
//    private final Map<Player, DuelArena> arenas;
//    private final LinkedList<TimePointSet> timePointSets;
//    private final LinkedList<Effect> effectCards;
//    private final List<Effect> appliedEffects;
//
//    public DuelStarter(GameTurn gameTurn) {
//        this.gameTurn = gameTurn;
//        this.arenas = new HashMap<>();
//        this.timePointSets = new LinkedList<>();
//        this.effectCards = new LinkedList<>();
//        this.appliedEffects = new ArrayList<>();
//        this.context = new DuelContext();
//    }
//
//    private void initContext() {
//        this.context.setGameTurn(gameTurn);
//    }
//
//    public void start() {
//        startGame();
//    }
//
//    private void startGame() {
//        while (!gameOver) {
//            gameTurn.nextTurn();
//            Player player = gameTurn.getTurnPlayer();
//            startTurn(player, new int[]{
//                    DRAW_PHRASE,
//                    PREPARE_PHRASE,
//                    MAIN_PHRASE_1,
//                    BATTLE_PHRASE,
//                    MAIN_PHRASE_2,
//                    END_PHRASE
//            });
//        }
//    }
//
//    private void startTurn(Player player, int[] phrases) {
//        for (int phrase : phrases) {
//            startPhrase(phrase, player);
//        }
//    }
//
//    private DuelArena getArena(Player player) {
//        DuelArena arena = arenas.get(player);
//        if (arena == null) {
//            arena = new DuelArena(player.getDeck());
//            arenas.put(player, arena);
//        }
//        return arena;
//    }
//
//    private DuelArena getOpponentArena(Player player) {
//        return getArena(gameTurn.getOpponent());
//    }
//
//    private void mainPhrase1(Player player) {
//        TimePointSet currentTimePointSet = new TimePointSet();
//        currentTimePointSet.add(TimePointSet.MAIN_PHRASE_1);
//        timePointSets.push(currentTimePointSet);
//        if (player == null) {
//            throw new RuntimeException("玩家人数不足");
//        }
//        // 处理效果
//        activeEffectsFlow(effectCards);
//        Command cmd;
//        List<? extends Command> commands;
//        while ((cmd = read(player)) != null && !isFinishTurn(cmd)) {
//            if (isActiveEffect(cmd)) {
//                commands = chainEffect(player, cmd);
//            } else {
//                commands = Arrays.asList(cmd);
//            }
//            handleCommands(commands);
//        }
//        handleChainEffect();
//        if (timePointSets.pop() != currentTimePointSet) {
//            throw new RuntimeException();
//        }
//    }
//
//    private void activeEffectsFlow(LinkedList<Effect> needHandleEffects) {
//        while (needHandleEffects != null && !needHandleEffects.isEmpty()) {
//            LinkedList<TimePointSet> effectsTps = handleEffects(needHandleEffects);
//            LinkedList<Effect> needActiveEffects = notifyTimePoints(effectsTps);
//            // TODO 依次发动效果
//            needHandleEffects = activeEffects(needActiveEffects);
//        }
//    }
//
//    private LinkedList<Effect> notifyTimePoints(LinkedList<TimePointSet> effectsTps) {
//        return null;
//    }
//
//    private void startPhrase(int phrase, Player player) {
//        switch (phrase) {
//            case DRAW_PHRASE:
//                drawPhrase(player);
//                break;
//            case PREPARE_PHRASE:
//                preparePhrase(player);
//                break;
//            case MAIN_PHRASE_1:
//                mainPhrase1(player);
//                break;
//            case BATTLE_PHRASE:
//                battlePhrase(player);
//                break;
//            case MAIN_PHRASE_2:
//                mainPhrase2(player);
//                break;
//            case END_PHRASE:
//                endPhrase(player);
//                break;
//            default:
//                throw new RuntimeException("Unknown phrase");
//        }
//    }
//
//    private void drawPhrase(Player player) {
//        // 遍历回合玩家可以在此时点适用的已发动效果
//        // 若可以发动效果，设置超时时间等待回合玩家发出命令。
//        // 遍历对手玩家可以在此时点发动的效果
//        // 若可以发动效果，设置超时间等待对方玩家发出命令。
//
//        // 等待玩家操作
//        // 适用效果已经完成了适用，以及特定效果已经完成了激活和适用：
//        // 抽卡
//        // 玩家发动卡片时间
//        // 双发放弃卡片发动权，进入下一阶段
//        // TODO 设置时点
//        TimePointSet tps = new TimePointSet();
//        tps.add(TimePointSet.DRAW_PHRASE);
//        handleAppliedEffects(effectCards);
//        List<Effect> effects = effectCards.stream().filter(e -> e.getActiveCondition().containsAny(tps))
//                .collect(Collectors.toList());
//        System.out.println(player.getName() + "可以发动：" + effects);
//        Command cmd = cmdReader.read(player);
//        System.out.println("处理：" + cmd);
//        // 等待回合玩家命令
//        Command<TimePointSet> c1 = cmdReader.read(player);
//        Command<TimePointSet> c2 = cmdReader.read(gameTurn.getOpponent());
//
//    }
//
//    private List<TimePointSet> handleAppliedEffects(List<Effect> effects) {
//        // 效果处理步骤产生的时点不立即处理
//        List<TimePointSet> appliedEffectTps = new ArrayList<>();
//        do {
//            List<TimePointSet> produceTps = applyEffects(effects);
//            if (produceTps.isEmpty()) break;
//            appliedEffectTps.addAll(produceTps);
//        } while (true);
//        return appliedEffectTps;
//    }
//
//    private boolean executeCommand(String cmd) {
//        return true;
//    }
//
//    private void preparePhrase(Player player) {
//        // 准备阶段
//    }
//
//    private void battlePhrase(Player player) {
//        // 战斗阶段
//    }
//
//    private void mainPhrase2(Player player) {
//    }
//
//    private void endPhrase(Player player) {
//    }
//
//    private void handleCommands(List<? extends Command> commands) {
//
//    }
//
//    private void handleChainEffect() {
//
//    }
//
//    private void exit() {
//        System.out.println("游戏结束");
//    }
//
//    private List<TimePointSet> applyEffects(List<Effect> effects) {
//        return appliedEffects.stream()
//                .filter(e -> e.getActiveCondition().canApply(this.context))
//                .map(Effect::applyEffect).reduce(new ArrayList<TimePointSet>(), (a, b) -> {
//                    a.addAll(b);
//                    return a;
//                }, (a, b) -> {
//                    a.addAll(b);
//                    return a;
//                });
//    }
//
//    private List<ActiveEffectCommand> chainEffect(Player player, Command cmd) {
//        TimePointSet current = new TimePointSet();
//        timePointSets.push(current);
//        Player p = player;
//        Command cmd2 = cmd;
//        Command lastCmd = cmd;
//        List<ActiveEffectCommand> commands = new ArrayList<>();
//        while (isActiveEffect(cmd2) || isActiveEffect(lastCmd)) {
//            ActiveEffectCommand aec = (ActiveEffectCommand) cmd2;
//            commands.add(aec);
//            // TODO 优先权轮流
////             TODO 检索是否有可发动的效果
//            p = gameTurn.getOpponent();
//            cmd2 = read(p);
//            lastCmd = cmd2;
//        }
//        if (timePointSets.pop() != current) {
//            throw new RuntimeException();
//        }
//        return commands;
//    }
//
//    private LinkedList<Effect> activeEffects(LinkedList<Effect> effects) {
//        // 按照优先级发动效果
//
//        return effects;
//    }
//
//    private boolean isActiveEffect(Command cmd) {
//        return cmd.getCommandType() == Command.ACTIVE_EFFECT;
//    }
//
//    private boolean isFinishTurn(Command cmd) {
//        return cmd.getCommandType() == Command.TURN_FINISH;
//    }
//
//    /**
//     * 处理效果，并返回处理效果时发生的时点
//     */
//    private LinkedList<TimePointSet> handleEffects(LinkedList<Effect> effects) {
//        ListIterator<Effect> it = effects.listIterator(effects.size());
//        LinkedList<TimePointSet> timePointSets = new LinkedList<>();
//        while (it.hasPrevious()) {
//            Effect effect = it.previous();
//            // TODO 这里判断并处理卡片效果
//            timePointSets.addAll(effect.applyEffect());
//        }
//        return timePointSets;
//    }
//
//    private Command read(Player player) {
//        return null;
//    }
//
//    private void execute(Command cmd) {
//        if (cmd == null) return;
//        cmd.execute();
//    }
//}
