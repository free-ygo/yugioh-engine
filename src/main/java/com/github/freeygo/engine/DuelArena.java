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

/**
 * @author Zhi yong Dai
 */
public class DuelArena {

    public static final int HAND = 1;
    public static final int GRAVE = 2;
    public static final int DECK = 3;
    public static final int EXTRA = 4;
    public static final int BANISH = 5;
    public static final int MAGIC_TRAP_FIELD = 6;
    public static final int MONSTER_FIELD = 7;

    private final Map<Integer, CardArea> areaMap;
    private Map<Integer, CardField> fieldMap;
    private int lifePoint;

    public DuelArena(int lifePoint, CardArea deck) {
        areaMap = new HashMap<>();
        this.lifePoint = lifePoint;
    }


    public CardArea getCardArea(int area) {
        return areaMap.get(area);
    }

    public void put(int id, CardArea area) {
        areaMap.put(id, area);
    }

    public CardField getCardField(int id) {
        return fieldMap.get(id);
    }

    public void put(int id, CardField field) {
        fieldMap.put(id, field);
    }

    public int getLifePoint() {
        return lifePoint;
    }

    public void setLifePoint(int lifePoint) {
        this.lifePoint = lifePoint;
    }
}
