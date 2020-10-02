package com.github.freeygo.engine.event;

/**
 * @author 戴志勇
 */
public class DrawEvent extends Event {

    private final Object target;
    private final int count;

    public DrawEvent(Object target, int count) {
        this.target = target;
        this.count = count;
    }

    @Override
    public Object getTarget() {
        return target;
    }

    @Override
    public EventType getEventType() {
        return EventType.DRAW_CARD;
    }

    public int getCount() {
        return count;
    }
}
