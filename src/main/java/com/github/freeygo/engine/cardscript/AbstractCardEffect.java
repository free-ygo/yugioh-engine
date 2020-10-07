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
//package com.github.freeygo.engine.cardscript;
//
//import com.github.freeygo.engine.Card;
//import com.github.freeygo.engine.RoundRange;
//import com.github.freeygo.engine.StageRange;
//
//import java.util.function.Predicate;
//
///**
// * @author 戴志勇
// */
//public class AbstractCardEffect implements CardEffect<Object, Object, Object> {
//    @Override
//    public void addAfterActiveEffectListener(EffectListener.AfterActiveEffectListener listener) {
//
//    }
//
//    @Override
//    public void removeAfterActiveEffectListener(EffectListener.AfterActiveEffectListener listener) {
//
//    }
//
//    @Override
//    public void addBeforeActiveEffectListener(EffectListener.BeforeActiveEffectListener listener) {
//
//    }
//
//    @Override
//    public void removeBeforeActiveEffectListener(EffectListener.BeforeActiveEffectListener listener) {
//
//    }
//
//    @Override
//    public boolean isEffectTarget(Predicate<Object> t) {
//        return false;
//    }
//
//    @Override
//    public boolean isAvailable(Object o) {
//        return false;
//    }
//
//    @Override
//    public Object active(Object o) {
//        return null;
//    }
//
//    @Override
//    public Predicate<Object> getCondition() {
//        return null;
//    }
//
//    @Override
//    public void setCondition(Predicate<Object> condition) {
//
//    }
//
//    @Override
//    public EffectStatus getStatus() {
//        return null;
//    }
//
//    @Override
//    public void setStatus(EffectStatus status) {
//
//    }
//
//    @Override
//    public ActionScript getScript() {
//        return null;
//    }
//
//    @Override
//    public void setScript(ActionScript script) {
//
//    }
//
//    @Override
//    public void notifyEvent(Object event) {
//
//    }
//
//    @Override
//    public EffectSpeed getEffectSpeed() {
//        return null;
//    }
//
//    @Override
//    public void setEffectSpeed(EffectSpeed speed) {
//
//    }
//
//    @Override
//    public Object getSource() {
//        return null;
//    }
//
//    @Override
//    public void setSource(Object source) {
//
//    }
//
//    @Override
//    public Object getEffectTarget() {
//        return null;
//    }
//
//    @Override
//    public void setEffectTarget(Object target) {
//
//    }
//
//    @Override
//    public int getCost() {
//        return 0;
//    }
//
//    @Override
//    public void setCost(int cost) {
//
//    }
//
//    @Override
//    public EffectType getEffectType() {
//        return null;
//    }
//
//    @Override
//    public void setEffectType(EffectType effectType) {
//
//    }
//
//    @Override
//    public CommandType getCommandType() {
//        return null;
//    }
//
//    @Override
//    public void setEffectiveRange(StageRange range) {
//
//    }
//
//    @Override
//    public StageRange getEffectiveStage() {
//        return null;
//    }
//
//    @Override
//    public RoundRange getEffectRound() {
//        return null;
//    }
//
//    @Override
//    public void setEffectRound(RoundRange range) {
//
//    }
////
////
////    private RoundRange roundRange;
////
////    private StageRange stageRange;
////
////    private ActionScript script;
////
////    private Predicate<Card> condition;
////
////    private EffectStatus status;
////
////    private Card effectTarget;
////
////    private Card source;
////
////    private EffectType effectType;
////
////    private EffectSpeed effectSpeed;
////
////
////    @Override
////    public boolean isEffectTarget(Card t) {
////        return t != null && t.getCategory() == Card.Category.MONSTER;
////    }
////
////    @Override
////    public boolean isAvailable(Card t) {
////        return isEffectTarget(t) && condition != null && condition.test((t));
////    }
////
////    @Override
////    public R execute(Card t) {
////        return isAvailable(t) ? script.action() : null;
////    }
////
////    @Override
////    public Predicate<Card> getCondition() {
////        return condition;
////    }
////
////    @Override
////    public void setCondition(Predicate<Card> condition) {
////        this.condition = condition;
////    }
////
////    @Override
////    public EffectStatus getStatus() {
////        return status;
////    }
////
////    @Override
////    public void setStatus(EffectStatus status) {
////        this.status = status;
////    }
////
////    @Override
////    public ActionScript getScript() {
////        return script;
////    }
////
////    @Override
////    public void setScript(ActionScript script) {
////        this.script = script;
////    }
////
////    @Override
////    public void notifyEvent(Object event) {
////
////    }
////
////    @Override
////    public EffectSpeed getEffectSpeed() {
////        return effectSpeed;
////    }
////
////    @Override
////    public void setEffectSpeed(EffectSpeed speed) {
////        this.effectSpeed = speed;
////    }
////
////    @Override
////    public Card getSource() {
////        return source;
////    }
////
////    @Override
////    public void setSource(Card source) {
////        this.source = source;
////    }
////
////    @Override
////    public Card getEffectTarget() {
////        return effectTarget;
////    }
////
////    @Override
////    public void setEffectTarget(Card target) {
////        this.effectTarget = target;
////    }
////
////    @Override
////    public int getCost() {
////        return 0;
////    }
////
////    @Override
////    public void setCost(int cost) {
////
////    }
////
////    @Override
////    public EffectType getEffectType() {
////        return effectType;
////    }
////
////    @Override
////    public void setEffectType(EffectType effectType) {
////        this.effectType = effectType;
////    }
////
////
////    @Override
////    public CommandType getCommandType() {
////        return CommandType.NORMAL;
////    }
////
////    @Override
////    public void setEffectiveRange(StageRange stageRange) {
////        this.stageRange = stageRange;
////    }
////
////    @Override
////    public StageRange getEffectiveStage() {
////        return stageRange;
////    }
////
////    @Override
////    public RoundRange getEffectRound() {
////        return roundRange;
////    }
////
////    @Override
////    public void setEffectRound(RoundRange range) {
////        this.roundRange = range;
////    }
//
//}
