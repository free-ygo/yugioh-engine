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

import com.github.freeygo.engine.Card;
import com.github.freeygo.engine.Location;
import com.github.freeygo.engine.beans.event.CallEvent;
import com.github.freeygo.engine.beans.event.ProcedureCallContext;

/**
 * @author Zhi yong Dai
 */
public class MoveCardEvent extends CallEvent {
    private final Card card;
    private final Location oldLocation;
    private final Location newLocation;

    /**
     * Constructs a prototypical Event.
     *
     * @param source  the object on which the Event initially occurred
     * @param context
     * @throws IllegalArgumentException if source is null
     */
    public MoveCardEvent(Object source, ProcedureCallContext context,
                         Card card, Location oldLocation,
                         Location newLocation) {
        super(source, context);
        this.card = card;
        this.oldLocation = oldLocation;
        this.newLocation = newLocation;
    }

    public Location getOldLocation() {
        return oldLocation;
    }

    public Location getNewLocation() {
        return newLocation;
    }

    public Card getCard() {
        return card;
    }
}
