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

package com.github.freeygo.engine.cardscript;

import com.github.freeygo.engine.Card;
import com.github.freeygo.engine.RoundRange;
import com.github.freeygo.engine.StageRange;

import java.util.function.Predicate;

/**
 * @author 戴志勇
 */
public class NormalSummon<R> extends AbstractMonsterEffect<R> {
    private RoundRange roundRange;

    private StageRange stageRange;

    private ActionScript script;

    private Predicate<Card> condition;

    private EffectStatus status;

    private Card target;

    private Card source;

    private EffectType effectType;

    private EffectSpeed effectSpeed;


    @Override
    public boolean isTarget(Card t) {
        return t != null && t.getCategory() == Card.Category.MONSTER;
    }

    @Override
    public boolean isAvailable(Card t) {
        return isTarget(t) && condition != null && condition.test((t));
    }

    @Override
    public R execute(Card t) {
        return isAvailable(t) ? script.action() : null;
    }

    @Override
    public Predicate<Card> getCondition() {
        return condition;
    }

    @Override
    public void setCondition(Predicate<Card> condition) {
        this.condition = condition;
    }

    @Override
    public EffectStatus getStatus() {
        return status;
    }

    @Override
    public void setStatus(EffectStatus status) {
        this.status = status;
    }

    @Override
    public ActionScript getScript() {
        return script;
    }

    @Override
    public void setScript(ActionScript script) {
        this.script = script;
    }

    @Override
    public void notifyEvent(Object event) {

    }

    @Override
    public EffectSpeed getEffectSpeed() {
        return effectSpeed;
    }

    @Override
    public void setEffectSpeed(EffectSpeed speed) {
        this.effectSpeed = speed;
    }

    @Override
    public Card getSource() {
        return source;
    }

    @Override
    public void setSource(Card source) {
        this.source = source;
    }

    @Override
    public Card getTarget() {
        return target;
    }

    @Override
    public void setTarget(Card target) {
        this.target = target;
    }

    @Override
    public int getCost() {
        return 0;
    }

    @Override
    public void setCost(int cost) {

    }

    @Override
    public EffectType getEffectType() {
        return effectType;
    }

    @Override
    public void setEffectType(EffectType effectType) {
        this.effectType = effectType;
    }


    @Override
    public CommandType getCommandType() {
        return CommandType.NORMAL;
    }

    @Override
    public void setEffectiveRange(StageRange stageRange) {
        this.stageRange = stageRange;
    }

    @Override
    public StageRange getEffectiveStage() {
        return stageRange;
    }

    @Override
    public RoundRange getEffectRound() {
        return roundRange;
    }

    @Override
    public void setEffectRound(RoundRange range) {
        this.roundRange = range;
    }
}
