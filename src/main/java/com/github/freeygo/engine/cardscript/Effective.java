package com.github.freeygo.engine.cardscript;

import java.util.function.Predicate;

/**
 * @author 戴志勇
 */
public interface Effective<T, S, R> {
    /*
    效果有效时间：
    发动回合
    发动回合至数回合内。
    发动卡片离场前

    效果发动时机
    效果生效时机

    卡片生命周期：
    卡组     -----> 手牌 --> 场地 -> 墓地
    效果生命周期：
    未发动 -> 发动 -> 生效 -> 失效
     */

//    /**
//     * 效果状态初始化。
//     */
//    void initEffect();


//    /**
//     * 发动效果。
//     * @param event 事件对象
//     * @return 效果处理结果。
//     */
//    Object active(Event event);


    /**
     * 是效果对象
     *
     * @param t
     * @return
     */
    boolean isTarget(T t);

    /**
     * 是否满足效果发动条件
     *
     * @param t 效果对象
     * @return true:适用效果对象，false: 不适用效果对象
     */
    boolean isAvailable(T t);

    /**
     * 当{@link #isAvailable(Object)}适用效果对象的时候，会立即执行。
     *
     * @param t
     * @return
     */
    R execute(T t);

    /**
     * 获取发动条件
     *
     * @return 发动条件
     */
    Predicate<T> getCondition();

    /**
     * 设置发动条件
     *
     * @param condition 发动条件
     */
    void setCondition(Predicate<T> condition);



    /**
     * 效果状态：未发动，发动时，生效，失效。
     *
     * @return 效果状态
     */
    EffectStatus getStatus();

    /**
     * 设置效果状态
     *
     * @param status 未发动，发动中，生效，失效。
     */
    void setStatus(EffectStatus status);

    ActionScript getScript();

    /**
     * 设置效果脚本
     *
     * @param script 效果脚本
     */
    void setScript(ActionScript script);

//    void setDuel(Duel duel);

    /**
     * 作为效果对象的时候。
     *
     * @param event 作为效果对象
     */
    void notifyEvent(Object event);

    EffectSpeed getEffectSpeed();

    void setEffectSpeed(EffectSpeed speed);

    S getSource();

    /**
     * 设置效果来源
     */
    void setSource(S source);

    /**
     * 获得效果对象
     */
    T getTarget();
//    Duelist getController();
//
//    void setController(Duelist duelist);

    /**
     * 效果对象
     */
    void setTarget(T target);

    int getCost();

    void setCost(int cost);

    EffectType getEffectType();

    void setEffectType(EffectType effectType);

    CommandType getCommandType();

    void setEffectiveRange(StageRange range);

//    void setRound(int round);
//
//    int getRound();

//    void setRange(int start, int end);

//    void setCommandType(CommandType type);

    /** 返回效果生效阶段 */
    StageRange getEffectiveStage();

    /** 返回效果生效回合 */
    RoundRange getEffectRound();

    /** 设置效果生效回合 */
    void setEffectRound(RoundRange range);

    /** 设置效果速度 */
    enum EffectSpeed {
        NONE, SPEED_1, SPEED_2, SPEED_3,
    }

    /**
     * 怪兽效果类型
     */
    enum EffectType {
        /**
         * 非效果
         */
        NONE,
        /**
         * 永续效果
         */
        CONTINUOUS,
        /**
         * 启动效果
         */
        START,
        /**
         * 诱发效果
         */
        INDUCE,
        /**
         * 诱发即时
         */
        IMMEDIATE,
        /**
         * 其他效果（无种类效果）
         */
        OTHER,
    }

    /**
     * 是效果命令，还是普通命令
     */
    enum CommandType {
        /**
         * 效果命令
         */
        EFFECT,
        /**
         * 普通命令
         */
        NORMAL,
        /**
         * 系统命令
         */
        SYSTEM
    }

    /**
     * 效果状态
     */
    enum EffectStatus {
        /**
         * 未发动状态
         */
        INACTIVATE,
        /**
         * 激活状态
         */
        ACTIVATE,
        /**
         * 生效状态
         */
        WORK,
        /**
         * 失效状态
         */
        INVALID,
    }

    /**
     * 回合
     */
    interface Round extends Comparable<Round> {
        /**
         * 获得回合数
         *
         * @return 回合数，大于0
         */
        int getRoundNumber();

        /**
         * 是否处于回合之间
         *
         * @param start 开始回合（包括）
         * @param end   结束回合（包括）
         * @return 处于返回true，不处于返回false
         */
        default boolean between(Round start, Round end) {
            return start != null && end != null &&
                    compareTo(start) > -1 && compareTo(end) < 1;
        }

        /**
         * 回合比较
         *
         * @param another 另一个回合
         * @return 返回-1、0或者1，分别对应小于、等于或大于另一个回合
         */
        default int compareTo(Round another) {
            return Integer.compare(getRoundNumber(), another.getRoundNumber());
        }
    }

    /**
     * 一个回合的阶段
     */
    interface Stage {

        /**
         * 本对象是否处于指定阶段之间。
         *
         * @param start 指定的起始阶段（包括）
         * @param end   指定的结束阶段（包括）
         * @return 若处于指定阶段返回true，否则返回false。
         */
        default boolean between(Stage start, Stage end) {
            return start != null && end != null &&
                    start.ordinal() <= ordinal() &&
                    ordinal() >= end.ordinal();
        }

        /**
         * 阶段排序
         *
         * @return 从0开始，最多到{@link Integer#MAX_VALUE}
         */
        int ordinal();


        /**
         * 阶段
         */
        enum Phrase implements Stage {
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

    /**
     * 回合范围
     */
    class RoundRange {
        /**
         * 回合开始
         */
        Round start;
        /**
         * 回合结束
         */
        Round end;

        public RoundRange(Round start, Round end) {
            this.start = start;
            this.end = end;
        }

        public Round getStart() {
            return start;
        }

        public void setStart(Round start) {
            this.start = start;
        }

        public Round getEnd() {
            return end;
        }

        public void setEnd(Round end) {
            this.end = end;
        }
    }

    /**
     * 阶段范围
     */
    class StageRange {
        private Stage start;
        private Stage end;

        public StageRange(Stage start, Stage end) {
            this.start = start;
            this.end = end;
        }

        public Stage getStart() {
            return start;
        }

        public void setStart(Stage start) {
            this.start = start;
        }

        public Stage getEnd() {
            return end;
        }

        public void setEnd(Stage end) {
            this.end = end;
        }
    }
}