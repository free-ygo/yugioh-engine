package com.github.freeygo.engine.event;

import com.github.freeygo.engine.DuelDisk;

/**
 * @author 戴志勇
 */
public class DrawCardEvent extends Event {
    public DrawCardEvent(Object target) {
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

    public void setDuelDisk(DuelDisk duelDisk) {

    }
}
