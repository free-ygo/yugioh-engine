package com.github.freeygo.engine.cardscript;

import com.github.freeygo.engine.DuelContext;
import com.github.freeygo.engine.StandardDuelContext;

public class CallEvent implements Event {

    private final Object target;
    private final DuelContext context;

    public CallEvent(Object target) {
        this.target = target;
        this.context = new StandardDuelContext();
    }

    public Object getTarget() {
        return target;
    }

    public DuelContext getContext() {
        return context;
    }
}
