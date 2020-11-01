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

    private final Card source;
    private final EffectActiveCondition effectActiveCondition;
    private final DuelContext duelContext;
    private Player controller;
    private int status;
    private boolean canApply;

    public Effect(Card source, DuelContext duelContext) {
        this.effectActiveCondition = new EffectActiveCondition();
        this.duelContext = duelContext;
        this.source = source;
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
        this.controller = activePlayer;
        return null;
    }

    public Player getController() {
        return controller;
    }

    /**
     * 获取效果对象
     *
     * @return
     */
    public List<Object> getAppliedObjects() {
        return null;
    }

    public boolean canActivate() {
        return false;
    }

    public boolean canApply() {
        return false;
    }

    public boolean isApplied() {
        return false;
    }

    public boolean isActive() {
        return false;
    }

    public boolean isDestroy() {
        return false;
    }

    public void activate(Player player) {

    }

    public void apply() {

    }

    public void destroy() {

    }
}
