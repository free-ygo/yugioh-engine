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

package com.github.freeygo.engine.event;

import com.github.freeygo.engine.EventSystemResult;

import java.util.function.Supplier;

/**
 * @author Zhiyong Dai
 */
public class EventSystem {

    private final EventHandlerRegistry eventHandlerRegistry;
    private final EventDispatcher eventDispatcher;

    public EventSystem() {
        this.eventHandlerRegistry = new EventHandlerRegistry();
        this.eventDispatcher = new EventDispatcher(this.eventHandlerRegistry);
        init();
    }

    private void init() {
    }

    public EventHandlerRegistry getEventHandlerRegistry() {
        return eventHandlerRegistry;
    }

    public EventSystem send(GameEvent event) {
        this.eventDispatcher.dispatch(event);
        return this;
    }

    public void sendAsync(GameEvent event) {
        this.eventDispatcher.dispatchAsync(event);
    }

    public EventSystem register(EventType eventType, EventHandler handler) {
        eventHandlerRegistry.register(eventType, handler);
        return this;
    }

    public EventSystem then(Runnable runnable) {
        runnable.run();
        return this;
    }

    public <R> EventSystemResult<R> then(Supplier<R> supplier) {
        return new EventSystemResult<>(supplier.get(), this);
    }

}
