package com.github.freeygo.engine.cardscript;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StandardEventManager implements EventManager {

    private final Map<Class<?>, List<EventListener<? extends Event>>> listeners;

    public StandardEventManager() {
        listeners = new HashMap<>();
    }

    @Override
    public void send(Event e) {
        listeners.getOrDefault(e.getClass(), new ArrayList<>()).forEach(listener -> ((EventListener<Event>) listener).action(e));
    }

    @Override
    public <T extends Event> void addListener(Class<T> clazz, EventListener<T> listener) {
        List<EventListener<? extends Event>> l = listeners.getOrDefault(clazz, new ArrayList<>());
        l.add(listener);
        listeners.put(clazz, l);
    }


}
