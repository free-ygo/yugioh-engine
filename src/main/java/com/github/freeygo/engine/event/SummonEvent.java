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

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }
}
