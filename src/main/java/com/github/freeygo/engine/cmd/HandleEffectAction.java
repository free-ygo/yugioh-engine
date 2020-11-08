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

package com.github.freeygo.engine.cmd;

import com.github.freeygo.engine.DuelContext;
import com.github.freeygo.engine.Effect;

import java.util.Deque;

/**
 * @author Zhiyong Dai
 */
public class HandleEffectAction implements Action<Void> {

    private final Deque<Effect> effects;

    public HandleEffectAction(Deque<Effect> effects) {
        this.effects = effects;
    }

    @Override
    public Void action(DuelContext context) {
        while (!effects.isEmpty()) {
            Effect e = effects.poll();
            if (e.isActivated()) {
                e.apply();
            } else {
                throw new RuntimeException("还有未激活的效果");
            }
        }
        return null;
    }
}
