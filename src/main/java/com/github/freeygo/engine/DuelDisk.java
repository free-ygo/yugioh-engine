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

/**
 * An duel disk.
 *
 * <p>
 * This interface simulate an duel disk. Each duelist own a duel disk when
 * the duelist in the duel.
 * </p>
 */
public interface DuelDisk {
//    <T extends CardGrid> CardArea<T> getArea(Area area);
//
//    <T extends CardGrid> void setArea(Area area, CardArea<T> cardArea);
//
//    <T extends CardGrid> boolean moveCard(Card card, Area destArea, int gridIndex, int layer);
//
//    <T extends CardGrid> boolean moveCard(Card card, Location location);

    enum Area {
        MAGIC_TRAP, MONSTER, EXTRA_SUMMON, FIELD_MAGIC, DECK, EXTRA_DECK, Grave,
        BANISH, HAND;
        private int grids;


    }

//    /**
//     * Magic and trap area.
//     * The area where place magic or trap cards.
//     *
//     * @return a {@link CardGrid} object
//     */
//    <T extends CardGrid> CardArea<T> getMagicTrapArea();
//
//    /**
//     * Monster area.
//     * The area where place monster cards.
//     *
//     * @return a {@link CardGrid} object
//     */
//    <T extends CardGrid> CardArea<T> getMonsterArea();
//
//    /**
//     * Extra call area.
//     * The area where place the monster cards which are in extra deck monster
//     * cards.
//     *
//     * @return a {@link CardGrid} object
//     */
//    <T extends CardGrid> CardArea<T> getExtraCallArea();
//
//    /**
//     * Field area.
//     * The area where put a field magic card.
//     *
//     * @returna {@link CardGrid} object
//     */
//    <T extends CardGrid> CardArea<T> getFieldArea();
//
//    /**
//     * Deck area.
//     * The area that players draw cards.
//     *
//     * @return a {@link CardGrid} object
//     */
//    <T extends CardGrid> CardArea<T> getDeckArea();
//
//    /**
//     * Extra deck area.
//     * The area where place extra monster cards.
//     *
//     * @return a {@link CardGrid} object
//     */
//    <T extends CardGrid> CardArea<T> getExtraDeckArea();
//
//    /**
//     * Grave area.
//     * The place where place cards which are destroyed.
//     *
//     * @return a {@link CardGrid} object
//     */
//    <T extends CardGrid> CardArea<T> getGraveArea();
//
//    /**
//     * Banish area.
//     * The area where place banish cards.
//     *
//     * @return
//     */
//    <T extends CardGrid> CardArea<T> getBanishArea();
//
//    /**
//     * Hand area.
//     * The area where place hand cards.
//     *
//     * @return {@link CardGrid}
//     */
//    <T extends CardGrid> CardArea<T> getHandArea();
//
//
//    /**
//     * 从卡组抽n张卡牌到手牌中
//     *
//     * @return 抽取的卡片
//     */
//    List<Card> draw(int n);
//
//    void putGrave(Card card);
//
//    void putBanish(Card card);
//
//    void putExtraDeck(Card card);
//
//    void putDeck(Card card);
//
//    void putExtraSummon(Card card);
//
//    void putField(int position, Card card);
//
//    void putHand(Card card);

}
