package com.github.freeygo.engine.cardscript;

public interface Event {

    /**
     * 激活效果事件
     */
    int ACTIVATE_EFFECT = 1000;
    /**
     * 激活魔法卡事件
     */
    int ACTIVATE_MAGIC_EFFECT = 1001;
    /**
     * 激活陷阱卡事件
     */
    int ACTIVATE_TRAP_EFFECT = 1002;
    /**
     * 激活怪兽效果事件
     */
    int ACTIVATE_MONSTER_EFFECT = 1003;
    /**
     * 召唤事件
     */
    int SUMMON = 1100;
    /**
     * 通常召唤
     */
    int NORMAL_SUMMON = 1101;
    /**
     * 特殊召唤
     */
    int SPECIAL_SUMMON = 1102;
    /**
     * 融合召唤
     */
    int FUSION_SUMMON = 1103;
    /**
     * 仪式召唤
     */
    int CEREMONY_SUMMON = 1104;
    /**
     * 抽卡事件
     */
    int DRAW_CARD = 1200;
    /**
     * 通常抽卡事件
     */
    int NORMAL_DRAW = 1201;
    /**
     * 效果抽卡事件
     */
    int EFFECT_DRAW = 1202;
    /**
     * 阶段过渡事件
     */
    int PHRASE_TRANSITION = 1300;
    /**
     * 抽卡阶段
     */
    int DRAW_PHRASE = 1301;
    /**
     * 准备阶段
     */
    int PREPARATION_PHRASE = 1302;
    /**
     * 主要阶段1
     */
    int MAIN_PHRASE_1 = 1303;
    /**
     * 战斗阶段
     */
    int BATTLE_PHRASE = 1304;
    /**
     * 战斗阶段——开始步骤
     */
    int BATTLE_START = 1305;
    /**
     * 战斗阶段——攻击步骤
     */
    int BATTLE_FIGHT = 1306;
    /**
     * 战斗阶段——伤害步骤
     */
    int BATTLE_DAMAGE = 1307;
    /**
     * 主要阶段2
     */
    int MAIN_PHRASE_2 = 1308;
    /**
     * 结束阶段
     */
    int END_PHRASE = 1309;
    /**
     * 卡组卡片不够
     */
    int DECK_NO_CARD = 1401;


    Object getTarget();

    int getEventType();
}
