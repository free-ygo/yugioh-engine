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
 * 保存处理过程中的时点。
 *
 * @author Zhiyong Dai
 */
public class TimePoint {
    public static final int TURN_START = 1;

    private final Set<Integer> timePoints;

    public TimePoint() {
        timePoints = new HashSet<>();
    }

    public void add(Integer timePoint) {
        timePoints.add(timePoint);
    }
}
