package com.github.freeygo.engine;


import java.util.ArrayList;
import java.util.List;

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
        this.magicTrapArea = new StandardCardArea(this);
        this.monsterArea = new StandardCardArea(this);
        this.extraCallArea = new StandardCardArea(this);
        this.fieldArea = new StandardCardArea(this);
        this.deckArea = new StandardCardArea(this);
        this.extraDeckArea = new StandardCardArea(this);
        this.graveArea = new StandardCardArea(this);
        this.banishArea = new StandardCardArea(this);
        this.handArea = new StandardCardArea(this);
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
    public List<Card> draw(int n) {
        List<Card> cards = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            cards.add(getDeckArea().pop());
            getHandArea().push(cards.get(i));
        }
        return cards;
    }

    @Override
    public void putGrave(Card card) {

    }

    @Override
    public void putBanish(Card card) {

    }

    @Override
    public void putExtraDeck(Card card) {

    }

    @Override
    public void putDeck(Card card) {

    }

    @Override
    public void putExtraSummon(Card card) {

    }

    @Override
    public void putField(int position, Card card) {

    }

    @Override
    public void putHand(Card card) {

    }


}
