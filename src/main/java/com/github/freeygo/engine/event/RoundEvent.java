package com.github.freeygo.engine.event;

/**
 * @author 戴志勇
 */
public class RoundEvent extends Event {


    public RoundEvent(Object target) {
        super(target);
    }

    @Override
    public Object getTarget() {
        return null;
    }

    @Override
    public EventType getEventType() {
        return null;
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
}
