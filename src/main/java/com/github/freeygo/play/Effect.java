///*
// * Copyright (c) 2020 free-ygo
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *     http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//package com.github.freeygo.play;
//
///**
// * @author Zhi yong Dai
// */
//public interface Effect {
//
//    Player getController();
//    void setController(Player player);
//
//    void setSource(Card card);
//    Card getSource();
//
//    Cost getCost();
//    void setCost(Cost cost);
//
//    TimePoint getTimePoint();
//    void setTimePoint(TimePoint timePoint);
//
//    EffectTarget getEffectTarget();
//    void setEffectTarget(EffectTarget effectTarget);
//
//    EffectHandler getEffectHandler();
//    void setEffectHandler(EffectHandler handler);
//
//    interface EffectHandler {}
//    interface EffectTarget {}
//
//    /**
//     * 时点就是发生了动作和状态变化的时间段。例如A的时点，就说明发生了动作A或进入状态A的事件。
//     * 一个时间段内发生了多个事件，那么这个时间段称为这多个事件的时点。应用在这个时点的效果可
//     * 以发动。
//     */
//    interface TimePoint {
//        /** 卡片效果发动时点 */
//        int ACTIVE_EFFECT = 0;
//        /** 通常召唤时点 */
//        int NORMAL_SUMMON = 1;
//        /** 通常抽卡时点 */
//        int NORMAL_DRAW  = 2;
//        /** 特殊召唤时点 */
//        int SPECIAL_SUMMON = 3;
//        /** 卡片破坏时点 */
//        int DESTROY = 4;
//        /** 产生伤害时点 */
//        int DAMAGE = 5;
//        /** 放置魔法或陷阱卡的时点 */
//        int SET_MAGIC_TRAP_CARD = 6;
//        /** 放置怪兽卡 */
//        int SET_MONSTER_CARD = 7;
//        /** 回合开始 */
//        int ROUND_START = 8;
//        /** 回合结束 */
//        int ROUND_END = 9;
//    }
//    interface Cost{
//
//    }
//}
