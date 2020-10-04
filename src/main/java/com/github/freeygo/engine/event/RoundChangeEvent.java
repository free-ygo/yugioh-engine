package com.github.freeygo.engine.event;

import com.github.freeygo.engine.Round;

/**
 * @author 戴志勇
 */
public class RoundChangeEvent extends Event {

    private Round currentRound;
    private Round nextRound;

    public RoundChangeEvent(Object target) {
        super(target);
    }


    public Round getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(Round currentRound) {
        this.currentRound = currentRound;
    }

    public Round getNextRound() {
        return nextRound;
    }

    public void setNextRound(Round nextRound) {
        this.nextRound = nextRound;
    }
}
