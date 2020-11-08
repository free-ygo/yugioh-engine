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

package com.github.freeygo.engine.event;

import com.github.freeygo.engine.Flow;

/**
 * 流程事件
 *
 * @author Zhiyong Dai
 */
public class FlowEvent extends GameEvent {

    //    public static final Integer START = 1;
//    public static final Integer END = 2;
    public static final int CHANGE = 1;

    private final Flow nextFlow;
    private final Flow prevFlow;
    private final Integer type;

    /**
     * Constructs a prototypical Event.
     *
     * @param source   the object on which the Event initially occurred
     * @param nextFlow
     * @param prevFlow
     * @throws IllegalArgumentException if source is null
     */
    public FlowEvent(Object source, Flow nextFlow, Flow prevFlow, Integer type) {
        super(source);
        this.nextFlow = nextFlow;
        this.prevFlow = prevFlow;
        this.type = type;
    }

    public EventType getEventType() {
        return EventType.FLOW_CHANGE;
    }

    public Integer getType() {
        return type;
    }

    public Flow getNextFlow() {
        return nextFlow;
    }

    public Flow getPrevPhrase() {
        return prevFlow;
    }
}
