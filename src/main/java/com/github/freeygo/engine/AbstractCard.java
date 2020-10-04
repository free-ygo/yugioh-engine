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

import com.github.freeygo.engine.cardscript.Effect;

import java.util.Collection;
import java.util.List;

/**
 * @author Zhi yong Dai
 */
public abstract class AbstractCard implements Card {
    private FieldStatus fieldStatus;
    private Category category;
    private List<Effect> effects;
    private CardArea cardArea;
    private Integer level;
    private Integer attack;
    private Integer defense;
    private String description;
    private Race race;
    private Type type;
    private Attribute attribute;
    private String name;
    private Collection<String> tags;
    private String id;

    public AbstractCard() {
    }

    @Override
    public Collection<String> getTags() {
        return tags;
    }

    @Override
    public void setTags(Collection<String> tags) {
        this.tags = tags;
    }

    @Override
    public FieldStatus getFieldStatus() {
        return fieldStatus;
    }

    @Override
    public void setFieldStatus(FieldStatus status) {
        this.fieldStatus = status;
    }

    @Override
    public Category getCategory() {
        return category;
    }

    @Override
    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public List<Effect> getEffects() {
        return effects;
    }

    @Override
    public void setEffects(List<Effect> effects) {
        this.effects = effects;
    }

    @Override
    public CardArea getCardArea() {
        return cardArea;
    }

    @Override
    public void setCardArea(CardArea cardArea) {
        this.cardArea = cardArea;
    }


    @Override
    public void moveTo(CardArea cardArea) {
        if (this.cardArea != null) {
            this.cardArea.remove(this);
        }
        cardArea.push(this);
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Integer getLevel() {
        return level;
    }

    @Override
    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public Integer getAttack() {
        return attack;
    }

    @Override
    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    @Override
    public Integer getDefense() {
        return defense;
    }

    @Override
    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    @Override
    public Race getRace() {
        return race;
    }

    @Override
    public void setRace(Race race) {
        this.race = race;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public Attribute getAttribute() {
        return attribute;
    }

    @Override
    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
