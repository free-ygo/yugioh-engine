package com.github.freeygo.engine.event;

import com.github.freeygo.engine.Card;
import com.github.freeygo.engine.CardArea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

/**
 * @author 戴志勇
 */
public class MoveCardEventBuilder extends EventBuilder<MoveCardEvent> {

    private static final Logger logger = LoggerFactory.getLogger(MoveCardEventBuilder.class);
    private final EventAction<?> defaultAction;
    private EventType eventType;
    /**
     * 事件源
     */
    private Object target;
    /**
     * 卡片数量
     */
    private int count;
    private CardArea sourceArea;
    private CardArea targetArea;
    private Card card;

    public MoveCardEventBuilder() {
        defaultAction = (e) -> {
            logger.info("Move card {} from {} to {}", card, card.getCardArea(), targetArea);
            card.moveTo(targetArea);
            logger.info("Move card is finished");
            return card;
        };
    }

    public MoveCardEventBuilder target(Object target) {
        this.target = target;
        return this;
    }

    public MoveCardEventBuilder eventType(EventType eventType) {
        this.eventType = eventType;
        return this;
    }

    public MoveCardEventBuilder count(int count) {
        this.count = count;
        return this;
    }

    public MoveCardEventBuilder sourceArea(CardArea sourceArea) {
        this.sourceArea = sourceArea;
        return this;
    }

    public MoveCardEventBuilder targetArea(CardArea targetArea) {
        this.targetArea = targetArea;
        return this;
    }

    public MoveCardEventBuilder card(Card card) {
        this.card = card;
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

    public MoveCardEvent build() {
        MoveCardEvent result = new MoveCardEvent(target);
        result.setTarget(target);
        result.setCount(count);
        result.setCard(card);
        result.setDefaultAction(defaultAction);
        return result;
    }

}
