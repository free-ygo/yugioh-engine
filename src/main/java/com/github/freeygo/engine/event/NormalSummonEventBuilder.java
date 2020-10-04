package com.github.freeygo.engine.event;

import com.github.freeygo.engine.Card;
import com.github.freeygo.engine.CardArea;

import java.util.concurrent.CompletableFuture;

/**
 * @author 戴志勇
 */
public class NormalSummonEventBuilder extends EventBuilder<NormalSummonEvent> {

    private Card card;
    private CardArea location;

    @Override
    public <E> CompletableFuture<? super E> sendAsync(EventSystem eventSystem) {
        return eventSystem.sendAsync(build());
    }

    @Override
    public <E> E send(EventSystem eventSystem) {
        return eventSystem.send(build());
    }

    public NormalSummonEventBuilder card(Card card) {
        this.card = card;
        return this;
    }

    public NormalSummonEventBuilder location(CardArea location) {
        this.location = location;
        return this;
    }


    @Override
    public NormalSummonEvent build() {
        NormalSummonEvent result = new NormalSummonEvent(card);
        result.setLocation(location);
        result.setCard(card);
        result.setDuelContext(duelContext());
        return result;
    }
}
