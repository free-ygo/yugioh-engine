package com.github.freeygo.engine;

public class DuelistPair {

    private Duelist duelistA;
    private Duelist duelistB;

    public DuelistPair() {
    }

    public DuelistPair(Duelist duelistA, Duelist duelistB) {
        this.duelistA = duelistA;
        this.duelistB = duelistB;
    }

    public Duelist getDuelistA() {
        return duelistA;
    }

    public void setDuelistA(Duelist duelist) {
        this.duelistA = duelist;
    }

    public Duelist getDuelistB() {
        return duelistB;
    }

    public void setDuelistB(Duelist duelist) {
        duelistB = duelist;
    }


}
