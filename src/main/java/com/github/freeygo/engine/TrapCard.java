package com.github.freeygo.engine;

/**
 * @author 戴志勇
 */
public interface TrapCard extends Card {

    @Override
    default Category getCategory() {
        return Category.TRAP;
    }

    enum TrapType {
        CONTINUOUS, COUNTER, NORMAL
    }
}
