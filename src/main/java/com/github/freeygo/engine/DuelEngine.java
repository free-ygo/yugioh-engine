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
import com.github.freeygo.engine.event.EventSystem;
import com.github.freeygo.engine.event.EventType;
import com.github.freeygo.engine.event.FlowEvent;

import java.util.LinkedList;


/**
 * 实现决斗过程的调度任务。
 *
 * @author Zhiyong Dai
 */
public class DuelEngine {


    private final DuelContext context;
    private boolean isOver;


    public DuelEngine(DuelContext context) {
        this.context = context;
        registerHandlers(context.getEventSystem());
    }

    private void registerHandlers(EventSystem eventSystem) {
        context.getEventSystem().register(EventType.GAME_OVER, (e) -> {

        });
        context.getEventSystem().register(EventType.LP_CHANGED, (e) -> {

        });
        context.getEventSystem().register(EventType.EFFECT, (e) -> {
            LinkedList<Effect> activatingEffects = new LinkedList<>();
            EffectEvent ee = (EffectEvent) e;
            Effect ef = ee.getEffect();
            Player player = ee.getPlayer();
            switch (ee.getType()) {
                case EffectEvent.ACTIVATE:
                    Player startPlayer = player;
                    Player nextPlayer = player;
                    do {
                        if (ef.canActivate()) {
                            startPlayer = nextPlayer;
                            ef.activate(nextPlayer);
                            activatingEffects.push(ef);
                        } else {
                            player.getUserDirectiveReader()
                                    .notifyMessage("不满足发动条件");
                        }
                    } while ((nextPlayer = context.getFlowController().getNextPlayer(nextPlayer)) != startPlayer ||
                            ((ef = nextPlayer.getUserDirectiveReader().notifyActivateEffect()) != null &&
                                    nextPlayer.hasActiveEffects()));

                    Effect activeEffect = null;
                    while ((activeEffect = activatingEffects.poll()) != null &&
                            !activatingEffects.isEmpty()) {
                        if (activeEffect.canApply()) {
                            activeEffect.apply();
                        }
                    }
                    break;
                case EffectEvent.APPLYING:

                    break;
                case EffectEvent.APPLIED:
                    break;
                case EffectEvent.NO_EFFECT:
                    break;
            }
        });
        context.getEventSystem().register(EventType.FLOW, (e) -> {
            FlowEvent fe = (FlowEvent) e;
            if (fe.getType().equals(FlowEvent.CHANGE)) {
                context.getFlowController().setCurrentFlow(fe.getNextFlow());
                context.getFlowController().startFlow(fe.getNextFlow());
                int d = context.getFlowController().getTurnPlayer()
                        .getUserDirectiveReader().readDirective();
                // TODO 处理用户指令
            }
        });
    }

    public DuelContext start() {
        return new DuelContext(null, null, null, null, null);
    }

}
