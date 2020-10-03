package com.github.freeygo.engine;

/**
 * @author 戴志勇
 */
public interface CommonAction {

    /**
     * 从卡组抽牌
     *
     * @param duelDisk 决斗盘
     * @#param count 抽取卡牌数量
     */
    void draw(DuelDisk duelDisk, int count);

    /**
     * 召唤怪兽卡到指定区域。
     *
     * @param card     怪兽卡
     * @param cardArea
     */
    void summon(MonsterCard card, CardArea cardArea);

//    void
}
