package com.github.freeygo.engine;

/**
 * @author 戴志勇
 */
public interface MagicCard extends Card {

    @Override
    default CardType getCategory() {
        return CardType.MAGIC;
    }

    MagicType getMagicType();

    void setMagicType(MagicType type);

    enum MagicType {
        EQUIP, FIELD, FAST, RITUAL, CONTINUOUS, NORMAL
    }
}
