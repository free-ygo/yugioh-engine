package com.github.freeygo.engine.event;

import com.github.freeygo.engine.Card;
import com.github.freeygo.engine.DuelDisk;

import java.util.List;

/**
 * @author 戴志勇
 */
public class DrawCardEvent extends Event {
    private List<Card> cards;
    private Integer count;
    private DuelDisk duelDisk;

    public DrawCardEvent(Object target) {
        super(target);
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public DuelDisk getDuelDisk() {
        return duelDisk;
    }

    public void setDuelDisk(DuelDisk duelDisk) {
        this.duelDisk = duelDisk;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
