package com.github.freeygo.engine.event;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 戴志勇
 */
public class StandardEventManager implements EventManager {

    private final Map<EventType, EventSubject> listeners;

    public StandardEventManager() {
        listeners = new HashMap<>();
    }


    @Override
    public void register(EventType eventType, EventSubject subject) {

    }

    @Override
    public void send(EventType eventType, Object o) {

    }

}
