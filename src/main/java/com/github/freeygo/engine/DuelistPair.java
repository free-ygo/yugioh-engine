package com.github.freeygo.engine;

public class DuelistPair {

    private Duelist firstDuelist;
    private Duelist secondDuelist;

    public DuelistPair() {
    }

    public DuelistPair(Duelist firstDuelist, Duelist secondDuelist) {
        this.firstDuelist = firstDuelist;
        this.secondDuelist = secondDuelist;
    }

    public Duelist getFirstDuelist() {
        return firstDuelist;
    }

    public void setFirstDuelist(Duelist duelist) {
        this.firstDuelist = duelist;
    }

    public Duelist getSecondDuelist() {
        return secondDuelist;
    }

    public void setSecondDuelist(Duelist duelist) {
        secondDuelist = duelist;
    }


}
