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

/**
 * 游戏王中的一切对象都要继承此自此类。
 * 效果对象
 *
 * @author Zhiyong Dai
 */
public class EffectObject {
    private static final int MONSTER = 1;
    private static final int MAGIC = 2;
    private static final int TRAP = 3;

    // 1怪兽、2魔法、3陷阱、4场地、5玩家
    private final int objectType;

    public EffectObject(int objectType) {
        this.objectType = objectType;
    }

    public int getObjectType() {
        return objectType;
    }
}
