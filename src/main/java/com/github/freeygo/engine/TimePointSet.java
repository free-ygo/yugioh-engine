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

import java.util.HashSet;
import java.util.Set;

/**
 * 这个类是一个时点集，用来保存处理过程中的时点。
 *
 * @author Zhiyong Dai
 */
public class TimePointSet {
    public static final int TURN_START = 1;
    public static final int DRAW_PHRASE = 2;
    public static final int PREPARE_PHRASE = 3;
    public static final int MAIN_PHRASE_1 = 4;

    private final Set<Integer> timePoints;

    public TimePointSet() {
        timePoints = new HashSet<>();
    }

    public void add(Integer timePoint) {
        if (timePoint != null) {
            timePoints.add(timePoint);
        }
    }

    public void add(Integer... timePoints) {
        if (timePoints == null) {
            return;
        }
        for (Integer timePoint : timePoints) {
            add(timePoint);
        }
    }

    public boolean contains(int timePoint) {
        return timePoints.contains(timePoint);
    }

    public boolean containAll(TimePointSet tps) {
        return timePoints.containsAll(tps.timePoints);
    }

    public boolean containsAny(TimePointSet tps) {
        if (tps == null || tps.timePoints.isEmpty()) return false;
        for (int tp : tps.timePoints) {
            if (this.contains(tp)) {
                return true;
            }
        }
        return false;
    }
}
