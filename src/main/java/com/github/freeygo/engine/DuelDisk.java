package com.github.freeygo.engine;

/**
 * An duel disk.
 *
 * <p>
 * This interface simulate an duel disk. Each duelist own a duel disk when
 * the duelist in the duel.
 * </p>
 */
public interface DuelDisk {

    /**
     * Magic and trap area.
     * The area where place magic or trap cards.
     *
     * @return a {@link CardArea} object
     */
    CardArea getMagicTrapArea();

    /**
     * Monster area.
     * The area where place monster cards.
     *
     * @return a {@link CardArea} object
     */
    CardArea getMonsterArea();

    /**
     * Extra call area.
     * The area where place the monster cards which are in extra deck monster
     * cards.
     *
     * @return a {@link CardArea} object
     */
    CardArea getExtraCallArea();

    /**
     * Field area.
     * The area where put a field magic card.
     *
     * @returna {@link CardArea} object
     */
    CardArea getFieldArea();

    /**
     * Deck area.
     * The area that players draw cards.
     *
     * @return a {@link CardArea} object
     */
    CardArea getDeckArea();

    /**
     * Extra deck area.
     * The area where place extra monster cards.
     *
     * @return a {@link CardArea} object
     */
    CardArea getExtraDeckArea();

    /**
     * Grave area.
     * The place where place cards which are destroyed.
     *
     * @return a {@link CardArea} object
     */
    CardArea getGraveArea();

    /**
     * Banish area.
     * The area where place banish cards.
     *
     * @return
     */
    CardArea getBanishArea();

}
