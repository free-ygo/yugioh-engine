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
import com.github.freeygo.engine.event.GameEvent;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Zhiyong Dai
 */
public class EventSystemResult<T> {

    private final EventSystem eventSystem;
    private final T t;

    public EventSystemResult(T t, EventSystem eventSystem) {
        this.eventSystem = eventSystem;
        this.t = t;
    }

    public <R> EventSystem thenAccept(Consumer<T> consumer) {
        consumer.accept(t);
        return eventSystem;
    }

    public <R> EventSystemResult<R> thenApply(Function<T, R> func) {
        return new EventSystemResult<>(func.apply(t), eventSystem);
    }

    public EventSystem send(GameEvent event) {
        return eventSystem.send(event);
    }

    public void sendAsync(GameEvent event) {
        eventSystem.sendAsync(event);
    }

    public EventSystem then(Runnable runnable) {
        return eventSystem.then(runnable);
    }

    public <R> EventSystemResult<R> then(Supplier<R> supplier) {
        return eventSystem.then(supplier);
    }
}
