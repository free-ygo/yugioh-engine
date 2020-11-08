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

import com.github.freeygo.engine.DuelContext;
import com.github.freeygo.engine.Player;
import com.github.freeygo.engine.exception.CardNotEnoughException;

/**
 * @author Zhiyong Dai
 */
public class NormalDrawAction implements Action<Boolean> {

    private final Player player;

    public NormalDrawAction(Player player) {
        this.player = player;
    }

    @Override
    public Boolean action(DuelContext context) {
        try {
            player.getHand().add(player.getDeck().pop());
            return true;
        } catch (CardNotEnoughException e) {
            e.printStackTrace();
//            context.getEventSystem()
//                    .send(new ExceptionMessageEvent(player, NORMAL_DRAW_FAILED));
//            e.printStackTrace();
        }
        return false;
    }
}
