package com.github.freeygo.engine;

/**
 * @author 戴志勇
 */
public class RoundRange {
    /**
     * 回合开始
     */
    Round start;
    /**
     * 回合结束
     */
    Round end;

    public RoundRange(Round start, Round end) {
        this.start = start;
        this.end = end;
    }

    public Round getStart() {
        return start;
    }

    public void setStart(Round start) {
        this.start = start;
    }

    public Round getEnd() {
        return end;
    }

    public void setEnd(Round end) {
        this.end = end;
    }
}