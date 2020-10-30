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

import java.util.Set;

/**
 * @author Zhiyong Dai
 */
public class EffectActiveCondition {

    private TimePointSet timePointSets;
    private Set<Integer> effectObjectTypes;

    public boolean isEffectObject(EffectObject o) {
        return effectObjectTypes.contains(o.getObjectType());
    }

    public boolean containsTimePoint(int timePoint) {
        return timePointSets.contains(timePoint);
    }

    public boolean containsAny(TimePointSet tps) {
        return timePointSets.containsAny(tps);
    }

    public boolean canApply(DuelContext context) {
        return true;
    }
}
