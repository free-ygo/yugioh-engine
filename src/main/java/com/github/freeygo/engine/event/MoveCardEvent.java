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

package com.github.freeygo.engine.event;

import com.github.freeygo.engine.Card;
import com.github.freeygo.engine.CardArea;
import com.github.freeygo.engine.Duel;

/**
 * @author 戴志勇
 */
public class MoveCardEvent extends Event {

    private int count;
    private CardArea sourceArea;
    private CardArea targetArea;
    private Card card;


    public MoveCardEvent(Duel target) {
        super(target);
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public CardArea getSourceArea() {
        return sourceArea;
    }

    public void setSourceArea(CardArea sourceArea) {
        this.sourceArea = sourceArea;
    }

    public CardArea getTargetArea() {
        return targetArea;
    }

    public void setTargetArea(CardArea targetArea) {
        this.targetArea = targetArea;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
