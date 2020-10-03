package com.github.freeygo.engine;

import java.util.List;
import java.util.function.Predicate;

public interface CardArea {

    List<Card> search(Predicate<Card> condition);

//    boolean isSingle();

    boolean isAvailable();

    void push(Card card);

    void pushAll(List<Card> cards);

    Card pop();


    Card peek();


    void add(Card card);

    void add(int i, Card card);

    void addAll(List<Card> card);

    void removeAll(List<Card> cards);

    void remove(Card card);

    /**
     * Put a list of cards into position i.
     * <p>
     * If position i is beyond the range of the size of {@link CardArea} , it
     * throws an exception.
     *
     * @param i     from 0 to {@link #size()}
     * @param cards card list
     */
    void addAll(int i, List<Card> cards);

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

//    void setDuelDisk(DuelDisk dueldisk);
}
