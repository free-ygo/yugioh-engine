///*
// * Copyright (c) 2020 free-ygo
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *     http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//package com.github.freeygo.engine;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.function.Predicate;
//import java.util.stream.Collectors;
//
///**
// * @author Zhi yong Dai
// */
//public class LimitedCardGrid implements ListCardGrid {
//    private final List<Card> cards;
//    private final int limit;
//
//    public LimitedCardGrid(int capacity) {
//        if (capacity < 1) {
//            throw new IllegalArgumentException("Capacity cannot less than zero");
//        }
//        this.limit = capacity;
//        this.cards = new ArrayList<>(limit);
//    }
//
//    @Override
//    public List<Card> search(Predicate<Card> condition) {
//        return cards.stream().filter(condition).collect(Collectors.toList());
//    }
//
//    @Override
//    public boolean isAvailable() {
//        return false;
//    }
//
//    @Override
//    public void setAvailable(boolean available) {
//
//    }
//
//
//
////    @Override
////    public boolean isAvailable(int index) {
////        return false;
////    }
//
////    @Override
////    public void setAvailable(int index, boolean available) {
////
////    }
//
//
//    /**
//     * If the area exists null value,
//     *
//     * @param card
//     * @return
//     */
//    @Override
//    public boolean push(Card card) {
//        return add(card);
//    }
//
//    /**
//     * @param cards list of card to add
//     * @return false if remains area is not enough, true if success
//     */
//    @Override
//    public boolean pushAll(List<Card> cards) {
//        return addAll(cards);
//    }
//
//    @Override
//    public Card pop() {
//        if (!cards.isEmpty()) {
//            return cards.remove(cards.size() - 1);
//        }
//        return null;
//    }
//
//    @Override
//    public Card peek() {
//        if (cards.isEmpty()) {
//            return null;
//        }
//        return cards.get(cards.size() - 1);
//    }
//
//    @Override
//    public List<Card> peek(int count) {
//        return null;
//    }
//
//    @Override
//    public List<Card> peek(int startInclude, int endExclude) {
//        return null;
//    }
//
//    @Override
//    public List<Card> peekClose(int startInclude, int endInclude) {
//        return null;
//    }
//
//    @Override
//    public boolean add(Card card) {
//        return add(cards.size() + 1, card);
//    }
//
//    @Override
//    public boolean add(int i, Card card) {
//        if (isFullAfterAdd(1)) {
//            return false;
//        }
//        cards.add(i, card);
//        return true;
//    }
//
//    @Override
//    public boolean addAll(List<Card> cards) {
//        return addAll(this.cards.size() + 1, cards);
//    }
//
//    @Override
//    public boolean removeAll(List<Card> cards) {
//        return this.cards.remove(cards);
//    }
//
//    @Override
//    public Card remove(int index) {
//        return cards.remove(index);
//    }
//
//    @Override
//    public boolean remove(Card card) {
//        return cards.remove(card);
//    }
//
//    @Override
//    public boolean set(int index, Card card) {
//        return false;
//    }
//
//    @Override
//    public boolean addAll(int i, List<Card> cards) {
//        if (isFullAfterAdd(cards.size())) {
//            return false;
//        }
//        this.cards.addAll(cards);
//        return true;
//    }
//
////    @Override
////    public void shuffle() {
////        Collections.shuffle(cards);
////    }
//
//    @Override
//    public int size() {
//        return cards.size();
//    }
//
//    @Override
//    public DuelDisk getDuelDisk() {
//        return null;
//    }
//
//    @Override
//    public void setDuelDisk(DuelDisk duelDisk) {
//
//    }
//
//    @Override
//    public List<Card> getCards() {
//        return cards;
//    }
//
//    @Override
//    public Map<Integer, Card> getPositions() {
//        return null;
//    }
//
//    @Override
//    public int getPosition(Card card) {
//        return 0;
//    }
//
//    @Override
//    public int cardSize() {
//        return 0;
//    }
//
//
//    public boolean isFullAfterAdd(int size) {
//        return size + cards.size() > limit;
//    }
//}
