package com.github.freeygo.engine.event;

import com.github.freeygo.engine.Card;
import com.github.freeygo.engine.DuelDisk;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author 戴志勇
 */
public class DrawCardEventBuilder extends EventBuilder<DrawCardEvent> {

    private static final Logger logger = LoggerFactory.getLogger(DrawCardEventBuilder.class);
    private DuelDisk duelDisk;
    private Object target;
    private Integer count;
    private List<Card> cards;

    public DrawCardEventBuilder() {
        defaultAction((e) -> {
            logger.info("Prepare drawing deck cards, need: {}, remain: {}",
                    cards != null ? cards.size() : count,
                    duelDisk.getDeckArea().size()
            );
            if (count != null) {
                duelDisk.draw(count);
            } else if (cards != null) {
                throw new RuntimeException("Operation not supported");
            }
            throw new RuntimeException("Card or count cannot be null");
        });
    }

    public DrawCardEventBuilder duelDisk(DuelDisk duelDisk) {
        this.duelDisk = duelDisk;
        return this;
    }


    public DrawCardEventBuilder target(Object target) {
        this.target = target;
        return this;
    }

    public DrawCardEventBuilder count(Integer count) {
        this.count = count;
        return this;
    }

    public DrawCardEventBuilder cards(List<Card> cards) {
        this.cards = cards;
        return this;
    }

    @Override
    public <E> CompletableFuture<? super E> sendAsync(EventSystem eventSystem) {
        return eventSystem.sendAsync(build());
    }

    @Override
    public <E> E send(EventSystem eventSystem) {
        return eventSystem.send(build());
    }

    @Override
    public DrawCardEvent build() {
        DrawCardEvent result = new DrawCardEvent(target);
        result.setDefaultAction(getDefaultAction());
        result.setDuelDisk(duelDisk);
        result.setCount(count);
        result.setCards(cards);
        return result;
    }

}
