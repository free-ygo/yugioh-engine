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
import org.luaj.vm2.Globals;
import org.luaj.vm2.lib.jse.JsePlatform;

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
        try {
            Globals globals = context.getAttribute(LUA_GLOBALS);
            if (globals == null) {
                globals = JsePlatform.standardGlobals();
            }
            return globals.load(script);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    @Override
    public Object send(CommandArgument argument) {
        EventSystem eventSystem = new StandardEventSystem();

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
        subject.addHandler(EventType.NORMAL_SUMMON, (e) -> {
            if (e instanceof MoveCardEvent) {
                System.out.println("Put card " + ((MoveCardEvent) e).getCard() + " into " + ((MoveCardEvent) e).getTargetArea());
            }
            throw new RuntimeException("Normal event is not MoveCardEvent");
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
        if (arg.getDestinationArea() == CommandArgument.MONSTER_AREA) {
            if (arg.getDuelist() == CommandArgument.FIRST) {
                return duel.getDuelistPair().getFirstDuelist().getDuelDisk().getMonsterArea();
            }
            if (arg.getDuelist() == CommandArgument.SECOND) {
                return duel.getDuelistPair().getFirstDuelist().getDuelDisk().getMonsterArea();
            }
        }
        throw new RuntimeException("Unknow command type");
    }
}
