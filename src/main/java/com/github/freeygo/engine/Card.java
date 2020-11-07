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

import java.util.Collection;
import java.util.List;

public interface Card {

    Player getController();

    void setController(Player player);

    Locatable getLocation();

    void setLocation(Locatable location);

    /**
     * Card name
     */
    String getName();

    /**
     * Card name
     */
    void setName(String name);

    /**
     * Get the representation of the card in the field
     */
    FieldStatus getFieldStatus();

    /**
     * Set the representation of the card in the field
     */
    void setFieldStatus(FieldStatus status);

    /**
     * Get the category of the card.
     */
    Category getCategory();

    /**
     * Set the {@link Category} of the card
     */
    void setCategory(Category category);

    List<Effect> getEffects();

    String getDescription();

    void setDescription(String description);

    Integer getLevel();

    void setLevel(Integer level);

    Integer getAttack();

    void setAttack(Integer attack);

    Integer getDefense();

    void setDefense(Integer defense);

    Race getRace();

    void setRace(Race race);

    Type getType();

    void setType(Type type);

    Attribute getAttribute();

    void setAttribute(Attribute attribute);

    Collection<String> getTags();

    void setTags(Collection<String> tags);

    MagicType getMagicType();

    void setMagicType(MagicType type);


    enum MagicType {
        EQUIP, FIELD, FAST, RITUAL, CONTINUOUS, NORMAL
    }

    enum Race {
        SPELLCASTER, DRAGON, ZOMBIE, WARRIOR, BEAST_WARRIOR, BEAST, WINGED_BEAST,
        FIEND, FAIRY, INSECT, DINOSAUR, REPTILE, FISH, SEA_SERPENT, AQUA, PYRO,
        THUNDER, ROCK, PLANT, MACHINE, PSYCHIC, DIVINE_BEAST, WYRM, CYBERSE
    }

    enum Type {
        NORMAL, EFFECT, RITUAL, FUSION, SYNCHRO, XYZ, TOON, SPIRIT, UNION, GEMINI,
        TUNER, FLIP, PENDULUM, LINK
    }

    enum Attribute {
        DARK, LIGHT, EARTH, WATER, FIRE, WIND, DIVINE
    }

    enum Category {
        MONSTER, MAGIC, TRAP
    }

    enum FieldStatus {
        /**
         * 正面攻击形状态
         */
        UNCOVER_ATTACK,
        /**
         * 正面防守表示
         */
        UNCOVER_DEFENSE,
        /**
         * 背面守备状态
         */
        COVER_DEFENSE,
        /**
         * 盖伏
         */
        COVER_UP,
        /**
         * outside：场外
         */
        OUTSIDE
    }
}
