package com.github.freeygo.engine.event;

import com.github.freeygo.engine.Card;
import com.github.freeygo.engine.CardArea;

/**
 * @author 戴志勇
 */
public class NormalSummonEvent extends Event {

    private Card card;
    private CardArea location;


    public NormalSummonEvent(Object target) {
        super(target);
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public CardArea getLocation() {
        return location;
    }

    public void setLocation(CardArea location) {
        this.location = location;
    }
}
