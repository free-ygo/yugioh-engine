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
import com.github.freeygo.engine.Effect;
import com.github.freeygo.engine.Player;
import com.github.freeygo.engine.event.EventType;
import com.github.freeygo.engine.event.GameEvent;
import com.github.freeygo.engine.event.GameEventParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Zhiyong Dai
 */
public class DrawFlowAction implements FlowAction<Void> {

    private static final Logger logger = LoggerFactory.getLogger(DrawFlowAction.class);

    public DrawFlowAction() {
    }

    @Override
    public Void action(DuelContext context) {
        logger.debug("Draw phrase start, round: {}, player: {}, ",
                context.getRoundDial().getCurrentRound(),
                context.getRoundDial().getRoundPlayer().getName()
        );

        logger.debug("Apply activated effects: ");
        context.getEffectManager().getCanApplyEffects().forEach(Effect::apply);

        logger.debug("Roundly inquiry players whether activate effects");
        Map<Player, List<Effect>> effects =
                context.getEffectManager().getCanActivateEffects().stream()
                        .collect(Collectors.groupingBy(Effect::getController));
        context.getRoundDial().iterator(context.getRoundDial().getRoundPlayer())
                .forEachRemaining(e -> {
                    logger.debug("Can activate: {}", effects.get(e));
                    e.getUserDirectiveReader().readLine();
                });

        logger.debug("Wait player {} actions",
                context.getRoundDial().getRoundPlayer().getName());
        GameEventParser gep = context.getGameEventParser();
        GameEvent ge;
        do {
            String cmd = context.getRoundDial().getRoundPlayer()
                    .getUserDirectiveReader().readLine();
            ge = gep.parse(cmd);
            context.getEventSystem().send(ge);
        } while (ge != null && ge.getEventType() != EventType.FLOW_CHANGE);
//        ActionController<Boolean> action =
//                new ActionController<>(new NormalDrawAction(player));
//        context.getEventSystem()
//                .send(new DrawCardEvent(player, NORMAL))
//                .then(() -> action.action(context));
        logger.debug("Draw phrase end, round: {}",
                context.getRoundDial().getCurrentRound());
        return null;
    }
}
