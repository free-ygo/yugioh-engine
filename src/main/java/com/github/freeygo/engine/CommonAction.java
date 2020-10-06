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
 * @author 戴志勇
 */
public interface CommonAction {

    /**
     * 从卡组抽牌
     *
     * @param duelDisk 决斗盘
     * @#param count 抽取卡牌数量
     */
    void draw(DuelDisk duelDisk, int count);

    /**
     * 召唤怪兽卡到指定区域。
     *
     * @param card     怪兽卡
     * @param cardGrid
     */
    void summon(Card card, CardGrid cardGrid);

//    void
}
