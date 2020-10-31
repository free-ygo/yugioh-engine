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

package com.github.freeygo.engine.exception;

/**
 * @author Zhiyong Dai
 */
public class CardNotEnoughException extends GameException {
    public CardNotEnoughException() {
    }

    public CardNotEnoughException(String message) {
        super(message);
    }

    public CardNotEnoughException(String message, Throwable cause) {
        super(message, cause);
    }

    public CardNotEnoughException(Throwable cause) {
        super(cause);
    }

    public CardNotEnoughException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
