package com.github.freeygo.engine.event;

import com.github.freeygo.engine.Card;
import com.github.freeygo.engine.CardArea;

/**
 * @author 戴志勇
 */
public class MoveCardEvent extends Event {

    private int count;
    private CardArea sourceArea;
    private CardArea targetArea;
    private Card card;


    public MoveCardEvent(Object target) {
        super(target);
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public CardArea getSourceArea() {
        return sourceArea;
    }

    public void setSourceArea(CardArea sourceArea) {
        this.sourceArea = sourceArea;
    }

    public CardArea getTargetArea() {
        return targetArea;
    }

    public void setTargetArea(CardArea targetArea) {
        this.targetArea = targetArea;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
