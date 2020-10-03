package com.github.freeygo.engine.event;

import java.util.concurrent.CompletableFuture;

/**
 * @author 戴志勇
 */
public class RoundEventBuilder extends EventBuilder<RoundEvent> {

    public RoundEventBuilder() {
        defaultAction((e) -> {
            if (e.getEventType() != EventType.ROUND_CHANGE || e.getClass() == RoundEvent.class) {

            }
            throw new RuntimeException("Not matched event type, need round change event");
        });
    }

    @Override
    public <E> CompletableFuture<E> sendAsync(EventSystem eventSystem) {
        return null;
    }

    @Override
    public <E> E send(EventSystem eventSystem) {
        return null;
    }

    @Override
    public RoundEvent build() {
        return null;
    }
}
