package com.github.freeygo.engine.cardscript;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 戴志勇
 */
public class StandardEffectRegister implements EffectRegister {
    private final HashMap<Event, List<Effective>> eventEffects;

    public StandardEffectRegister() {
        eventEffects = new HashMap<>();
    }

    @Override
    public void registerEffect(Event e, Effective effect) {
        getEffective(e).add(effect);
    }

    @Override
    public Map<Event, List<Effective>> getEffects(Event e) {
        return eventEffects;
    }

    private List<Effective> getEffective(Event e) {
        eventEffects.computeIfAbsent(e, k -> new ArrayList<>());
        return eventEffects.get(e);
    }
}
