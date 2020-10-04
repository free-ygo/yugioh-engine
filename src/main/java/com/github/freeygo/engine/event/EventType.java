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

package com.github.freeygo.engine.event;

/**
 * @author 戴志勇
 */
public enum EventType {
//    /**
//     * 激活效果事件
//     */
//    ACTIVATE_EFFECT,
//    /**
//     * 激活魔法卡事件
//     */
//    ACTIVATE_MAGIC_EFFECT,
//    /**
//     * 激活陷阱卡事件
//     */
//    ACTIVATE_TRAP_EFFECT,
//    /**
//     * 激活怪兽效果事件
//     */
//    ACTIVATE_MONSTER_EFFECT,
//    /**
//     * 召唤事件
//     */
//    SUMMON,
//    /**
//     * 通常召唤
//     */
//    NORMAL_SUMMON,
//    /**
//     * 特殊召唤
//     */
//    SPECIAL_SUMMON,
//    /**
//     * 融合召唤
//     */
//    FUSION_SUMMON,
//    /**
//     * 仪式召唤
//     */
//    CEREMONY_SUMMON,
//    /**
//     * 抽卡开始事件
//     */
//    DRAW_START,
//    /**
//     * 抽卡结束
//     */
//    DRAW_END,
//    /**
//     * 卡片数量不足
//     */
//    CARD_NOT_ENOUGH,
//    /**
//     * 通常抽卡事件
//     */
//    NORMAL_DRAW,
//    /**
//     * 效果抽卡事件
//     */
//    EFFECT_DRAW,
//    /**
//     * 卡组卡片不够
//     */
//    DECK_NO_CARD,
    /**
     * 效果事件
     * 效果激活事件
     */
    ACTIVATE_EFFECT,
    /**
     * 改变卡片位置事件。
     * <ul>
     *     <li>卡组区</li>
     *     <li>手卡区</li>
     *     <li>额外卡组区</li>
     *     <li>魔法和陷阱区</li>
     *     <li>除外区</li>
     *     <li>怪兽区</li>
     *     <li>额外怪兽区</li>
     * </ul>
     */
    MOVE_CARD,
    /**
     * 卡片状态变更事件
     */
    CARD_CHANGE,
    /**
     * 回合改变事件
     */
    ROUND_CHANGE,
    /**
     * 阶段改变事件
     */
    STAGE_CHANGE,
    //    /**
//     * 抽卡事件
//     */
//    DRAW_CARD,
    DUEL
}
