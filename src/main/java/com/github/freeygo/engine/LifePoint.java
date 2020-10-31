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

import static java.lang.Math.round;

/**
 * @author Zhiyong Dai
 */
public final class LifePoint {
    private final long lifePoint;

    public LifePoint(double lifePoint) {
        this.lifePoint = round(lifePoint);
    }

    public LifePoint subtract(double lifePoint) {
        return new LifePoint(this.lifePoint - lifePoint);
    }

    public LifePoint plus(double lifePoint) {
        return new LifePoint(this.lifePoint + lifePoint);
    }

    public LifePoint multiply(double lifePoint) {
        return new LifePoint(this.lifePoint * lifePoint);
    }


    public LifePoint divide(double lifePoint) {
        return new LifePoint(this.lifePoint / lifePoint);
    }

    public long get() {
        return lifePoint;
    }
}
