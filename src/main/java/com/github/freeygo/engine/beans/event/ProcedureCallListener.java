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

import java.util.EventListener;

/**
 * @author Zhi yong Dai
 */
public interface ProcedureCallListener<T extends ProcedureCallEvent> extends EventListener {

    interface BeforeCallListener<T2 extends ProcedureCallEvent> extends ProcedureCallListener<T2> {
        /**
         * 调用具体的过程之前，调用该监听器。
         */
        void beforeCall(T2 event);
    }


    interface AfterCallListener<T3 extends ProcedureCallEvent> extends ProcedureCallListener<T3> {
        /**
         * 调用后的事件监听器
         */
        void afterCall(T3 event);
    }
}
