/*
 * Copyright (c) 2020 free-ygo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.freeygo.engine;


public class StandardDuelDisk implements DuelDisk {

    private CardArea<CardGrid> magicTrapArea;
    private CardGrid monsterArea;
    private CardGrid extraCallArea;
    private CardGrid fieldArea;
    private CardGrid deckArea;
    private CardGrid extraDeckArea;
    private CardGrid graveArea;
    private CardGrid banishArea;
    private CardGrid handArea;

    public StandardDuelDisk() {
//        this.magicTrapArea = new StandardCardGrid(this);
//        this.monsterArea = new StandardCardGrid(this);
//        this.extraCallArea = new StandardCardGrid(this);
//        this.fieldArea = new StandardCardGrid(this);
//        this.deckArea = new StandardCardGrid(this);
//        this.extraDeckArea = new StandardCardGrid(this);
//        this.graveArea = new StandardCardGrid(this);
//        this.banishArea = new StandardCardGrid(this);
//        this.handArea = new StandardCardGrid(this);
    }

//    @Override
//    public <T extends CardGrid> CardArea<T>  getMagicTrapArea() {
//        return (CardArea<T>) magicTrapArea;
//    }
//
//    @Override
//    public <T extends CardGrid> CardArea<T>  getMonsterArea() {
//        return (CardArea<T>) monsterArea;
//    }
//
//    @Override
//    public <T extends CardGrid> CardArea<T>  getExtraCallArea() {
//        return (CardArea<T>) extraCallArea;
//    }
//
//    @Override
//    public <T extends CardGrid> CardArea<T>  getFieldArea() {
//        return (CardArea<T>) fieldArea;
//    }
//
//    @Override
//    public <T extends CardGrid> CardArea<T>  getDeckArea() {
//        return (CardArea<T>) deckArea;
//    }
//
//    @Override
//    public <T extends CardGrid> CardArea<T>  getExtraDeckArea() {
//        return (CardArea<T>) extraDeckArea;
//    }
//
//    @Override
//    public <T extends CardGrid> CardArea<T>  getGraveArea() {
//        return (CardArea<T>) graveArea;
//    }
//
//    @Override
//    public <T extends CardGrid> CardArea<T>  getBanishArea() {
//        return (CardArea<T>) banishArea;
//    }
//
//    @Override
//    public <T extends CardGrid> CardArea<T>  getHandArea() {
//        return (CardArea<T>) handArea;
//    }

    @Override
    public <T extends CardGrid> CardArea<T> getArea(Area area) {
        return null;
    }

    @Override
    public <T extends CardGrid> void setArea(Area area, CardArea<T> cardArea) {

    }

    @Override
    public <T extends CardGrid> boolean move(Card card, Area area) {
        return false;
    }

//    @Override
//    public List<Card> draw(int n) {
//        List<Card> cards = new ArrayList<>(n);
//        for (int i = 0; i < n; i++) {
//            cards.add(getDeckArea().pop());
//            getHandArea().push(cards.get(i));
//        }
//        return cards;
//    }

//    @Override
//    public void putGrave(Card card) {
//
//    }

//    @Override
//    public void putBanish(Card card) {
//
//    }

//    @Override
//    public void putExtraDeck(Card card) {
//
//    }

//    @Override
//    public void putDeck(Card card) {
//
//    }

//    @Override
//    public void putExtraSummon(Card card) {
//
//    }
//
//    @Override
//    public void putField(int position, Card card) {
//
//    }

//    @Override
//    public void putHand(Card card) {
//
//    }


}
