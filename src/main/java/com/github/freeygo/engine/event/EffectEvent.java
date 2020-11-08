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

import com.github.freeygo.engine.Effect;
import com.github.freeygo.engine.Player;

/**
 * @author Zhiyong Dai
 */
public class EffectEvent extends GameEvent {

    public static final int ACTIVATE = 0x1;
    public static final int APPLYING = 0x3;
    public static final int APPLIED = 0x4;
    public static final int NO_EFFECT = 0x5;

    private final Effect effect;
    private final Player player;
    private final int type;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @param effect
     * @param player
     * @param type
     * @throws IllegalArgumentException if source is null
     */
    public EffectEvent(Object source, Effect effect, Player player, int type) {
        super(source);
        this.effect = effect;
        this.player = player;
        this.type = type;
    }

    @Override
    public EventType getEventType() {
        return EventType.EFFECT;
    }

    public Effect getEffect() {
        return effect;
    }

    public Player getPlayer() {
        return player;
    }

    public int getType() {
        return type;
    }
}
