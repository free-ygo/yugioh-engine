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

import com.github.freeygo.engine.beans.event.ChangeableProperty;
import com.github.freeygo.engine.beans.event.Property;
import com.github.freeygo.engine.cardscript.CardEffect;

import java.util.Collection;
import java.util.List;

/**
 * @author Zhi yong Dai
 */
public class StandardCard2 implements Card {
    private final Property<FieldStatus> fieldStatus;

    public StandardCard2() {
        fieldStatus = new ChangeableProperty<>("fieldStatus");
    }

    @Override
    public String getRuntimeId() {
        return null;
    }

    @Override
    public void setRuntimeId(String id) {

    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void setId(String id) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public FieldStatus getFieldStatus() {
        return fieldStatus.getValue();
    }

    @Override
    public void setFieldStatus(FieldStatus status) {

    }

    @Override
    public Category getCategory() {
        return null;
    }

    @Override
    public void setCategory(Category category) {

    }

    @Override
    public List<CardEffect> getEffects() {
        return null;
    }

    @Override
    public void setEffects(List<CardEffect> cardEffects) {

    }

    @Override
    public CardGrid getCardArea() {
        return null;
    }

    @Override
    public void setCardArea(CardGrid cardGrid) {

    }

    @Override
    public void moveTo(CardGrid cardGrid) {

    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public void setDescription(String description) {

    }

    @Override
    public Integer getLevel() {
        return null;
    }

    @Override
    public void setLevel(Integer level) {

    }

    @Override
    public Integer getAttack() {
        return null;
    }

    @Override
    public void setAttack(Integer attack) {

    }

    @Override
    public Integer getDefense() {
        return null;
    }

    @Override
    public void setDefense(Integer defense) {

    }

    @Override
    public Race getRace() {
        return null;
    }

    @Override
    public void setRace(Race race) {

    }

    @Override
    public Type getType() {
        return null;
    }

    @Override
    public void setType(Type type) {

    }

    @Override
    public Attribute getAttribute() {
        return null;
    }

    @Override
    public void setAttribute(Attribute attribute) {

    }

    @Override
    public Collection<String> getTags() {
        return null;
    }

    @Override
    public void setTags(Collection<String> tags) {

    }

    @Override
    public MagicType getMagicType() {
        return null;
    }

    @Override
    public void setMagicType(MagicType type) {

    }
}
