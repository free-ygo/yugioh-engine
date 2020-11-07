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

package com.github.freeygo.engine.cmd.flow;

import com.github.freeygo.engine.DuelContext;
import com.github.freeygo.engine.Player;
import com.github.freeygo.engine.cmd.ActionController;
import com.github.freeygo.engine.cmd.NormalDrawAction;
import com.github.freeygo.engine.event.DrawCardEvent;

import static com.github.freeygo.engine.event.DrawCardEvent.NORMAL;

/**
 * @author Zhiyong Dai
 */
public class DrawFlowAction<R> implements FlowAction<Void> {

    private final Player player;

    public DrawFlowAction(Player player) {
        this.player = player;
    }

    @Override
    public Void action(DuelContext context) {
        ActionController<Boolean> action =
                new ActionController<>(new NormalDrawAction(player));
        context.getEventSystem()
                .send(new DrawCardEvent(player, NORMAL))
                .then(() -> action.action(context));
        return null;
    }
}
