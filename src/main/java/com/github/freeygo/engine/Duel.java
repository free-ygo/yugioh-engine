package com.github.freeygo.engine;

public interface Duel {

    DuelContext getContext();

    void setContext(DuelContext context);

    void setDuelistPair(DuelistPair duelistPair);
}
