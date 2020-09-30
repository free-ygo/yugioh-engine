package com.github.freeygo.engine;

public class StandardDuelist implements Duelist {
    @Override
    public <T extends DuelDisk> T getDuelDisk() {
        return null;
    }

    @Override
    public <T extends DuelDisk> void setDuelDisk(T duelDisk) {

    }

    @Override
    public DuelContext getDuelContext() {
        return null;
    }

    @Override
    public void setDuelContext(DuelContext context) {

    }
}
