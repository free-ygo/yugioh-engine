package com.github.freeygo.engine;

public class StandardDuel implements Duel {

    private DuelContext context;
    private DuelistPair duelistPair;
    private DuelDisk duelDisk;

    @Override
    public DuelContext getContext() {
        return context;
    }

    @Override
    public void setContext(DuelContext context) {
        this.context = context;
    }

    @Override
    public void setDuelistPair(DuelistPair duelistPair) {
        this.duelistPair = duelistPair;
    }

    @Override
    public DuelistPair getDuelistPair() {
        return duelistPair;
    }
//
//    @Override
//    public DuelDisk getDuelDisk() {
//        return duelDisk;
//    }
//
//    @Override
//    public void setDuelDisk(DuelDisk duelDisk) {
//        this.duelDisk = duelDisk;
//    }
}
