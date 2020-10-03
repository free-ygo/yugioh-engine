package com.github.freeygo.engine.event;

/**
 * @author 戴志勇
 */
public class SummonEvent extends Event {

    private Object target;
    private EventType eventType;


    public SummonEvent(Object target, EventType eventType) {
        this.target = target;
        this.eventType = eventType;
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
        return null;
    }

    @Override
    protected <T> void setDefaultAction(EventAction<? extends T> action) {

    }

    @Override
    public void preventDefaultAction() {

    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }
}
