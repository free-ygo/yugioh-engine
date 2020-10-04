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

import com.github.freeygo.engine.cardscript.Effect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 戴志勇
 */
public class StandardEffectRegister implements EffectRegister {
    private final HashMap<Event, List<Effect>> eventEffects;

    public StandardEffectRegister() {
        eventEffects = new HashMap<>();
    }

    @Override
    public void registerEffect(Event e, Effect effect) {
        getEffective(e).add(effect);
    }

    @Override
    public Map<Event, List<Effect>> getEffects(Event e) {
        return eventEffects;
    }

    private List<Effect> getEffective(Event e) {
        eventEffects.computeIfAbsent(e, k -> new ArrayList<>());
        return eventEffects.get(e);
    }
}
