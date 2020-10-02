package com.github.freeygo.engine.event;

import com.github.freeygo.engine.cardscript.Effective;

import java.util.List;
import java.util.Map;

/**
 * @author 戴志勇
 */
public interface EffectRegister {

    void registerEffect(Event e, Effective effect);

    Map<Event, List<Effective>> getEffects(Event e);
}
