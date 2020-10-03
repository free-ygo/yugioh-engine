package com.github.freeygo.engine.event;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * @author 戴志勇
 */
public class StandardEventSystem implements EventSystem {

    private final Map<EventType, EventSubject> subjects;

    public StandardEventSystem() {
        subjects = new HashMap<>();
    }


    @Override
    public void register(EventType eventType, EventSubject subject) {
        subjects.put(eventType, subject);
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
        EventSubject subject = subjects.get(event.getEventType());
        if (subject != null) {
            return subject;
        }
        throw new NoEventSubjectException("There is not a subject for event " + event.getEventType());
    }

}
