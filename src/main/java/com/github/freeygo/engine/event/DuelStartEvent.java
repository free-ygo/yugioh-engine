package com.github.freeygo.engine.event;

import com.github.freeygo.engine.DuelContext;

/**
 * @author 戴志勇
 */
public class DuelStartEvent extends Event {

    private EventType eventType;
    private EventAction defaultAction;
    private boolean doDefaultAction;
    private Object target;
    private DuelContext context;

    public DuelStartEvent(Object target) {
        super(target);
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

    @Override
    protected <T> void setDefaultAction(EventAction<? extends T> action) {
        defaultAction = action;
    }

    @Override
    public void preventDefaultAction() {
        this.doDefaultAction = false;
    }

    public void setDuelContext(DuelContext context) {
        this.context = context;
    }

    public DuelContext getContext() {
        return context;
    }


}
