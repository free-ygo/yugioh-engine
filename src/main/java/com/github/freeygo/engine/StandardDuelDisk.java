package com.github.freeygo.engine;

public class StandardDuelDisk implements DuelDisk {

    private final CardArea magicTrapArea;
    private final CardArea monsterArea;
    private final CardArea extraCallArea;
    private final CardArea fieldArea;
    private final CardArea deckArea;
    private final CardArea extraDeckArea;
    private final CardArea graveArea;
    private final CardArea banishArea;

    public StandardDuelDisk() {
        this.magicTrapArea = new StandardCardArea();
        this.monsterArea = new StandardCardArea();
        this.extraCallArea = new StandardCardArea();
        this.fieldArea = new StandardCardArea();
        this.deckArea = new StandardCardArea();
        this.extraDeckArea = new StandardCardArea();
        this.graveArea = new StandardCardArea();
        this.banishArea = new StandardCardArea();
    }

    @Override
    public CardArea getMagicTrapArea() {
        return null;
    }

    @Override
    public CardArea getMonsterArea() {
        return null;
    }

    @Override
    public CardArea getExtraCallArea() {
        return null;
    }

    @Override
    public CardArea getFieldArea() {
        return null;
    }

    @Override
    public CardArea getDeckArea() {
        return null;
    }

    @Override
    public CardArea getExtraDeckArea() {
        return null;
    }

    @Override
    public CardArea getGraveArea() {
        return null;
    }

    @Override
    public CardArea getBanishArea() {
        return null;
    }
}
