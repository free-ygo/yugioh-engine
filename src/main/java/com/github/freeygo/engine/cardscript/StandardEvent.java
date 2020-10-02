package com.github.freeygo.engine.cardscript;

/**
 * @author 戴志勇
 */
public class StandardEvent implements Event {

    private Object target;
    private int eventType;


    public StandardEvent(Object target, int eventType) {
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
    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }
}
