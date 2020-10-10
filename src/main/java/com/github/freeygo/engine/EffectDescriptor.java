/*
 * Copyright 2020 free-ygo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.github.freeygo.engine;

/**
 * The effect descriptor is an effect description.
 */
public interface EffectDescriptor {

    /**
     * Get the source of effect.
     */
    Card getSource();

    /**
     * Set the source of effect.
     */
    void setSource(Card card);

    int getEffectType();

    void setEffectType(int effectType);

    boolean isChain();

    void setChain(boolean chain);

    void setTimePoint();

    enum EffectType {
        ACTIVE(true), TRIGGER(true),
        TRIGGER_IN_TIME(true), APPLY(false);

        private final boolean chain;

        EffectType(boolean chain) {
            this.chain = chain;
        }

        public boolean isChain() {
            return chain;
        }
    }

    enum TimePoint {
        ACTIVE, HANDLE,
    }


}
