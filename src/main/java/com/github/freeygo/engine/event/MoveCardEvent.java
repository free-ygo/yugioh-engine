package com.github.freeygo.engine.event;

import com.github.freeygo.engine.Card;
import com.github.freeygo.engine.CardArea;

/**
 * @author 戴志勇
 */
public class MoveCardEvent extends Event {

    private final EventType eventType;
    private Object target;
    private int count;
    private CardArea sourceArea;
    private CardArea targetArea;
    private Card card;
    private EventAction defaultAction;
    private boolean doDefaultAction;

    public MoveCardEvent(EventType eventType) {
        this.eventType = eventType;
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
        return defaultAction;
    }

    public void setDefaultAction(EventAction defaultAction) {
        this.defaultAction = defaultAction;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void preventDefaultAction() {
        this.doDefaultAction = false;
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
