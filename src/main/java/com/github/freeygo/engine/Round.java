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

import java.util.List;

/**
 * @author 戴志勇
 */
public interface Round extends Comparable<Round> {
    /**
     * 获得回合数
     *
     * @return 回合数，大于0
     */
    Integer getNumber();

//    void setNumber(int number);

    Stage getCurrentStage();

    void setCurrentStage(Stage stage);

    Stage getNextStage();

    void setNextStage(Stage stage);

    void nextStage();

    Duelist getMainDuelist();

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
        return Integer.compare(getNumber(), another.getNumber());
    }

    /**
     * 一个回合的阶段
     */
    interface Stage {

        void start();

        void end();

        List<Stage> getChildStages();

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


    }
}
