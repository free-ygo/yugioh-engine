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

import com.github.freeygo.engine.Round;

import java.util.concurrent.CompletableFuture;

/**
 * @author 戴志勇
 */
public class RoundChangeEventBuilder extends EventBuilder<RoundChangeEvent> {

    private Round currentRound;
    private Round nextRound;

    public RoundChangeEventBuilder() {
        setDefaultAction((e) -> {
            if (e instanceof RoundChangeEvent && e.getEventType() == EventType.ROUND_CHANGE) {
                // Set current round to next
                e.getTarget().setCurrentRound(((RoundChangeEvent) e).getNextRound());
            }
            throw new RuntimeException("Not matched event type, need round change event");
        });
    }

    public void currentRound(Round currentRound) {
        this.currentRound = currentRound;
    }

    public void nextRound(Round nextRound) {
        this.nextRound = nextRound;
    }


    @Override
    public <E> CompletableFuture<E> sendAsync(EventSystem eventSystem) {
        return null;
    }

    @Override
    public <E> E send(EventSystem eventSystem) {
        return null;
    }

    @Override
    public RoundChangeEvent build() {
        RoundChangeEvent e = new RoundChangeEvent(getTarget());
        e.setDefaultAction(getDefaultAction());
        e.setEventType(EventType.ROUND_CHANGE);
        e.setCurrentRound(currentRound);
        e.setNextRound(nextRound);
        return e;
    }
}
