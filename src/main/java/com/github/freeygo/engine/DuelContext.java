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

import com.github.freeygo.engine.cmd.GameEventAction;
import com.github.freeygo.engine.event.EventSystem;

/**
 * @author Zhiyong Dai
 */
public class DuelContext {

    private GameTurn gameTurn;
    private final EventSystem eventSystem;
    private final Phrase[] phrases;
    private final ActionReader<Object> actionReader;
    private final UserDirectiveReader reader;
    private Duel duel;
    private GameEventAction gameEventAction;

    public DuelContext(GameTurn gameTurn, Duel duel, EventSystem eventSystem, Phrase[] phrases, UserDirectiveReader reader) {
        this.gameTurn = gameTurn;
        this.duel = duel;
        this.eventSystem = eventSystem;
        this.phrases = phrases;
        this.actionReader = new ActionReader<>();
        this.reader = reader;
    }

    public Duel getDuel() {
        return duel;
    }

    public void setDuel(Duel duel) {
        this.duel = duel;
    }

    public GameTurn getGameTurn() {
        return gameTurn;
    }

    public void setGameTurn(GameTurn gameTurn) {
        this.gameTurn = gameTurn;
    }

    public EventSystem getEventSystem() {
        return eventSystem;
    }

    public Phrase[] getPhrases() {
        return phrases;
    }

    public ActionReader<Object> getActionReader() {
        return actionReader;
    }

    public UserDirectiveReader getReader() {
        return reader;
    }

    public GameEventAction getGameAction() {
        return gameEventAction;
    }
}
