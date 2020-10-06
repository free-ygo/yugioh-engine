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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 戴志勇
 */
public class StandardRound implements Round {
    /**
     * 回合数
     */
    private Integer number;

    public StandardRound(Integer number) {
        this.number = number;
    }

    @Override
    public Integer getNumber() {
        return number;
    }

    @Override
    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public Stage getCurrentStage() {
        return null;
    }

    @Override
    public void setCurrentStage(Stage stage) {

    }

    @Override
    public Stage getNextStage() {
        return null;
    }

    @Override
    public void setNextStage(Stage stage) {

    }

    @Override
    public void nextStage() {

    }

    /**
     * 阶段
     */
    enum StandardPhrase implements Stage {
        /**
         * 开始阶段
         */
        START(() -> {
            System.out.println("Start Phrase");
        }, () -> {

        }),
        /**
         * 准备阶段
         */
        PREPARE(() -> {
        }, () -> {
        }),
        /**
         * 主要阶段1
         */
        MAIN_1(() -> {
        }, () -> {
        }),
        /**
         * 战斗阶段
         */
        BATTLE(() -> {
        }, () -> {
        }),
        /**
         * 战斗阶段的开始步骤
         */
        BATTLE_START(() -> {
        }, () -> {
        }),
        /**
         * 战斗阶段的战斗步骤
         */
        BATTLE_FIGHT(() -> {
        }, () -> {
        }),
        /**
         * 战斗阶段的伤害步骤
         */
        BATTLE_DAMAGE(() -> {
        }, () -> {
        }),
        /**
         * 战斗阶段的结束步骤
         */
        BATTLE_END(() -> {
        }, () -> {
        }),
        /**
         * 主要阶段2
         */
        MAIN_2(() -> {
        }, () -> {
        }),
        /**
         * 结束阶段
         */
        END(() -> {
        }, () -> {
        });

        private final Runnable startAction;
        private final Runnable endAction;
        private final StandardStep[] steps;

        StandardPhrase(Runnable startAction, Runnable endAction, StandardStep... steps) {
            this.startAction = startAction;
            this.endAction = endAction;
            this.steps = steps;
        }

        @Override
        public void start() {
            startAction.run();
        }

        @Override
        public void end() {
            endAction.run();
        }

        @Override
        public List<Stage> getChildStages() {
            return steps == null ? new ArrayList<>() : Arrays.asList(steps);
        }
    }

    enum StandardStep implements Stage {
        BATTLE_START, BATTLE_FIGHT, BATTLE_DAMAGE, BATTLE_END;

        @Override
        public void start() {

        }

        @Override
        public void end() {

        }

        @Override
        public List<Stage> getChildStages() {
            return new ArrayList<>();
        }
    }
}
