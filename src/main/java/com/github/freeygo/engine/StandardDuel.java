package com.github.freeygo.engine;

public class StandardDuel implements Duel {

    private DuelContext context;
    private DuelistPair duelistPair;

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
}
