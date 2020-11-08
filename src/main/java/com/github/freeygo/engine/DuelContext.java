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

import com.github.freeygo.engine.event.EventSystem;
import com.github.freeygo.engine.event.GameEventParser;

import java.util.List;

/**
 * @author Zhiyong Dai
 */
public class DuelContext {

    private final RoundDial roundDial;
    private FlowController flowController;
    private final EventSystem eventSystem;
    private final GameEventParser gameEventParser;
    //    private final ActionReader<Object> actionReader;
    private Duel duel;
//    private GameEventAction gameEventAction;

    public DuelContext(RoundDial roundDial, List<Flow> flows, Duel duel, EventSystem eventSystem, GameEventParser gameEventParser) {
        this.roundDial = roundDial;
        this.flowController = new FlowController(roundDial, flows, this);
        this.duel = duel;
        this.eventSystem = eventSystem;
        this.gameEventParser = gameEventParser;
//        this.actionReader = new ActionReader<>();
    }

    public Duel getDuel() {
        return duel;
    }

    public void setDuel(Duel duel) {
        this.duel = duel;
    }

    public FlowController getFlowController() {
        return flowController;
    }

    public void setGameTurn(FlowController flowController) {
        this.flowController = flowController;
    }

    public EventSystem getEventSystem() {
        return eventSystem;
    }

    public RoundDial getRoundDial() {
        return roundDial;
    }

    public GameEventParser getGameEventParser() {
        return gameEventParser;
    }

    //
//    public ActionReader<Object> getActionReader() {
//        return actionReader;
//    }
//
//    public GameEventAction getGameAction() {
//        return gameEventAction;
//    }

}
