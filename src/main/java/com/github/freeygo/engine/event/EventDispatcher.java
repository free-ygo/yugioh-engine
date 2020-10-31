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

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 事件分发器
 *
 * @author Zhiyong Dai
 */
public class EventDispatcher {

    private static final int DEFAULT_THREADS = 2;
    private final EventHandlerRegistry handlerRegistry;
    private final ExecutorService executors;

    public EventDispatcher(EventHandlerRegistry handlerRegistry) {
        this.handlerRegistry = handlerRegistry;
        this.executors = Executors.newFixedThreadPool(DEFAULT_THREADS);
    }

    /**
     * 同步分发事件
     *
     * @param event 事件对象
     */
    public void dispatch(GameEvent event) {
        getHandlers(event).forEach(handler -> {
            try {
                handler.handle(event);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * 异步分发事件
     *
     * @param event 事件对象
     */
    public void dispatchAsync(GameEvent event) {
        getHandlers(event).forEach(handler -> handleEvent(event, handler));
    }

    private void handleEvent(GameEvent event, EventHandler handler) {
        this.executors.execute(() -> handler.handle(event));
    }

    private List<EventHandler> getHandlers(GameEvent eventType) {
        return this.handlerRegistry.getHandlers(eventType.getEventType());
    }
}
