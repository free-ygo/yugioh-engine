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
import com.github.freeygo.engine.Duel;
import com.github.freeygo.engine.DuelDisk;

import java.util.List;

/**
 * @author 戴志勇
 */
public class DrawCardEvent extends Event {
    private List<Card> cards;
    private Integer count;
    private DuelDisk duelDisk;

    public DrawCardEvent(Duel target) {
        super(target);
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public DuelDisk getDuelDisk() {
        return duelDisk;
    }

    public void setDuelDisk(DuelDisk duelDisk) {
        this.duelDisk = duelDisk;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
