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

/**
 * 卡片场地，每个场地只能放一张卡片。
 *
 * @author Zhi yong Dai
 */
public class CardField extends CardAreaStatus implements Locatable {

    private Card card;
    private boolean available;

    public CardField(int area) {
        super(area);
    }


    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public int getArea() {
        return 0;
    }

    @Override
    public int getPosition(Card card) {
        return 0;
    }

    @Override
    public boolean setPosition(int pos, Card card) {
        return false;
    }
}
