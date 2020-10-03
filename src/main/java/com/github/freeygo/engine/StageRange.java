package com.github.freeygo.engine;

/**
 * @author 戴志勇
 */

public class StageRange {
    private Round.Stage start;
    private Round.Stage end;

    public StageRange(Round.Stage start, Round.Stage end) {
        this.start = start;
        this.end = end;
    }

    public Round.Stage getStart() {
        return start;
    }

    public void setStart(Round.Stage start) {
        this.start = start;
    }

    public Round.Stage getEnd() {
        return end;
    }

    public void setEnd(Round.Stage end) {
        this.end = end;
    }
}
