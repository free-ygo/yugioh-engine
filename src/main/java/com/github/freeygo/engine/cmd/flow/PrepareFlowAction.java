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
public class PrepareFlowAction implements FlowAction<Void> {

    private static final Logger logger = LoggerFactory.getLogger(PrepareFlowAction.class);

    @Override
    public Void action(DuelContext context) {
        logger.debug("Prepare phrase start, round: {}, player: {}",
                context.getRoundDial().getCurrentRound(),
                context.getRoundDial().getRoundPlayer().getName());
        logger.debug("Apply activated effects: ");

        logger.debug("Roundly inquiry players whether activate effects");
        context.getRoundDial().getPlayers();

        logger.debug("Wait player {} actions",
                context.getRoundDial().getRoundPlayer().getName());
        logger.debug("Prepare phrase end, round: {}",
                context.getRoundDial().getCurrentRound());

        // 检查是否需要处理适用的效果
        // 检查是否有可以发动的效果，若有从回合玩家开始发动，若
        // 放弃了发卡优先权，进入下一阶段，否则依次处理发动的卡
//        LinkedList<Effect> effects = new LinkedList<>();
//        Player turnPlayer = context.getFlowController().getRoundPlayer();
//        FlowController fc = context.getFlowController();
//        context.getFlowController()
//                .roundUntil(turnPlayer, (sp, np) -> {
//                    if (np.hasActiveEffects()) {
//                        return np;
//                    }
//                    return sp;
//                }, (np) -> true, (p) -> {
//                    p.getUserDirectiveReader().readDirective();
//                });
        return null;
    }
}
