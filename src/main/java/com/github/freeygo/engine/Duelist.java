package com.github.freeygo.engine;

public interface Duelist {
    <T extends DuelDisk> T getDuelDisk();

    <T extends DuelDisk> void setDuelDisk(T duelDisk);

    DuelContext getDuelContext();

    void setDuelContext(DuelContext context);
}
