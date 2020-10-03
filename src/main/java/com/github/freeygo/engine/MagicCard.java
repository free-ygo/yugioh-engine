package com.github.freeygo.engine;

/**
 * @author 戴志勇
 */
public interface MagicCard extends Card {

    @Override
    default Category getCategory() {
        return Category.MAGIC;
    }

    MagicType getMagicType();

    void setMagicType(MagicType type);

    enum MagicType {
        EQUIP, FIELD, FAST, RITUAL, CONTINUOUS, NORMAL
    }
}
