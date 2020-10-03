package com.github.freeygo.engine.event;

import com.github.freeygo.engine.Card;
import com.github.freeygo.engine.CardArea;

/**
 * @author 戴志勇
 */
public class NormalSummonEvent extends Event {

    private Object target;
    private final EventType eventType;
    private EventAction eventAction;
    private boolean doDefaultAction;
    private Card card;
    private CardArea cardArea;


    public NormalSummonEvent(Object target) {
        super(target);
        this.target = target;
        this.eventType = EventType.NORMAL_SUMMON;
        this.doDefaultAction = true;
    }


    @Override
    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public EventType getEventType() {
        return eventType;
    }

    @Override
    public <T> EventAction<? super T> getDefaultAction() {
        return eventAction;
    }

    @Override
    protected <T> void setDefaultAction(EventAction<? extends T> action) {
        this.eventAction = eventAction;
    }

    @Override
    public void preventDefaultAction() {
        this.doDefaultAction = false;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void setArea(CardArea cardArea) {
        this.cardArea = cardArea;
    }

    public CardArea getCardArea() {
        return cardArea;
    }
}
