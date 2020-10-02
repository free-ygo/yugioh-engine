package com.github.freeygo.engine.cardscript;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 戴志勇
 */
public class StandardEventManager implements EventManager {

    private final Map<Integer, List<EventListener>> listeners;

    public StandardEventManager() {
        listeners = new HashMap<>();
    }

    @Override
    public void register(int eventType, EventListener listener) {
        List<EventListener> ls = getListeners(eventType);
        ls.add(listener);
        this.listeners.put(eventType, ls);
    }

    @Override
    public void push(Event event) {
        List<EventListener> ls = getListeners(event.getEventType());
        ls.forEach(el -> {
            if (el != null) {
                el.action(event);
            }
        });
    }

    @Override
    public void push(Event event, EventAnswer answer) {
        getListeners(event.getEventType()).forEach(listener -> {
            answer.accept(listener.action(event));
        });
    }


    private List<EventListener> getListeners(int eventType) {
        if (null == this.listeners.get(eventType)) {
            listeners.put(eventType, new ArrayList<>());
        }
        return listeners.get(eventType);
    }
}
