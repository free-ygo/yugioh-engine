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


import java.util.*;

/**
 * @author Zhi yong Dai
 */
public class StandardEventListenerRegistry implements EventListenerRegistry {

    private Map<Object, Set> listenersMap;

    @Override
    public <T extends DuelEventListener>
    void register(Object listenerGroup, T listener) {
        if (listener == null) {
            return;
        }
        if (listenersMap == null) {
            listenersMap = new HashMap<>();
        }
        Set<T> listeners = listenersMap.get(listenerGroup);
        if (listeners == null) {
            listeners = new LinkedHashSet<>();
        }
        listeners.add(listener);
        listenersMap.put(listenerGroup, listeners);
    }

    @Override
    public <T extends DuelEventListener>
    void unregister(Object listenerGroup, T listener) {
        if (listener == null || listenersMap == null ||
                listenersMap.get(listenerGroup) == null) {
            return;
        }
        listenersMap.get(listenerGroup).remove(listener);
    }

    @Override
    public <E extends EventObject> void push(Object listenerGroup, E event) {
        Set<DuelEventListener> listeners = listenersMap.get(listenerGroup);
        if (listeners != null) {
            for (DuelEventListener l : listeners) {
                l.call(event);
            }
        }
    }

}
