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

/**
 * @author Zhi yong Dai
 */
public interface ListCardGrid extends CardGrid {
    /**
     * Put a list of cards into a card area. If remain available area is less
     * than the size of {@code cards}, will do nothing and return false.
     *
     * @param cards list of card to add
     * @return true if success, false if fail
     */
    boolean pushAll(List<Card> cards);

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
     * If position i is beyond the range of the size of {@link CardGrid} , it
     * throws an exception.
     *
     * @param i     from 0 to {@link #cardSize()}
     * @param cards card list
     */
    boolean addAll(int i, List<Card> cards);

    /**
     * Remove all {@link Card} that {@code cards} contains. If area does not
     * changed.
     */
    boolean removeAll(List<Card> cards);

    /**
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

}
