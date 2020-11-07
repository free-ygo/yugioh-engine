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

import com.github.freeygo.engine.exception.CardNotEnoughException;

import java.util.ArrayList;
import java.util.List;

/**
 * 卡片区域的卡片数量是大于1张的，如果要使用卡片场地，请使用{@link CardField}
 *
 * @author Zhi yong Dai
 */
public class CardArea {
    private List<Card> cards;
    private final int area;
    private int position;

    public CardArea(int area, int position, List<Card> cards) {
        this.cards = cards;
        this.area = area;
        this.position = position;
    }

    public CardArea(int area, int position) {
        this(area, position, new ArrayList<>());
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> pop(int n) throws CardNotEnoughException {
        return null;
    }

    public Card pop() throws CardNotEnoughException {
        return null;
    }

    public List<Card> peek(int n) throws CardNotEnoughException {
        return null;
    }

    public boolean remove(Card card) {
        return false;
    }

    public boolean push(List<Card> cards) {
        return false;
    }

    public boolean add(Card card) {

        return false;
    }

    public int getArea() {
        return area;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Player getPlayer() {
        return null;
    }
}
