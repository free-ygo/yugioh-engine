package com.github.freeygo.engine.event;

/**
 * @author 戴志勇
 */
public enum EventType {
    /**
     * 激活效果事件
     */
    ACTIVATE_EFFECT,
    /**
     * 激活魔法卡事件
     */
    ACTIVATE_MAGIC_EFFECT,
    /**
     * 激活陷阱卡事件
     */
    ACTIVATE_TRAP_EFFECT,
    /**
     * 激活怪兽效果事件
     */
    ACTIVATE_MONSTER_EFFECT,
    /**
     * 召唤事件
     */
    SUMMON,
    /**
     * 通常召唤
     */
    NORMAL_SUMMON,
    /**
     * 特殊召唤
     */
    SPECIAL_SUMMON,
    /**
     * 融合召唤
     */
    FUSION_SUMMON,
    /**
     * 仪式召唤
     */
    CEREMONY_SUMMON,
    /**
     * 抽卡开始事件
     */
    DRAW_START,
    /**
     * 抽卡结束
     */
    DRAW_END,
    /**
     * 卡片数量不足
     */
    CARD_NOT_ENOUGH,
    /**
     * 通常抽卡事件
     */
    NORMAL_DRAW,
    /**
     * 效果抽卡事件
     */
    EFFECT_DRAW,
    /**
     * 阶段过渡事件
     */
    PHRASE_TRANSITION,
    /**
     * 抽卡阶段
     */
    DRAW_PHRASE,
    /**
     * 准备阶段
     */
    PREPARATION_PHRASE,
    /**
     * 主要阶段1
     */
    MAIN_PHRASE_1,
    /**
     * 战斗阶段
     */
    BATTLE_PHRASE,
    /**
     * 战斗阶段——开始步骤
     */
    BATTLE_START,
    /**
     * 战斗阶段——攻击步骤
     */
    BATTLE_FIGHT,
    /**
     * 战斗阶段——伤害步骤
     */
    BATTLE_DAMAGE,
    /**
     * 主要阶段2
     */
    MAIN_PHRASE_2,
    /**
     * 结束阶段
     */
    END_PHRASE,
    /**
     * 卡组卡片不够
     */
    DECK_NO_CARD,
    MOVE_CARD,
}
