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
import java.util.function.Predicate;

/**
 * This class define an area for cards. Each area is a list of cards or a list
 * of card area.
 */
public interface CardArea {

    List<Card> search(Predicate<Card> condition);

    /**
     * Determine the card area is an available area. If return false that area
     * is available else not available.
     *
     * @return true if available, false if unavailable
     */
    boolean isAvailable();

    void setAvailable(boolean available);

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
     * Add a card into an area. If area is full, will return false else true.
     *
     * @param card card to add
     * @return true if success, false if fail
     **/
    boolean add(Card card);

    boolean add(int i, Card card);

    boolean addAll(List<Card> card);

    boolean removeAll(List<Card> cards);

    boolean remove(Card card);

    /**
     * Put a list of cards into position i.
     * <p>
     * If position i is beyond the range of the size of {@link CardArea} , it
     * throws an exception.
     *
     * @param i     from 0 to {@link #size()}
     * @param cards card list
     */
    boolean addAll(int i, List<Card> cards);

    /**
     * Shuffle the cards group.
     */
    void shuffle();

    /**
     * Return the number of cards in the card area.
     *
     * @return The number of cards in the card area
     */
    int size();

    /**
     * Return the duel disk of card area.
     *
     * @return The {@link DuelDisk } of card area
     */
    DuelDisk getDuelDisk();

    void setDuelDisk(DuelDisk duelDisk);

//    /**
//     * Return the child areas. If there is no areas, it will return an
//     * empty list.
//     * .
//     */
//    List<CardArea> getChildArea();


}
