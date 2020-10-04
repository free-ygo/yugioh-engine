package com.github.freeygo.engine;

import com.github.freeygo.engine.event.EventSystem;

import java.util.HashMap;
import java.util.Map;

public class StandardDuelContext implements DuelContext {

    private final Map<String, Object> attributes;

    public StandardDuelContext() {
        attributes = new HashMap<>();
    }


    @Override
    @SuppressWarnings("unchecked")
    public <T> T getAttribute(String name) {
        return (T) attributes;
    }

    @Override
    public void setAttribute(String name, Object value) {
        attributes.put(name, value);
    }

    @Override
    public DuelistPair getDuelistPair() {
        return null;
    }

    @Override
    public EventSystem getEventSystem() {
        return null;
    }

    @Override
    public Round nextRound() {
        return null;
    }
}
