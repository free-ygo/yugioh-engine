package com.github.freeygo.engine;

import java.util.ArrayDeque;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StandardCardArea implements CardArea {

    private final ArrayDeque<Card> cards;

    public StandardCardArea() {
        cards = new ArrayDeque<>();
    }

    @Override
    public List<Card> search(Predicate<Card> condition) {
        return cards.stream().filter(condition).collect(Collectors.toList());
    }

//    @Override
//    public boolean isSingle() {
//        return false;
//    }

    @Override
    public void push(Card card) {
        cards.add(card);
    }

    @Override
    public Card pop() {
        return null;
    }

    @Override
    public Card peek() {
        return null;
    }

    @Override
    public Card peek(int n) {
        return null;
    }

    @Override
    public void add(Card card) {

    }

    @Override
    public void add(int i, Card card) {

    }

    @Override
    public void addAll(List<Card> card) {

    }

    @Override
    public void addAll(int i, List<Card> cards) {

    }

    @Override
    public void shuffle() {

    }

    @Override
    public int size() {
        return 0;
    }
}
