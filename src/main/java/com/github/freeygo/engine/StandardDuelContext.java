package com.github.freeygo.engine;

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
}
