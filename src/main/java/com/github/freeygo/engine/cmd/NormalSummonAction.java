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

/**
 * @author Zhiyong Dai
 */
public class NormalSummonAction implements Action<Boolean> {

    private final Card card;
    private final Player player;

    public NormalSummonAction(Player player, Card card) {
        this.card = card;
        this.player = player;
    }


    @Override
    public Boolean action(DuelContext context) {
        player.getHand().remove(card);
        int index = player.getUserDirectiveReader().selectIdleMonsterField();
        player.getDuelArena().getMonsterFields(index).add(card);
        return null;
    }
}
