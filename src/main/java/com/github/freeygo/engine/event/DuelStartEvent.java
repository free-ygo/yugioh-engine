package com.github.freeygo.engine.event;

import com.github.freeygo.engine.DuelContext;

/**
 * @author 戴志勇
 */
public class DuelStartEvent extends Event {

    private DuelContext context;

    public DuelStartEvent(Object target) {
        super(target);
    }

    public void setDuelContext(DuelContext context) {
        this.context = context;
    }

    public DuelContext getDuelContext() {
        return context;
    }


}
