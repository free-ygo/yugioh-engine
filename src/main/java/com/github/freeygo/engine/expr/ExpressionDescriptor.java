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

/**
 * @author Zhiyong Dai
 */
public class ExpressionDescriptor {

    public static final int LESS = 0x1;
    public static final int GREATER = 0x2;
    public static final int EQUAL = 0x3;
    public static final int GREATER_EQUAL = 0x4;
    public static final int LESS_EQUAL = 0x5;
    public static final int NOT_EQUAL = 0x6;
    public static final int BETWEEN = 0x7;


    private final int type;
    private final Object[] values;

    public ExpressionDescriptor(int type, Object... values) {
        this.type = type;
        this.values = values;
    }

    public int getType() {
        return type;
    }

    public Object[] getValues() {
        return values;
    }
}
