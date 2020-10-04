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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Zhi yong Dai
 */
class StandardDuelEngineTest {

    private DuelEngine duelEngine;
    private DuelEngineContext engineContext;

    @BeforeEach
    void setUp() {
        engineContext = new StandardDuelEngineContext();
        duelEngine = new StandardDuelEngine();

        Duelist first = new StandardDuelist();
        Duelist second = new StandardDuelist();

        DuelistPair pair = new DuelistPair();
        pair.setFirstDuelist(first);
        pair.setSecondDuelist(second);

        StandardDuel duel = new StandardDuel();
        duel.setContext(new StandardDuelContext());
        duel.setCurrentRound(new StandardRound(1));

        duelEngine.start(duel);
    }


    @Test
    void setContext() {
        duelEngine.setEngineContext(engineContext);
    }

    @Test
    void getContext() {
        duelEngine.setEngineContext(engineContext);
        assertThat(duelEngine).isNotNull();
    }

    @Test
    void send() {

    }

    @Test
    void testSend() {
    }

    @Test
    void start() {
    }

    @Test
    void globalContext() {
    }

    @Test
    void sendCommand() {
        CommandArgument args = new CommandArgument();
        args.setDestinationArea(CommandArgument.MONSTER_AREA);
        args.setLocation(1);
        duelEngine.send(args);
    }
}