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
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * This class implements an unlimited area. In other words, This area can accept
 * any number of cards. When you use {@link StandardCardArea#push(Card)},
 * {@link StandardCardArea#pushAll(List)}, {@link StandardCardArea#add(Card)},
 * {@link StandardCardArea#addAll(List)} etc. addition methods will always return
 * true.
 */
public class StandardCardArea extends AbstractCardArea {

    private final List<Card> cards;
    private boolean available;

    public StandardCardArea(DuelDisk duelDisk) {
        cards = new ArrayList<>();
    }

    @Override
    public List<Card> search(Predicate<Card> condition) {
        return cards.stream().filter(condition).collect(Collectors.toList());
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }


    @Override
    public boolean push(Card card) {
        cards.add(card);
        return true;
    }

    @Override
    public boolean pushAll(List<Card> cards) {
        this.cards.addAll(cards);
        return true;
    }

    @Override
    public Card pop() {
        if ((cards.size() - 1) < 0) return null;
        return cards.remove(cards.size() - 1);
    }


    @Override
    public Card peek() {
        if ((cards.size() - 1) < 0) return null;
        return cards.get(cards.size() - 1);
    }

//    @Override
//    public List<Card> peek(int n) {
//        if (cards.isEmpty()) return null;
//        return cards.subList(Math.max(cards.size() - n, 0), cards.size());
//    }

    @Override
    public boolean add(Card card) {
        cards.add(card);
        return true;
    }

    @Override
    public boolean add(int i, Card card) {
        cards.add(i, card);
        return true;
    }

    @Override
    public boolean addAll(List<Card> cards) {
        this.cards.addAll(cards);
        return true;
    }

    @Override
    public boolean removeAll(List<Card> cards) {
        return this.cards.removeAll(cards);
    }

    @Override
    public boolean remove(Card card) {
        return this.cards.remove(card);
    }

    @Override
    public boolean addAll(int i, List<Card> cards) {
        this.cards.addAll(i, cards);
        return true;
    }

    @Override
    public void shuffle() {
        Collections.shuffle(cards, new Random(System.currentTimeMillis()));
    }

    @Override
    public int size() {
        return cards.size();
    }


}
