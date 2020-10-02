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
     * 设置效果生效时间。
     *
     * @param start 有效开始时间
     * @param end   有效结束时间
     */
//    void setWorkTime(int start, int end);

//    /**
//     * 设置效果作用对象
//     *
//     * @param duel 效果生效对象
//     */
//    void setWorkObject(Object duel);

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

    void setSource(S source);

    T getTarget();
//    Duelist getController();
//
//    void setController(Duelist duelist);

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

    StageRange getEffectiveStage();

    RoundRange getEffectRound();

    void setEffectRound(RoundRange range);

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
        EFFECT, NORMAL, SYSTEM
    }

    enum EffectStatus {
        INACTIVATE, ACTIVATE, WORK, INVALID,
    }

    interface Round extends Comparable<Round> {
        int getRoundNumber();

        default boolean between(Round start, Round end) {
            return start != null && end != null &&
                    compareTo(start) > -1 && compareTo(end) < 1;
        }

        default int compareTo(Round o) {
            return Integer.compare(getRoundNumber(), o.getRoundNumber());
        }
    }

    interface Stage {

        default boolean between(Stage from, Stage to) {
            return from != null && to != null &&
                    from.ordinal() <= ordinal() &&
                    ordinal() >= to.ordinal();
        }

        int ordinal();


        enum Phrase implements Stage {
            START,
            PREPARE,
            MAIN_1,
            BATTLE,
            BATTLE_START,
            BATTLE_FIGHT,
            BATTLE_DAMAGE,
            BATTLE_END,
            MAIN_2,
            END

        }



    /*
    如果这张卡片被送入墓地，对手的全部魔法卡和陷阱卡被破坏。
     */
    }

    class RoundRange {
        Round start;
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