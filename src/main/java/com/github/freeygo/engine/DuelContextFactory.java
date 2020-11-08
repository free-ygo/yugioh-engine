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

import com.github.freeygo.engine.cmd.flow.*;
import com.github.freeygo.engine.event.EventSystem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhiyong Dai
 */
public final class DuelContextFactory {

    public static DuelContext create(String type) {
        if (type == null) {
            UserDirectiveReader udr = new DefaultUserDirectiveReader();
            List<Card> cards1 = new ArrayList<>();
            List<Card> cards2 = new ArrayList<>();
            Player p1 = new Player("p1", 8000, new CardDeck("cards1", cards1), udr, 1);
            Player p2 = new Player("p2", 8000, new CardDeck("cards2", cards2), udr, 2);
            Player[] players = {p1, p2};
            RoundDial rd = new RoundDial(players, true);

            List<Flow> flows = new ArrayList<>();
            flows.add(new Flow(1, 1, "Draw Phrase", new DrawFlowAction()));
            flows.add(new Flow(2, 2, "Prepare Phrase", new PrepareFlowAction()));
            flows.add(new Flow(3, 3, "Main1 Phrase", new Main1FlowAction()));
            flows.add(new Flow(4, 4, "Fight Phrase", new FightFlowAction()));
            flows.add(new Flow(5, 5, "End Phrase", new EndFlowAction()));

            EventSystem es = new EventSystem();

            return new DuelContext(rd, flows, new Duel(), es);
        }
        return null;
    }
}
