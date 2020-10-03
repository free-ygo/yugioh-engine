package com.github.freeygo.engine;

/**
 * @author 戴志勇
 */
public class StandardRound implements Round {
    /**
     * 回合数
     */
    private Integer number;

    public StandardRound(Integer number) {
        this.number = number;
    }

    @Override
    public Integer getNumber() {
        return number;
    }

    @Override
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * 阶段
     */
    enum StandardPhrase implements Stage {
        /**
         * 开始阶段
         */
        START,
        /**
         * 准备阶段
         */
        PREPARE,
        /**
         * 主要阶段1
         */
        MAIN_1,
        /**
         * 战斗阶段
         */
        BATTLE,
        /**
         * 战斗阶段的开始步骤
         */
        BATTLE_START,
        /**
         * 战斗阶段的战斗步骤
         */
        BATTLE_FIGHT,
        /**
         * 战斗阶段的伤害步骤
         */
        BATTLE_DAMAGE,
        /**
         * 战斗阶段的结束步骤
         */
        BATTLE_END,
        /**
         * 主要阶段2
         */
        MAIN_2,
        /**
         * 结束阶段
         */
        END
    }
}
