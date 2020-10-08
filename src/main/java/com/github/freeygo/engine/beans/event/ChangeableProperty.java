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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * @author Zhi yong Dai
 */
public class ChangeableProperty<T> extends AbstractProperty<T> {

    private static final Logger
            LOG = LoggerFactory.getLogger(ChangeableProperty.class);

    private EventListenerRegistry listenerRegistry;

    public ChangeableProperty(String propertyName) {
        super(propertyName);
    }

    public EventListenerRegistry getListenerRegistry() {
        return listenerRegistry;
    }

    public void setListenerRegistry(EventListenerRegistry listenerRegistry) {
        this.listenerRegistry = listenerRegistry;
    }

    @Override
    public T getValue() {
        return super.getValue();
    }

    @Override
    public void setValue(T newValue) {
        T oldValue = super.getValue();
        if (!Objects.equals(oldValue, newValue)) {
            super.setValue(newValue);
            firePropertyChangeEvent(oldValue, newValue);
        }
    }

    public void addListener(PropertyChangeListener listener) {
        if (listener == null) {
            return;
        }
        if (listenerRegistry == null) {
            listenerRegistry = new StandardEventListenerRegistry();
        }
        listenerRegistry.register(getPropertyName(), listener);
    }

    public void removeListener(PropertyChangeListener listener) {
        if (listener == null || listenerRegistry == null) {
            return;
        }
        listenerRegistry.unregister(getPropertyName(), listener);
    }


    private void firePropertyChangeEvent(Object oldValue, Object newValue) {
        if (listenerRegistry != null) {
            listenerRegistry.push(getPropertyName(),
                    new PropertyChangeEvent(this,
                            getPropertyName(), oldValue, newValue)
            );
        }
    }
}
