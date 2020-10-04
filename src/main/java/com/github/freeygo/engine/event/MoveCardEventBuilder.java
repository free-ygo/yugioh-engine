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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

/**
 * @author 戴志勇
 */
public class MoveCardEventBuilder extends EventBuilder<MoveCardEvent> {

    private static final Logger logger = LoggerFactory.getLogger(MoveCardEventBuilder.class);
    /**
     * 卡片数量
     */
    private int count;
    private CardArea sourceArea;
    private CardArea targetArea;
    private Card card;

    public MoveCardEventBuilder() {
        setDefaultAction((e) -> {
            logger.info("Move card {} from {} to {}", card, card.getCardArea(), targetArea);
            card.moveTo(targetArea);
            logger.info("Move card is finished");
            return card;
        });
    }

    public MoveCardEventBuilder count(int count) {
        this.count = count;
        return this;
    }

    public MoveCardEventBuilder sourceArea(CardArea sourceArea) {
        this.sourceArea = sourceArea;
        return this;
    }

    public MoveCardEventBuilder targetArea(CardArea targetArea) {
        this.targetArea = targetArea;
        return this;
    }

    public MoveCardEventBuilder card(Card card) {
        this.card = card;
        return this;
    }

    @Override
    public <E> CompletableFuture<? super E> sendAsync(EventSystem eventSystem) {
        return eventSystem.sendAsync(build());
    }

    @Override
    public <E> E send(EventSystem eventSystem) {
        return eventSystem.send(build());
    }

    public MoveCardEvent build() {
        MoveCardEvent result = new MoveCardEvent(getTarget());
        result.setDefaultAction(getDefaultAction());
        result.setCount(count);
        result.setCard(card);
        result.setSourceArea(sourceArea);
        result.setTargetArea(targetArea);
        return result;
    }

}
