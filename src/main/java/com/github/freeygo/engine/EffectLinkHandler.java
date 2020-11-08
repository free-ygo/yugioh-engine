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

import com.github.freeygo.engine.event.EffectEvent;
import com.github.freeygo.engine.event.EventHandler;
import com.github.freeygo.engine.event.GameEvent;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Zhiyong Dai
 */
public class EffectLinkHandler implements EventHandler {
    private final Deque<Effect> effects;
    private Player starter;
    private DuelContext context;

    public EffectLinkHandler(DuelContext context) {
        this.context = context;
        this.effects = new LinkedList<>();
        this.context = context;
    }

    @Override
    public void handle(GameEvent e) {
        if (e instanceof EffectEvent) {
            EffectEvent ee = (EffectEvent) e;
            // TODO 如果是效果激活事件
            starter = ee.getPlayer();
            if (ee.getType() == EffectEvent.ACTIVATE) {
                this.effects.push(ee.getEffect());
                FlowController fc = context.getFlowController();
                Player np;
                Player cp = starter;
                while ((np = fc.getNextPlayer(cp)) != starter) {
                    cp = np;
                    cp.getUserDirectiveReader().readDirective();
                }
                // TODO 连锁完之后进入处理阶段

            }
        }
    }
}