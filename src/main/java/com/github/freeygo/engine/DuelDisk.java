package com.github.freeygo.engine;

public interface DuelDisk {

    CardArea getMagicTrapArea();

    CardArea getMonsterArea();

    CardArea getExtraCallArea();

    CardArea getFieldArea();

    CardArea getDeckArea();

    CardArea getExtraDeckArea();

    CardArea getGraveArea();

    CardArea getBanishArea();

//    <E> void setScoreIndicator(ScoreIndicator<E> indicator);
//
//    <E> ScoreIndicator<E> getScoreIndicator();
}
