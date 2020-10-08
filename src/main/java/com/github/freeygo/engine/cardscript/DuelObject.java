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

package com.github.freeygo.engine.cardscript;

import com.github.freeygo.engine.DuelContext;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * All duel objects should extends from this class.
 *
 * @author Zhi yong Dai
 */
public class DuelObject implements EffectTargetObject {

    private final DuelContext duelContext;
    private LinkedList<DuelEffect> duelEffects;

    public DuelObject(DuelContext duelContext) {
        if (duelContext == null) {
            throw new RuntimeException();
        }
        this.duelContext = duelContext;
    }

    @Override
    public boolean addActivatedEffect(DuelEffect effect) {
        if (effect == null) {
            return false;
        }
        if (duelEffects == null) {
            duelEffects = new LinkedList<>();
        }
        return duelEffects.offer(effect);
    }

    @Override
    public boolean removeActivatedEffect(DuelEffect effect) {
        if (effect == null || duelEffects == null) {
            return false;
        }
        return duelEffects.remove(effect);
    }

    @Override
    public List<DuelEffect> getActivatedEffects() {
        if (duelEffects == null) {
            return new ArrayList<>(0);
        }
        return new ArrayList<>(duelEffects);
    }

    public DuelContext getDuelContext() {
        return duelContext;
    }

    //    private DuelContext duelContext;
//
//    public DuelObject(DuelContext duelContext) {
//        this.duelContext = duelContext;
//    }
//
//    DuelContext getDuelContext() {
//        return duelContext;
//    }
}
