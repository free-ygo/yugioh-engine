//package com.github.freeygo.engine;
//
//import com.github.freeygo.engine.event.EventAction;
//import com.github.freeygo.engine.event.EventFactory;
//import com.github.freeygo.engine.event.EventManager;
//import com.github.freeygo.engine.event.EventType;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.concurrent.CompletableFuture;
//
///**
// * @author 戴志勇
// */
//public class StandardDuelDiskWrapper extends StandardDuelDisk {
//
//    private StandardDuelDisk duelDisk;
//    private EventManager eventManager;
//    private static Logger log = LoggerFactory.getLogger(StandardDuelDiskWrapper.class);
//
//    public StandardDuelDiskWrapper(EventManager eventManager) {
//        duelDisk = new StandardDuelDisk();
//    }
//
//    @Override
//    public CardArea getMagicTrapArea() {
//        return duelDisk.getMagicTrapArea();
//    }
//
//    @Override
//    public CardArea getMonsterArea() {
//        return duelDisk.getMonsterArea();
//    }
//
//    @Override
//    public CardArea getExtraCallArea() {
//        return duelDisk.getExtraCallArea();
//    }
//
//    @Override
//    public CardArea getFieldArea() {
//        return duelDisk.getFieldArea();
//    }
//
//    @Override
//    public CardArea getDeckArea() {
//        return duelDisk.getDeckArea();
//    }
//
//    @Override
//    public CardArea getExtraDeckArea() {
//        return duelDisk.getExtraDeckArea();
//    }
//
//    @Override
//    public CardArea getGraveArea() {
//        return duelDisk.getGraveArea();
//    }
//
//    @Override
//    public CardArea getBanishArea() {
//        return duelDisk.getBanishArea();
//    }
//
//    @Override
//    public CardArea getHandArea() {
//        return duelDisk.getHandArea();
//    }
//
//    @Override
//    public List<Card> draw(int n) {
//        log.info("Draw deck cards, need: {}, remain: {}", n, duelDisk.getDeckArea().size());
//        eventManager.send(EventFactory.moveCard().eventType(EventType.DRAW_START).target(duelDisk).build());
//        if (duelDisk.getDeckArea().size() < n) {
//            log.info("Deck have not enough cards, need: {}, remain: {}", n, duelDisk.getDeckArea().size());
//            eventManager.send(EventFactory.moveCard().eventType(EventType.CARD_NOT_ENOUGH).target(duelDisk).build());
//        }
//        List<Card> result = duelDisk.draw(n);
//        eventManager.send(EventFactory.moveCard().eventType(EventType.DRAW_END).count(n).target(duelDisk).build());
//        log.info("Drawing cards is finished");
//        return result;
//    }
//
////    public List<Card> draw0(int n) {
////        log.info("Draw deck cards, need: {}, remain: {}", n, duelDisk.getDeckArea().size());
////
////        EventAction<List<Card>> action = () -> duelDisk.draw(n);
////
////        eventManager.send(EventFactory.moveCard().eventType(EventType.DRAW_START).target(duelDisk).build(), action);
////
////        if (duelDisk.getDeckArea().size() < n) {
////            log.info("Deck have not enough cards, need: {}, remain: {}", n, duelDisk.getDeckArea().size());
////            eventManager.send(EventFactory.moveCard().eventType(EventType.CARD_NOT_ENOUGH).target(duelDisk).build(), action);
////        }
//////        List<Card> result = duelDisk.draw(n);
////        eventManager.send(EventFactory.moveCard().eventType(EventType.DRAW_END).count(n).target(duelDisk).build(), action);
////        log.info("Drawing cards is finished");
////        return result;
////    }
//
//    @Override
//    public void putGrave(Card card) {
//        duelDisk.putGrave(card);
//    }
//
//    @Override
//    public void putBanish(Card card) {
//        duelDisk.putBanish(card);
//    }
//
//    @Override
//    public void putExtraDeck(Card card) {
//        duelDisk.putExtraDeck(card);
//    }
//
//    @Override
//    public void putDeck(Card card) {
//        duelDisk.putDeck(card);
//    }
//
//    @Override
//    public void putExtraSummon(Card card) {
//        duelDisk.putExtraSummon(card);
//    }
//
//    @Override
//    public void putField(int position, Card card) {
//        duelDisk.putField(position, card);
//    }
//
//    @Override
//    public void putHand(Card card) {
//        duelDisk.putHand(card);
//    }
//}
