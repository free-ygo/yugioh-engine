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

import java.util.function.Predicate;

/**
 * 动作控制器。
 *
 * @author Zhiyong Dai
 */
public class ActionController<R> implements Action<R> {

    private final Action<R> target;
    private Predicate<DuelContext> condition;
    private boolean skip;

    public ActionController(Action<R> target) {
        this.target = target;
    }

    public void skip() {
        this.skip = true;
    }

    public boolean isSkip() {
        return skip;
    }

    public void setCondition(Predicate<DuelContext> condition) {
        this.condition = condition;
    }

    @Override
    public R action(DuelContext context) {
        if (condition.test(context)) {
            return target.action(context);
        }
        return null;
    }
}
