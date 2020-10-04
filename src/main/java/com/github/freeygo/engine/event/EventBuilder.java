package com.github.freeygo.engine.event;

import com.github.freeygo.engine.DuelContext;

import java.util.concurrent.CompletableFuture;

/**
 * @author 戴志勇
 */
public abstract class EventBuilder<T> {
    private EventAction defaultAction;
    private DuelContext context;

    @SuppressWarnings("unchecked")
    public <R, U extends EventBuilder<T>> U defaultAction(EventAction<? extends R> action) {
        defaultAction = action;
        return (U) this;
    }

    protected <E> EventAction<? super E> defaultAction() {
        return defaultAction;
    }

    public abstract <E> CompletableFuture<? super E> sendAsync(EventSystem eventSystem);

    public abstract <E> E send(EventSystem eventSystem);

    public abstract T build();

    public void duelContext(DuelContext context) {
        this.context = context;
    }

    protected DuelContext duelContext() {
        return context;
    }
}
