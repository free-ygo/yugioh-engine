package com.github.freeygo.engine.cardscript;

import com.github.freeygo.engine.Card;
import com.github.freeygo.engine.DuelDisk;

/**
 * @author 戴志勇
 */
public class StandardCardScriptCommand implements CardScriptCommand {

    private final EventManager eventManager;

    public StandardCardScriptCommand(EventManager eventManager) {
        this.eventManager = eventManager;
    }

    @Override
    public void call() {

    }

    @Override
    public void initEffect() {

    }

    @Override
    public void draw(DuelDisk duelDisk, int n) {
        if (duelDisk.getHandArea().size() < n) { // 卡组卡片不足
            eventManager.push(new StandardEvent(duelDisk, Event.DECK_NO_CARD), (EventResponse e) -> {
                if (e.getStatus() == EventResponse.IGNORE) {
                }
            });
        }
    }

    @Override
    public void normalSummon(Card card) {

    }

    @Override
    public void specialSummon(Card card) {

    }
}
