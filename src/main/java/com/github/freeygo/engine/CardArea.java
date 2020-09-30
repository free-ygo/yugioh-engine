package com.github.freeygo.engine;

import java.util.List;
import java.util.function.Predicate;

public interface CardArea {

    List<Card> search(Predicate<Card> condition);

//    boolean isSingle();

    void push(Card card);

    Card pop();

    Card peek();

    Card peek(int n);

    void add(Card card);

    void add(int i, Card card);

    void addAll(List<Card> card);

    void addAll(int i, List<Card> cards);

    /**
     * 打乱
     */
    void shuffle();

    int size();
}
