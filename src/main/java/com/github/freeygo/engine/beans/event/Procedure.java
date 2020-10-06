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

package com.github.freeygo.engine.beans.event;

/**
 * @author Zhi yong Dai
 */
public interface Procedure {

    /**
     * 方法名
     */
    String getProcedureName();

    void setProcedureName(String name);

    Object[] getArguments();

    /**
     * 调用参数
     */
    void setArguments(Object... arguments);

    Object getCaller();

    /**
     * 调用者
     */
    void setCaller(Object caller);

    /**
     * 执行过程
     */
    Object call();

    TargetProcedure getTargetProcedure();

    /**
     * 设置真实调用者，实现类从此实现方法体
     */
    void setTargetProcedure(TargetProcedure targetProcedure);

    @FunctionalInterface
    interface TargetProcedure {
        Object performProcedure(Object caller, String method, Object... args);
    }
}
