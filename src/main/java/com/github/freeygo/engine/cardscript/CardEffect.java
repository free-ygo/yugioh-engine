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

package com.github.freeygo.engine.cardscript;

import com.github.freeygo.engine.Duelist;
import com.github.freeygo.engine.RoundRange;
import com.github.freeygo.engine.StageRange;
import com.github.freeygo.engine.cardscript.EffectListener.AfterActiveEffectListener;

import java.util.function.Predicate;

import static com.github.freeygo.engine.cardscript.EffectListener.BeforeActiveEffectListener;

/**
 * 效果就是：当满足什么样的条件时，可以触发某些动作。所以脚本书写者必须注册某些关键的东西，例如：
 * 有以下几种可能的触发情形：
 * 主动式触发：在条件满足的情况下，可以由玩家主动触发。
 * 被动式触发：在条件满足的情况下，可以由系统自动触发。
 * 主被式触发：主动或者被动触发后，可以由系统自动触发。
 *
 * @author 戴志勇
 */
public interface CardEffect<T extends EffectTargetObject, S, R> {
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

    void addAfterActiveEffectListener(AfterActiveEffectListener listener);

    void removeAfterActiveEffectListener(AfterActiveEffectListener listener);

    void addBeforeActiveEffectListener(BeforeActiveEffectListener listener);

    void removeBeforeActiveEffectListener(BeforeActiveEffectListener listener);


//    /**
//     * 是效果对象
//     *
//     * @param t
//     * @return
//     */
//    boolean isEffectTarget(Predicate<T> t);

    /**
     * 是否满足效果发动条件
     *
     * @param t 效果对象
     * @return true:适用效果对象，false: 不适用效果对象
     */
    boolean isAvailable(T[] effectTargetObjects);

    void setAvailable(Predicate<T[]> condition);

    boolean isActionable(T[] effectTargetObjects);

    void setActionable(Predicate<T[]> condition);


    /**
     * 当{@link #isAvailable(Object)}适用效果对象的时候，会立即执行。
     *
     * @param t
     */
    void active(T[] effectTargetObjects);


    void action(T t);

//    /**
//     * 获取发动条件
//     *
//     * @return 发动条件
//     */
//    Predicate<T> getCondition();
//
//    /**
//     * 设置发动条件
//     *
//     * @param condition 发动条件
//     */
//    void setCondition(Predicate<T> condition);


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

//    /**
//     * 获得效果对象
//     */
//    T[] getEffectTarget();
//
//    /**
//     * 效果对象
//     */
//    void setEffectTarget(T[] target);

//    /** 获取可用的效果对象 */
//    T[] getAvailableEffectTargets();

//    /** 可供作为代价的对象 */
//    Object[] getAvailableCosts();

    Duelist getController();
//
//    void setController(Duelist duelist);


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

//    /**
//     * 回合
//     */
//    interface Round extends Comparable<Round> {
//        /**
//         * 获得回合数
//         *
//         * @return 回合数，大于0
//         */
//        int getRoundNumber();
//
//        /**
//         * 是否处于回合之间
//         *
//         * @param start 开始回合（包括）
//         * @param end   结束回合（包括）
//         * @return 处于返回true，不处于返回false
//         */
//        default boolean between(Round start, Round end) {
//            return start != null && end != null &&
//                    compareTo(start) > -1 && compareTo(end) < 1;
//        }
//
//        /**
//         * 回合比较
//         *
//         * @param another 另一个回合
//         * @return 返回-1、0或者1，分别对应小于、等于或大于另一个回合
//         */
//        default int compareTo(Round another) {
//            return Integer.compare(getRoundNumber(), another.getRoundNumber());
//        }
//    }


}