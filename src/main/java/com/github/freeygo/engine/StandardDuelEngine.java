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

import com.github.freeygo.engine.event.*;

import java.util.concurrent.CompletableFuture;

public class StandardDuelEngine implements DuelEngine {


    public static final String LUA_GLOBALS = "__LUA_GLOBALS__";

    private Duel duel;
    private EventSystem eventSystem;
    private DuelEngineContext context;

    public StandardDuelEngine() {
    }

    @Override
    public DuelEngineContext getEngineContext() {
        return context;
    }

    @Override
    public void setEngineContext(DuelEngineContext context) {
        this.context = context;
    }

    @Override
    public Object send(String script) {
        // TODO 执行任务
        return null;
    }

    @Override
    public Object send(String script, DuelContext context) {
        throw new RuntimeException("Unsupported operation");
    }

    @Override
    public Object send(CommandArgument argument) {
        if (argument.getCommandType() != CommandArgument.NORMAL_SUMMON) {
            throw new RuntimeException("command type is not equals normal summon");
        }
        return EventFactory.moveCard()
                .card(argument.getCard())
                .sourceArea(argument.getCard().getCardArea())
                .targetArea(getTarget(argument))
                .send(eventSystem);
    }

    @Override
    public EventSystem getEventSystem() {
        return eventSystem;
    }

    @Override
    public void setEventSystem(EventSystem eventSystem) {
        this.eventSystem = eventSystem;
    }

    @Override
    public void start(Duel duel) {
        this.duel = duel;
        EventSubject subject = new StandardEventSubject<CompletableFuture>(eventSystem);
        subject.addHandler(EventType.MOVE_CARD, (e) -> {
            if (e instanceof MoveCardEvent) {
                System.out.println("Put card " + ((MoveCardEvent) e).getCard() + " into " + ((MoveCardEvent) e).getTargetArea());
            } else {
                throw new RuntimeException("The event is not MoveCardEvent");
            }
            return null;
        });
//        DuelDisk a = new StandardDuelDisk();
//        DuelDisk b = new StandardDuelDisk();
//        EventFactory.drawCard().duelDisk(a).send(eventSystem);
//        EventFactory.drawCard().duelDisk(b).send(eventSystem);
//        EventFactory.roundChange();


    }


    protected String globalContext() {
        return new StringBuilder()
                .toString();
    }

    private CardArea getTarget(CommandArgument arg) {
        if (arg.getCommandType() == CommandArgument.NORMAL_SUMMON) {
            if (arg.getDuelist() == CommandArgument.FIRST) {
                return duel.getDuelistPair()
                        .getFirstDuelist()
                        .getDuelDisk()
                        .getMonsterArea();
            } else if (arg.getDuelist() == CommandArgument.SECOND) {
                return duel.getDuelistPair().getFirstDuelist().getDuelDisk().getMonsterArea();
            }
            throw new RuntimeException("Unknown duelist");
        }
        throw new RuntimeException("Unknown command type");
    }
}
