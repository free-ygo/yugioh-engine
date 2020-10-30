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

import java.util.LinkedList;
import java.util.List;

/**
 * @author Zhi yong Dai
 */
public class Effect {

    private final EffectActiveCondition effectActiveCondition;
    private Player activePlayer;


    public Effect() {
        this.effectActiveCondition = new EffectActiveCondition();
    }

    public LinkedList<TimePointSet> applyEffect() {
        return null;
    }

    public EffectActiveCondition getActiveCondition() {
        return effectActiveCondition;
    }

    public EffectActiveCondition getApplyCondition() {
        return effectActiveCondition;
    }

    public List<TimePointSet> active(Player activePlayer) {
        this.activePlayer = activePlayer;
        return null;
    }

    public Player getActivePlayer() {
        return activePlayer;
    }
}
