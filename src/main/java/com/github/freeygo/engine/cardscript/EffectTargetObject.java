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


import com.github.freeygo.engine.Card;

import java.util.List;

/**
 * Each {@link EffectTargetObject} maintains a queue of effects applied to this
 * object. When the queue is changed, the status of object must be recalculate.
 * Each {@link Card} has a list of effects that is different from an efficient
 * list of effects. Each object that can be considered an effect target object
 * should implement this interface.
 *
 * @author Zhi yong Dai
 */
public interface EffectTargetObject {

    void addActivatedEffect(CardEffect effect);

    void removeActivatedEffect(CardEffect effect);

    List<CardEffect> getActivatedEffects();
}
