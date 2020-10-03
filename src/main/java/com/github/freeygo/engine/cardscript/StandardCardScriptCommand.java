package com.github.freeygo.engine.cardscript;

import com.github.freeygo.engine.Card;
import com.github.freeygo.engine.DuelDisk;
import com.github.freeygo.engine.event.EventSystem;

/**
 * @author 戴志勇
 */
public class StandardCardScriptCommand implements CardScriptCommand {

    private final EventSystem eventSystem;

    public StandardCardScriptCommand(EventSystem eventSystem) {
        this.eventSystem = eventSystem;
    }

    @Override
    public void call() {

    }

    @Override
    public void initEffect() {

    }

    @Override
    public void draw(DuelDisk duelDisk, int n) {
//        duelDisk.draw(n);
    }

    @Override
    public void normalSummon(Card card) {

    }

    @Override
    public void specialSummon(Card card) {

    }
}
