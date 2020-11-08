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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Zhiyong Dai
 */
public class Main1FlowAction implements FlowAction<Void> {

    private static final Logger logger = LoggerFactory.getLogger(Main1FlowAction.class);

    @Override
    public Void action(DuelContext context) {
        logger.debug("Main1 phrase start, round: {}, player: {}",
                context.getRoundDial().getCurrentRound(),
                context.getRoundDial().getRoundPlayer().getName());
        logger.debug("Apply activated effects: ");

        logger.debug("Roundly inquiry players whether activate effects");
        context.getRoundDial().getPlayers();

        logger.debug("Wait player {} actions",
                context.getRoundDial().getRoundPlayer().getName());
        logger.debug("Main1 phrase end, round: {}",
                context.getRoundDial().getCurrentRound());
        // 处理适用卡片的效果
//        applyEffects(context);
//        startActions(context);
        // 等待回合玩家优先行动
        return null;
    }
}
