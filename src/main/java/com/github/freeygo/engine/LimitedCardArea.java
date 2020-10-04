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

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Zhi yong Dai
 */
public class LimitedCardArea extends AbstractCardArea {
    //    private CardArea[] cards;
    private final Card[] cards;
    private int position;
    private DuelDisk duelDisk;

    public LimitedCardArea(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity cannot less than zero");
        }
        this.cards = new Card[capacity];
//        cards = Arrays.asList(new Card[capacity]);
    }

    @Override
    public List<Card> search(Predicate<Card> condition) {
        throw new RuntimeException("Unsupported operation");
    }


    /**
     * If the area exists null value,
     *
     * @param card
     * @return
     */
    @Override
    public boolean push(Card card) {
        if (position < cards.length) {
            cards[position++] = card;
            return true;
        }
        return false;
    }

    /**
     * @param cards list of card to add
     * @return false if remains area is not enough, true if success
     */
    @Override
    public boolean pushAll(List<Card> cards) {
        if (cards.size() <= this.cards.length - position) {
            System.arraycopy(cards.toArray(new Card[0]), 0, this.cards, position, cards.size());
            position += cards.size();
            return true;
        }
        return false;
    }

    @Override
    public Card pop() {
        if (position - 1 > -1) {
            return this.cards[--position];
        }
        return null;
    }

    @Override
    public Card peek() {
        int pos = isEmptyLast();
        if (pos > -1) return cards[pos];
        return null;
    }

    @Override
    public boolean add(Card card) {

    }

    @Override
    public boolean add(int i, Card card) {
        List<Integer> index = elementIndexes();
        if (index.size() == cards.length || index.size() + 1 < i) {
            return false;
        } else if (index.get(i) > i) {
            compact(index.get(i) - 1);
            cards[i] = card;
        } else if (index.get(i) < i) {
            cards[i] = card;
        } else {
            cards[i + 1] = cards[i];
            cards[i] = card;
        }
    }

    @Override
    public boolean addAll(List<Card> card) {
        if (card.size() >)
    }

    @Override
    public void removeAll(List<Card> cards) {

    }

    @Override
    public void remove(Card card) {

    }

    @Override
    public void addAll(int i, List<Card> cards) {

    }

    @Override
    public void shuffle() {

    }

    @Override
    public int size() {
//        return Arrays.stream(cards).filter(Objects::nonNull).;
        int size = 0;
        for (Card card : cards) {
            if (card != null) size += 1;
        }
        return size;
    }

    @Override
    public DuelDisk getDuelDisk() {
        return duelDisk;
    }

    /**
     * -1 if is empty else last object position
     */
    private int isEmptyLast() {
        for (int i = cards.length; i > 0; i--) {
            if (cards[i] != null) return i;
        }
        return -1;
    }

    /**
     * -1 if is empty else first object position
     */
    private int isEmptyFirst() {
//        return Arrays.stream(cards).allMatch(Objects::isNull);
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] != null) return i;
        }
        return -1;
    }

    /**
     * -1 if is full else first null position
     */
    private int isFullFirst() {
//        return Arrays.stream(cards).allMatch(Objects::nonNull);
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] == null) return i;
        }
        return -1;
    }

    /**
     * -1 if is full else last null position
     */
    private int isFullLast() {
        for (int i = cards.length; i > 0; i--) {
            if (cards[i] == null) return i;
        }
        return -1;
    }

    /**
     * return null if is empty else removed object
     */
    private Card remove(int i) {
        if (i > -1 && i < cards.length && cards[i] != null) {
            Card c = cards[i];
            cards[i] = null;
            return c;
        }
        return null;
    }

    /**
     * compact length elements.
     */
    private void compact(int length) {
        int len = Math.min(length, cards.length);
        for (int i = 0, j = i + 1; i < len && j < len; j++) {
            if (cards[i] == null && cards[j] != null) {
                cards[i++] = cards[j];
                cards[j] = null;
            }
        }
    }


    private List<Integer> elementIndexes() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] != null) {
                list.add(i);
            }
        }
        return list;
    }
}
