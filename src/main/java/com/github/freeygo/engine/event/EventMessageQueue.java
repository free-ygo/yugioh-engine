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

import java.util.LinkedList;

/**
 * 事件消息队列。
 *
 * @author Zhiyong Dai
 */
public class EventMessageQueue {
    private final LinkedList<GameEvent> eventQueue;

    public EventMessageQueue() {
        this.eventQueue = new LinkedList<>();
    }

    public GameEvent poll() {
        return eventQueue.poll();
    }

    public boolean offer(GameEvent gameEvent) {
        return eventQueue.offer(gameEvent);
    }
}
