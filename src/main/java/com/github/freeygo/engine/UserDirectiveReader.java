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

import com.github.freeygo.engine.cmd.Action;

/**
 * 用户交互接口
 *
 * @author Zhiyong Dai
 */
public interface UserDirectiveReader {

    int selectIdleMonsterField();

    <R> Action<R> selectDirectives();

    int selectField();

    Effect notifyActivateEffect();

    int notifyMessage(String message);

    int readDirective();

    String readLine();
}
