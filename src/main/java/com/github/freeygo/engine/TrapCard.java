package com.github.freeygo.engine;

/**
 * @author 戴志勇
 */
public interface TrapCard extends Card {

    @Override
    default CardType getCategory() {
        return CardType.TRAP;
    }

    enum TrapType {
        CONTINUOUS, COUNTER, NORMAL
    }
}
