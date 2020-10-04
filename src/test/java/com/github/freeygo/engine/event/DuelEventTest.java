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

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Zhi yong Dai
 */
class DuelEventTest {
    private static EventSystem eventSystem;
    private DuelEvent e;

    @BeforeAll
    static void beforeAll() {
        eventSystem = new StandardEventSystem();
        EventSubject subject = new StandardEventSubject(eventSystem);
        subject.addHandler(EventType.DUEL, (e) -> null);
    }

    @BeforeEach
    void setUp() {

    }

    @Test
    void getStatus() {
    }

    @Test
    void setStatus() {
    }

    @Test
    void getDuelistPair() {
    }

    @Test
    void setDuelistPair() {
    }

    @Test
    void testDuel() {

        boolean e = EventFactory
                .duel()
                .status(DuelEvent.Status.START)
                .send(eventSystem);
        Assertions.assertThat(e).isTrue();
    }
}