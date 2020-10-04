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

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 戴志勇
 */
public class StandardEventSystem implements EventSystem {

    private final Map<EventType, EventSubject> subjects;

    public StandardEventSystem() {
        subjects = new ConcurrentHashMap<>();
    }


    @Override
    public void register(EventType eventType, EventSubject subject) {
        synchronized (subjects) {
            subjects.put(eventType, subject);
        }
    }

    @Override
    public <T> T send(Event event) {
        EventSubject<T> subject = getSubject(event);
        return subject.notice(event);
    }

    @Override
    public <T> CompletableFuture<T> sendAsync(Event event, EventAction<T> action) {
        return CompletableFuture.supplyAsync(() -> (T) getSubject(event).notice(event));
    }

    @Override
    public <T> T send(Event event, EventAction<T> action) {
        return (T) getSubject(event).notice(event);
    }

    @Override
    public <T> CompletableFuture<? super T> sendAsync(Event event) {
        return CompletableFuture.supplyAsync(() -> (T) getSubject(event).notice(event));
    }

    private EventSubject getSubject(Event event) {
        synchronized (subjects) {
            EventSubject subject = subjects.get(event.getEventType());
            if (subject != null) {
                return subject;
            }
        }
        throw new NoEventSubjectException("There is not a subject for event " + event.getEventType());
    }

}
