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

import com.github.freeygo.engine.beans.event.CallEvent;
import com.github.freeygo.engine.beans.event.ProcedureCallContext;
import com.github.freeygo.engine.cardscript.DuelObject;
import com.github.freeygo.engine.event.MoveCardEvent;
import com.github.freeygo.engine.event.MoveCardListener;
import com.github.freeygo.engine.util.ArrayUtils;

import java.util.EnumMap;

/**
 * @author Zhi yong Dai
 */
public abstract class AbstractDuelDisk extends DuelObject implements DuelDisk {

    private static final String MOVE_CARD = "moveCard";

    private final EnumMap<Area, CardArea> cardAreas;
//    private MoveCardProcedure moveCard;

    public AbstractDuelDisk(DuelContext duelContext) {
        super(duelContext);
        cardAreas = newCardAreas();
//        moveCard = new MoveCardProcedure(this, MOVE_CARD, null);
    }


    @Override
    public <T extends CardGrid> CardArea<T> getArea(Area area) {
        if (area == null) {
            return null;
        }
        return cardAreas.get(area);
    }

    @Override
    public <T extends CardGrid> void setArea(Area area, CardArea<T> cardArea) {
        if (area == null || cardArea == null) {
            return;
        }
        cardAreas.put(area, cardArea);
    }


    @Override
    public <T extends CardGrid> boolean moveCard(Card card0, Area destArea0,
                                                 int gridIndex0, int index0) {
        Location newLocation = new Location(this, destArea0, gridIndex0, index0);
        Location oldLocation = card0.getLocation();

        ProcedureCallContext context = new ProcedureCallContext((ctx) -> {
            Object[] args = ctx.getProcedureCallContext().getArguments();
            Card card = (Card) args[0];
            Area destArea = (Area) args[1];
            int gridIndex = (int) args[2];
            int index = (int) args[3];
            if (card == null || destArea == null || gridIndex < 0 ||
                    cardAreas.get(destArea) == null ||
                    cardAreas.get(destArea).gridSize() >= gridIndex ||
                    cardAreas.get(destArea).getCardGrid(gridIndex) == null) {
                return false;
            }
            CardGrid cardGrid = cardAreas.get(destArea).getCardGrid(gridIndex);
            int l = index < 0 ? 0 : Math.min(index, cardGrid.cardSize());
            return cardAreas.get(destArea).getCardGrid(gridIndex).add(l, card);
        }, card0, destArea0, gridIndex0, index0);

        MoveCardEvent e = newMoveCardEvent(context, card0, newLocation, oldLocation);
        Object[] listenerGroup = new Object[]{this, MOVE_CARD};
        pushEvent(e, listenerGroup);
        if (e.isExecute()) {
            e.getProcedureCallContext()
                    .setReturnValue(e.getProcedure().call());
            pushEvent(e, listenerGroup);
        }
        Object returnValue = e.getProcedureCallContext().getReturnValue();
        return returnValue != null && (boolean) returnValue;
    }

    @Override
    public <T extends CardGrid> boolean moveCard(Card card,
                                                 Location location) {
        return moveCard(card, location.getArea(), location.getGrid(),
                location.getIndex());
    }


    public void addMoveCardListener(MoveCardListener listener) {
        if (listener == null) return;
        register(MOVE_CARD, listener);
    }

    private void pushEvent(CallEvent e, Object[] listenerGroup) {
        getDuelContext().getEventListenerRegistry()
                .push(ArrayUtils.asHashSet(listenerGroup), e);
    }

    private MoveCardEvent
    newMoveCardEvent(ProcedureCallContext context, Card card, Location oldLocation,
                     Location newLocation) {
        return new MoveCardEvent(this, context, card, oldLocation, newLocation);
    }

    private void register(String listenerGroup, MoveCardListener listener) {

//        if (procedureCallListenerRegistry == null) {
//            procedureCallListenerRegistry = newProcedureCallListenerRegistry();
//        }
//        procedureCallListenerRegistry.register(listenerGroup, listener);
    }

    protected EnumMap<Area, CardArea> newCardAreas() {
        return new EnumMap<Area, CardArea>(Area.class);
    }


}
