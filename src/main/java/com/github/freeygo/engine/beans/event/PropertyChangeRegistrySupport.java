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

import com.github.freeygo.engine.beans.event.EventListenerRegistry.PropertyChangeListenerRegistry;
import com.github.freeygo.engine.event.EventListener;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhi yong Dai
 */
public class PropertyChangeRegistrySupport implements PropertyChangeListenerRegistry {

    public void addListener(String propertyName, PropertyChangeListener listener) {

    }

    public boolean removeListener(String propertyName, PropertyChangeListener listener) {
        return false;
    }

    public PropertyChangeListener[] getListeners(String propertyName) {
        return null;
    }

    public Map<String, PropertyChangeListener> getListeners() {
        return null;
    }

    @Override
    public void register(String propertyName, PropertyChangeListener listener) {

    }

    @Override
    public void unregister(String propertyName, PropertyChangeListener listener) {

    }

    @Override
    public <E> void push(String listenerGroup, E event) {

    }

    private static class PropertyChangeEventMap {

        private final Map<String, EventListener[]> listeners;

        public PropertyChangeEventMap() {
            listeners = new HashMap<>();
        }

        void addListener(String propertyName, EventListener listener) {
            EventListener[] listeners =
                    this.listeners.computeIfAbsent(propertyName,
                            e -> new EventListener[0]);

            System.arraycopy(listeners, 0, null, 0, listeners.length);
        }
    }
}
