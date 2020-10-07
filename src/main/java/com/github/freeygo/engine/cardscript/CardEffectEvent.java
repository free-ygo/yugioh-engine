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

import java.util.EventObject;

/**
 * @author Zhi yong Dai
 */
public class CardEffectEvent extends EventObject {

    private final CardEffect cardEffect;


    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public CardEffectEvent(Object source, CardEffect cardEffect) {
        super(source);
        this.cardEffect = cardEffect;
    }

    public CardEffect getEffect() {
        return cardEffect;
    }


}
