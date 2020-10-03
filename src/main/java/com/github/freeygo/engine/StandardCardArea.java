package com.github.freeygo.engine;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StandardCardArea implements CardArea {

    private final ArrayList<Card> cards;
    private final DuelDisk duelDisk;

    public StandardCardArea(DuelDisk duelDisk) {
        cards = new ArrayList<>();
        this.duelDisk = duelDisk;
    }

    @Override
    public List<Card> search(Predicate<Card> condition) {
        return cards.stream().filter(condition).collect(Collectors.toList());
    }

    @Override
    public boolean isAvailable() {
        return false;
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
    public void pushAll(List<Card> cards) {
        this.cards.addAll(cards);
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
    public void add(Card card) {
        cards.add(card);
    }

    @Override
    public void add(int i, Card card) {
        cards.add(i, card);
    }

    @Override
    public void addAll(List<Card> card) {
        cards.addAll(card);
    }

    @Override
    public void removeAll(List<Card> cards) {
        this.cards.removeAll(cards);
    }

    @Override
    public void remove(Card card) {
        this.cards.remove(card);
    }

    @Override
    public void addAll(int i, List<Card> cards) {
        cards.addAll(i, cards);
    }

    @Override
    public void shuffle() {
        Collections.shuffle(cards, new Random(System.currentTimeMillis()));
    }

    @Override
    public int size() {
        return cards.size();
    }

    @Override
    public DuelDisk getDuelDisk() {
        return duelDisk;
    }

}
