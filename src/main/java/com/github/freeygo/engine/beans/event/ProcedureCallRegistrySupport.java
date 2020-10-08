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

import com.github.freeygo.engine.beans.event.EventListenerRegistry.ProcedureCallListenerRegistry;

/**
 * @author Zhi yong Dai
 */
public class ProcedureCallRegistrySupport<T extends ProcedureCallEvent> implements ProcedureCallListenerRegistry<T> {


    @Override
    public void register(String listenerGroup, ProcedureCallListener<T> listener) {

    }

    @Override
    public void unregister(String listenerGroup, ProcedureCallListener<T> listener) {

    }

    @Override
    public <E> void push(String listenerGroup, E event) {

    }

    public <E> void addBeforeCallListener(String listenerGroup, E event) {
        push(listenerGroup, event);
    }
}
