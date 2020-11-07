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
 * @author Zhiyong Dai
 */
public interface Locatable {


    int getArea();

    int getPosition(Card card);

    /**
     * 如果不能在pos位置设置card返回false，否则返回true。
     *
     * @param pos  位置
     * @param card 卡片
     * @return
     */
    boolean setPosition(int pos, Card card);
}
