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

import java.util.HashMap;
import java.util.Map;

public class StandardDuelContext implements DuelContext {

    private final Map<String, Object> attributes;
    private DuelEngine duelEngine;

    public StandardDuelContext() {
        attributes = new HashMap<>();
    }


    @Override
    @SuppressWarnings("unchecked")
    public <T> T getAttribute(String name) {
        return (T) attributes;
    }

    @Override
    public void setAttribute(String name, Object value) {
        attributes.put(name, value);
    }


    @Override
    public DuelEngine getDuelEngine() {
        return duelEngine;
    }

    public void setDuelEngine(DuelEngine duelEngine) {
        this.duelEngine = duelEngine;
    }

    @Override
    public Round nextRound() {
        return null;
    }
}
