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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Zhiyong Dai
 */
public class StandardEventSubject<T> implements EventSubject<T> {

    private final Map<EventType, List<EventHandler>> eventHandlers;


    public StandardEventSubject(EventSystem eventSystem) {
//        eventSystem.register(EventType.MOVE_CARD, this);
        eventSystem.register(EventType.NORMAL_SUMMON, this);
//        eventSystem.register(EventType.DRAW_CARD, this);
//        eventSystem.register(EventType.ROUND_CHANGE, this);
//        eventSystem.register(EventType.DUEL_START, this);
        eventHandlers = new HashMap<>();
    }


    @Override
    public T notice(Event event) {
        T t;
        for (EventHandler<T> eventHandler : getEventHandlers(event)) {
            if (eventHandler != null) {
                t = eventHandler.handle(event);
                if (t != null) return t;
            }
        }
        return null;
    }

    @Override
    public void addHandler(EventType e, EventHandler handler) {
        getEventHandlers(e).add(handler);
    }

    private List<EventHandler> getEventHandlers(Event event) {
        return eventHandlers.getOrDefault(event.getEventType(), new ArrayList<>());
    }

    private List<EventHandler> getEventHandlers(EventType eventType) {
        return eventHandlers.getOrDefault(eventType, new ArrayList<>());
    }
}
