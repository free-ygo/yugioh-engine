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
    private final CardArea handArea;

    public StandardDuelDisk() {
        this.magicTrapArea = new StandardCardArea();
        this.monsterArea = new StandardCardArea();
        this.extraCallArea = new StandardCardArea();
        this.fieldArea = new StandardCardArea();
        this.deckArea = new StandardCardArea();
        this.extraDeckArea = new StandardCardArea();
        this.graveArea = new StandardCardArea();
        this.banishArea = new StandardCardArea();
        this.handArea = new StandardCardArea();
    }

    @Override
    public CardArea getMagicTrapArea() {
        return magicTrapArea;
    }

    @Override
    public CardArea getMonsterArea() {
        return monsterArea;
    }

    @Override
    public CardArea getExtraCallArea() {
        return extraCallArea;
    }

    @Override
    public CardArea getFieldArea() {
        return fieldArea;
    }

    @Override
    public CardArea getDeckArea() {
        return deckArea;
    }

    @Override
    public CardArea getExtraDeckArea() {
        return extraDeckArea;
    }

    @Override
    public CardArea getGraveArea() {
        return graveArea;
    }

    @Override
    public CardArea getBanishArea() {
        return banishArea;
    }

    @Override
    public CardArea getHandArea() {
        return handArea;
    }

    @Override
    public void draw(int n) {
        for (int i = 0; i < n; i++) {
            getHandArea().push(getDeckArea().pop());
        }
    }


}
