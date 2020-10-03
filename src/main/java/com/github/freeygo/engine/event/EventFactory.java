package com.github.freeygo.engine.event;

import com.github.freeygo.engine.Card;
import com.github.freeygo.engine.CardArea;
import com.github.freeygo.engine.DuelDisk;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

/**
 * @author 戴志勇
 */
public class EventFactory {

    private static final Logger log = LoggerFactory.getLogger(EventFactory.class);
    private static EventSystem eventSystem;

    public static void setEventManager(EventSystem eventSystem) {
        EventFactory.eventSystem = eventSystem;
    }

    public static MoveCardEventBuilder moveCard() {
        return new MoveCardEventBuilder();
    }

    public static DrawCardEventBuilder drawCard() {
        return new DrawCardEventBuilder();
    }

    public static RoundEventBuilder round() {
        return new RoundEventBuilder();
    }

    public static class RoundEventBuilder extends EventBuilder<RoundEvent> {

        public RoundEventBuilder() {

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

    public static class DrawCardEventBuilder extends EventBuilder<DrawCardEvent> {

        private DuelDisk duelDisk;
        private Object target;

        public DrawCardEventBuilder() {
            defaultAction(() -> {
                return null;
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

        @Override
        public <E> CompletableFuture<E> sendAsync(EventSystem eventSystem) {
            return null;
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
            return result;
        }
    }

    public static class MoveCardEventBuilder extends EventBuilder<MoveCardEvent> {
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
        private final EventAction<?> defaultAction;

        public MoveCardEventBuilder() {
            defaultAction = () -> {
                log.info("Move card {} from {} to {}", card, card.getCardArea(), targetArea);
                card.moveTo(targetArea);
                log.info("Move card is finished");
                return card;
            };

//                eventManager.send(EventFactory.moveCard().eventType(EventType.DRAW_START).target(sourceArea).build(), action);

//                if (sourceArea.size() < n) {
//                    log.info("Deck have not enough cards, need: {}, remain: {}", n, duelDisk.getDeckArea().size());
//                    eventManager.send(EventFactory.moveCard().eventType(EventType.CARD_NOT_ENOUGH).target(duelDisk).build(), action);
//                }
//        List<Card> result = duelDisk.draw(n);
//                eventManager.send(EventFactory.moveCard().eventType(EventType.DRAW_END).count(n).target(duelDisk).build(), action);
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

    public abstract static class EventBuilder<T> {
        private EventAction defaultAction;

        @SuppressWarnings("unchecked")
        public <R, U extends EventBuilder<T>> U defaultAction(EventAction<? super R> action) {
            defaultAction = action;
            return (U) this;
        }

        protected <E> EventAction<? super E> getDefaultAction() {
            return defaultAction;
        }

        public abstract <E> CompletableFuture<? super E> sendAsync(EventSystem eventSystem);

        public abstract <E> E send(EventSystem eventSystem);


        public abstract T build();
    }
}
