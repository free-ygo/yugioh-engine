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

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 * This class define an area for cards. Each area is a list of cards or a list
 * of card area.
 */
public interface CardArea {

    /**
     * Search cards by special condition
     */
    List<Card> search(Predicate<Card> condition);

    /**
     * Determine the card area is an available area. If return false that area
     * is available else not available.
     *
     * @return true if available, false if unavailable
     */
    boolean isAvailable(int index);

    void setAvailable(int index, boolean available);

    /**
     * Put a card into a card area. If the card area is full that returns an
     * {@link IndexOutOfBoundsException}. If success, return true, else return
     * false.
     *
     * @return true if success, false if fail.
     */
    boolean push(Card card);

    /**
     * Put a list of cards into a card area. If remain available area is less
     * than the size of {@code cards}, will do nothing and return false.
     *
     * @param cards list of card to add
     * @return true if success, false if fail
     */
    boolean pushAll(List<Card> cards);

    /**
     * Retrieve a card from the area and remove the card from the area.
     */
    Card pop();

    /**
     * Retrieve a card from area, but not be removed. If area is empty, will
     * return null.
     *
     * @return null if area is empty.
     */
    Card peek();

    /**
     * Peek a number of {@code count} cards, if cards of area is less than
     * {@code count} that return the remains cards.
     *
     * @param count Card count
     * @return a list of {@link Card}
     */
    List<Card> peek(int count);

    /**
     * Peek card from {@code startInclude} to {@code endExclude}.
     *
     * @param startInclude Begin from 0
     * @param endExclude   Less or equal size of area
     * @return a list of {@link Card}
     */
    List<Card> peek(int startInclude, int endExclude);

    /**
     * Peek card from {@code startInclude} to {@code endInclude}.
     *
     * @param startInclude Begin from 0
     * @param endInclude   Less or equal size of area
     * @return a list of {@link Card}
     */
    List<Card> peekClose(int startInclude, int endInclude);

    /**
     * Add a card into an area. If area is full, will return false else true.
     *
     * @param card card to add
     * @return true if success, false if fail
     **/
    boolean add(Card card);

    /**
     * Add a card into {@code i} position of area. If area is full, will return
     * false else return true.
     *
     * @param i    from 0 to @{{@link #cardSize()}
     * @param card card to add
     * @return true if success, false if fail
     */
    boolean add(int i, Card card);

    /**
     * Add a card into area. If area cannot accept {@code cards} return false
     * else return true.
     *
     * @param cards card to add
     * @return true if success, false if fail
     */
    boolean addAll(List<Card> cards);

    /**
     * Put a list of cards into position i.
     * <p>
     * If position i is beyond the range of the size of {@link CardArea} , it
     * throws an exception.
     *
     * @param i     from 0 to {@link #cardSize()}
     * @param cards card list
     */
    boolean addAll(int i, List<Card> cards);

    /**
     * Remove all {@link Card} that {@code cards} contains. If
     * boolean removeAll(List<Card> cards);
     * <p>
     * /**
     * Remove a card from position {@code index}, if the position is not null
     * return the removed card or return null.
     *
     * @param index card index
     * @return null if index is null else the removed card.
     */
    Card remove(int index);

    /**
     * Remove the card
     *
     * @param card the removed card
     * @return true if success, false if fail.
     */
    boolean remove(Card card);

    /**
     * Put the card in position index;
     *
     * @param index from 0 to {@link #cardSize()}(exclude)
     * @param card  card to put
     * @return true if success, false if fail.
     */
    boolean set(int index, Card card);

//    /**
//     * Shuffle the cards area.
//     * true if success, false if fail.
//     */
//    void shuffle();

    /**
     * Return the size of area. In some cases, the size of the  card area is
     * equal to the number of cards, but this is not absolute.
     * <p>
     * <em>Notice</em>: This is not the number of cards.
     *
     * @return the size of area.
     */
    int size();

    /**
     * Return the duel disk of card area.
     *
     * @return The {@link DuelDisk } of card area
     */
    DuelDisk getDuelDisk();

    void setDuelDisk(DuelDisk duelDisk);

    /**
     * Return all cards whose position is not {@code null}. The return value is
     * a modifiable list.
     *
     * @return all cards whose position is not null.
     */
    List<Card> getCards();

    /**
     * Returns the position index of all cards with non empty area.
     *
     * @return Return a map that key is index and value is card.
     */
    Map<Integer, Card> getPositions();

    /**
     * Get position of card
     */
    int getPosition(Card card);

    /**
     * Return size of all cards whose position is not {@code null}.
     *
     * @return size of cards
     * @see {@link #getCards()}
     */
    int cardSize();
}
