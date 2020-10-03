package com.github.freeygo.engine.event;

import com.github.freeygo.engine.Card;
import com.github.freeygo.engine.CardArea;
import com.github.freeygo.engine.DuelDisk;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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


    public static class DrawCardEventBuilder extends EventBuilder<DrawCardEvent> {

        private DuelDisk duelDisk;

        public DrawCardEventBuilder() {
            defaultAction(() -> {
                return null;
            });
        }

        public DrawCardEventBuilder duelDisk(DuelDisk duelDisk) {
            this.duelDisk = duelDisk;
            return this;
        }


        @Override
        public DrawCardEvent build() {
            DrawCardEvent result = new DrawCardEvent();
            result.setDefaultAction(getDefaultAction());
            result.setDuelDisk(duelDisk);
            return result;
        }
    }

    public static class MoveCardEventBuilder {
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
        private EventAction<?> defaultAction;

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

        public <T> MoveCardEventBuilder defaultAction(EventAction<? extends T> action) {
            this.defaultAction = action;
            return this;
        }

        public MoveCardEventBuilder card(Card card) {
            this.card = card;
            return this;
        }


        public MoveCardEvent build() {
            MoveCardEvent result = new MoveCardEvent(eventType);
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

        public abstract T build();
    }
}
