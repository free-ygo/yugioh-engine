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

package com.github.freeygo.engine.cmd;

import com.github.freeygo.engine.Card;
import com.github.freeygo.engine.DuelContext;
import com.github.freeygo.engine.Player;
import com.github.freeygo.engine.event.CardSummonEvent;
import com.github.freeygo.engine.event.DrawCardEvent;

import java.util.List;

/**
 * @author Zhiyong Dai
 */
public class GameAction {

    private final DuelContext context;
    private final ActionController drawNormal;
    private final ActionController summon;

    public GameAction(DuelContext context) {
        this.drawNormal = new ActionController<Void>(ctx -> {
            return null;
        });
        this.summon = new ActionController<Void>(ctx -> {
            return null;
        });
        this.context = context;
    }

    public void drawNormal() {
        ActionController<Boolean> action =
                new ActionController<>(new NormalDrawAction(getPlayer()));
        context.getEventSystem()
                .send(new DrawCardEvent(getPlayer(), DrawCardEvent.NORMAL))
                .then(() -> action.action(context));

    }

    public List<Card> getHandCards() {
        return getPlayer().getHand().getCards();
    }

    public void summon(Card card) {
        ActionController<Boolean> action =
                new ActionController<>(new NormalSummonAction(getPlayer(),
                        card));
        context.getEventSystem()
                .send(new CardSummonEvent(action, CardSummonEvent.NORMAL))
                .then(() -> action.action(context))
                .thenApply(success -> {
                    return success;
                });
    }

    private Player getPlayer() {
        return context.getGameTurn().getTurnPlayer();
    }
}