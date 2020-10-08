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

import com.github.freeygo.engine.beans.event.CallableProcedure;
import com.github.freeygo.engine.cardscript.DuelObject;
import com.github.freeygo.engine.event.MoveCardListener;

import java.util.EnumMap;

/**
 * @author Zhi yong Dai
 */
public abstract class AbstractDuelDisk extends DuelObject implements DuelDisk {

    private static final String MOVE_CARD = "moveCard";

    private final EnumMap<Area, CardArea> cardAreas;
    private CallableProcedure moveCard;

    public AbstractDuelDisk(DuelContext duelContext) {
        super(duelContext);
        cardAreas = newCardAreas();
    }

    private void init() {
        moveCard = new CallableProcedure(MOVE_CARD);
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
        moveCard.getContext().setArguments(card0, destArea0, gridIndex0, index0);
        moveCard.getContext().setTargetProcedure((event) -> {
            Object[] args = event.getProcedureCallContext().getArguments();
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
        });
        return moveCard.call() != null && (boolean) moveCard.call();
    }

    @Override
    public <T extends CardGrid> boolean moveCard(Card card, Location location) {
        return moveCard(card, location.getArea(), location.getGrid(), location.getIndex());
//        move2.setContext(new HashMap<String, Object>());
//        move2.setCaller(this);
//        move2.setArguments(card, location);
//        move2.setTargetProcedure((ctx, caller, name, args) -> {
//            Card c = (Card) args[0];
//            Location l = (Location)args[1];
//            if (c == null || l == null ||
//                    l.getDuelDisk() == null ||
//                    l.getArea() == null || l.getGrid() < 0 ||
//                    cardAreas.get(l.getArea()) == null ||
//                    cardAreas.get(l.getArea()).getCardGrid(l.getGrid()).cardSize() >=
//                    cardAreas.get(l.getArea())
//                            .getCardGrid(l.getGrid()) == null) {
//                return false;
//            }
//
//        });
//        return move2.call() != null && (boolean) move2.call();
    }


    public void addBeforeMoveCardListener(MoveCardListener listener) {
        if (listener == null) return;
        register(MOVE_CARD, listener);
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
