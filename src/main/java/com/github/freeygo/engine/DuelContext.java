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

public interface DuelContext {

//    /**
//     * 决斗环境上下文中的属性名为{@code name}的属性。
//     *
//     * @param name 属性名称
//     * @param <T>  属性类型
//     * @return 属性值
//     */
//    <T> T getAttribute(String name);
//
//
//    /**
//     * 为当前的执行上下文添加一个名为{@code name}，值为{@code value}的属性。
//     *
//     * @param name  属性名
//     * @param value 属性值
//     */
//    void setAttribute(String name, Object value);

//    DuelistPair getDuelistPair();

//    EventSystem getEventSystem();

//    DuelEngine getDuelEngine();
//
//    Round nextRound();
//    DuelistAccessor getDuelistAccessor();

    RoundAccessor getRoundAccessor();


}
