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

import javax.smartcardio.CardNotPresentException;
import java.util.List;

/**
 * @author Zhiyong Dai
 */
public class DuelDisk {

    public static final int HAND = 1;
    public static final int DECK = 2;

    private final CardArea hand;
    private final CardArea deck;

    public DuelDisk(List<Card> cards) {
        this.hand = new CardArea(HAND, 0);
        this.deck = new CardArea(DECK, 0, cards);
    }

    public boolean draw(int n) throws CardNotPresentException {
        // 抽卡
        return true;
    }

    public CardArea getDeck() {
        return deck;
    }

    public CardArea getHand() {
        return hand;
    }
}
