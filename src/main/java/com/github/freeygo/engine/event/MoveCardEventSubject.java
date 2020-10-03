package com.github.freeygo.engine.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 戴志勇
 */
public class MoveCardEventSubject<T> implements EventSubject<T> {

    private final Map<EventType, List<EventHandler>> eventHandlers;


    public MoveCardEventSubject(EventSystem eventSystem) {
        eventSystem.register(EventType.MOVE_CARD, this);
        eventHandlers = new HashMap<>();
    }


    @Override
    public T notice(Event event) {
        T t;
        for (EventHandler eventHandler : getEventHandlers(event)) {
            t = eventHandler.handle(event);
            if (t != null) return t;
        }
        return null;
    }

    private List<EventHandler> getEventHandlers(Event event) {
        return eventHandlers.getOrDefault(event.getEventType(), new ArrayList<>());
    }
}
