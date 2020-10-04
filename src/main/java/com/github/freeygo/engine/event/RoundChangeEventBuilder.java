package com.github.freeygo.engine.event;

import com.github.freeygo.engine.DuelContext;
import com.github.freeygo.engine.Round;

import java.util.concurrent.CompletableFuture;

/**
 * @author 戴志勇
 */
public class RoundChangeEventBuilder extends EventBuilder<RoundChangeEvent> {

    private Round currentRound;
    private Round nextRound;
    private DuelContext context;

    public RoundChangeEventBuilder() {
        defaultAction((e) -> {
            if (e.getEventType() != EventType.ROUND_CHANGE || e.getClass() == RoundChangeEvent.class) {
                // Set current round to next
                e.getDuelContext().nextRound();
            }
            throw new RuntimeException("Not matched event type, need round change event");
        });
    }

    public void currentRound(Round currentRound) {
        this.currentRound = currentRound;
    }

    public void nextRound(Round nextRound) {
        this.nextRound = nextRound;
    }

    public void duelContext(DuelContext context) {
        this.context = context;
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
    public RoundChangeEvent build() {
        RoundChangeEvent e = new RoundChangeEvent(context);
        e.setDuelContext(context);
        e.setDefaultAction(defaultAction());
        e.setEventType(EventType.ROUND_CHANGE);
        e.setCurrentRound(currentRound);
        e.setNextRound(nextRound);
        return e;
    }
}
