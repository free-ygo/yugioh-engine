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

import java.util.concurrent.CompletableFuture;

/**
 * @author 戴志勇
 */
public class NormalSummonEventBuilder extends EventBuilder<NormalSummonEvent> {

    private Card card;
    private CardArea location;

    @Override
    public <E> CompletableFuture<? super E> sendAsync(EventSystem eventSystem) {
        return eventSystem.sendAsync(build());
    }

    @Override
    public <E> E send(EventSystem eventSystem) {
        return eventSystem.send(build());
    }

    public NormalSummonEventBuilder card(Card card) {
        this.card = card;
        return this;
    }

    public NormalSummonEventBuilder location(CardArea location) {
        this.location = location;
        return this;
    }


    @Override
    public NormalSummonEvent build() {
        NormalSummonEvent result = new NormalSummonEvent(getTarget());
        result.setLocation(location);
        result.setCard(card);
        return result;
    }
}
