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

package com.github.freeygo.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Zhiyong Dai
 */
public class EffectManager {
    private final Map<Card, List<Effect>> effects;

    public EffectManager() {
        this.effects = new HashMap<>();
    }

    public void active(Player player, Effect effect) {
//        if (effect.canActivate()) {
//            effect.activate(player);
//
//        }
    }

    public Map<Card, List<Effect>> getEffects() {
        return new HashMap<>(effects);
    }

    public List<Effect> getCanApplyEffects() {
        List<Effect> result = new ArrayList<>();
        effects.forEach((card, effects) -> result.addAll(
                effects.stream().filter(Effect::canApply)
                        .collect(Collectors.toList())
        ));
        return result;
    }

    public List<Effect> getCanActivateEffects() {
        List<Effect> result = new ArrayList<>();
        effects.forEach((card, effects) -> result.addAll(
                effects.stream().filter(Effect::canActivate)
                        .collect(Collectors.toList()))
        );
        return result;
    }

    public void registry(Card card) {
        effects.put(card, new ArrayList<>(card.getEffects()));
    }


}
