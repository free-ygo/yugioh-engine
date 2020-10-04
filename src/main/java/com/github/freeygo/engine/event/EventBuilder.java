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

import com.github.freeygo.engine.Duel;

import java.util.concurrent.CompletableFuture;

/**
 * @author 戴志勇
 */
public abstract class EventBuilder<T> {
    private EventAction defaultAction;
    private Duel target;

    @SuppressWarnings("unchecked")
    public <U extends EventBuilder<T>> U target(Duel duel) {
        target = duel;
        return (U) this;
    }

    protected <E> EventAction<? super E> getDefaultAction() {
        return defaultAction;
    }

    @SuppressWarnings("unchecked")
    protected <R, U extends EventBuilder<T>> U setDefaultAction(EventAction<? extends R> action) {
        defaultAction = action;
        return (U) this;
    }

    public abstract <E> CompletableFuture<? super E> sendAsync(EventSystem eventSystem);

    public abstract <E> E send(EventSystem eventSystem);

    public abstract T build();

    protected Duel getTarget() {
        return target;
    }
}
