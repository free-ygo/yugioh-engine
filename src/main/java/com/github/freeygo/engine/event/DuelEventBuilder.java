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

import com.github.freeygo.engine.DuelistPair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

/**
 * @author Zhi yong Dai
 */
public class DuelEventBuilder extends EventBuilder<DuelEvent> {

    private static final Logger logger = LoggerFactory.getLogger(DuelEventBuilder.class);

    private DuelistPair duelistPair;
    private DuelEvent.Status status;

    public DuelEventBuilder() {
        setDefaultAction((e) -> {
            if (e instanceof DuelEvent && ((DuelEvent) e).getStatus() == DuelEvent.Status.START) {
                logger.info("Duel event start");
                // 洗切卡组
//                e.getTarget().getDuelistPair().getFirstDuelist().getDuelDisk().getDeckArea().shuffle();
//                e.getTarget().getDuelistPair().getSecondDuelist().getDuelDisk().getDeckArea().shuffle();
//                // 发牌
//                e.getTarget().getDuelistPair().getFirstDuelist().getDuelDisk().draw(5);
//                e.getTarget().getDuelistPair().getSecondDuelist().getDuelDisk().draw(5);
                return true;
            }
            if (e instanceof DuelEvent && ((DuelEvent) e).getStatus() == DuelEvent.Status.END) {
                logger.info("Duel event start");
                return true;
            }
            throw new RuntimeException("Unknown event or event status");
        });
    }

    public DuelEventBuilder duelistPair(DuelistPair duelistPair) {
        this.duelistPair = duelistPair;
        return this;
    }

    public DuelEventBuilder status(DuelEvent.Status status) {
        this.status = status;
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

    @Override
    public DuelEvent build() {
        DuelEvent duelEvent = new DuelEvent(getTarget());
        duelEvent.setDuelistPair(duelistPair);
        duelEvent.setStatus(status);
        duelEvent.setEventType(EventType.DUEL);
        return duelEvent;
    }
}
