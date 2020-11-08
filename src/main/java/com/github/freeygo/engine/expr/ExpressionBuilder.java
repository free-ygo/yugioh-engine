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

package com.github.freeygo.engine.expr;

import static com.github.freeygo.engine.expr.ExpressionDescriptor.*;

/**
 * @author Zhiyong Dai
 */
public class ExpressionBuilder {

    private final PropertyDescriptor pd;

    public ExpressionBuilder(PropertyDescriptor pd) {
        this.pd = pd;
    }

    public ExpressionDescriptor less(Object value) {
        return new ExpressionDescriptor(LESS, value);
    }

    public ExpressionDescriptor equal(Object o) {
        return new ExpressionDescriptor(EQUAL, o);
    }

    public ExpressionDescriptor greater(Object o) {
        return new ExpressionDescriptor(GREATER, o);
    }

    public void greaterEqual() {
    }

    public void lessEqual() {
    }

    public void between() {
    }

    public void notEqual() {
    }
}
