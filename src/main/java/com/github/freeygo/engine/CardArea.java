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
 * @author Zhi yong Dai
 */
public interface CardArea<T extends CardGrid> {

    /**
     * 返回原来是设置的{@link CardGrid}列表。
     *
     * @return cardGrids
     */
    List<T> getCardGrids();

    /**
     * 设置一个CardGrid列表。
     * 如果参数{@code cardGrids}是空，会抛出{@link IllegalArgumentException}异常，
     * 如果参数{@code cardGrids}包含{@code null}元素，会抛出{@link RuntimeException}
     *
     * @param cardGrids {@link CardGrid}列表
     */
    void setCardGrids(List<T> cardGrids);

    /**
     * 返回一个{@link CardGrid}实现类
     *
     * @param index 指定的 CardGrid 索引
     * @return {@link CardGrid}
     */
    T getCardGrid(int index);

//    /**
//     * Card Area 是否可用
//     * @return true if available, false if unavailable
//     */
//    boolean isAvailable();

//    /**
//     * set available
//     * @param available true is available, false is unavailable
//     */
//    void setAvailable(boolean available);

//    /**
//     *
//     * @param index
//     * @return
//     */
//    boolean isAvailable(int index);


//    void setAvailable(int index, boolean available);

}
