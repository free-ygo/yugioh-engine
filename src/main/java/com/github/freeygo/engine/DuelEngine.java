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

import com.github.freeygo.engine.event.EventSystem;

public interface DuelEngine {


    /**
     * 获取引擎当前的执行上下文。
     *
     * @return 引擎执行上下文
     */
    DuelEngineContext getEngineContext();

    /**
     * 设置引擎执行上下文。
     *
     * @param context 引擎执行上下文
     */
    void setEngineContext(DuelEngineContext context);


    /**
     * 发送脚本给引擎执行，并返回指令的结果。
     *
     * @param script 脚本
     * @return 脚本返回结果
     */
    Object send(String script);


    /**
     * 使用指定的{@link DuelContext}作为执行环境执行指定的脚本。
     *
     * @param script  脚本
     * @param context 执行环境上下文
     * @return 脚本返回的结果
     */
    Object send(String script, DuelContext context);

    Object send(CommandArgument argument);

    EventSystem getEventSystem();

    void setEventSystem(EventSystem eventSystem);

    void start(Duel duel);
}
