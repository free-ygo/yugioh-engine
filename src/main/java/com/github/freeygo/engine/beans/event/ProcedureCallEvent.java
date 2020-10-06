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

package com.github.freeygo.engine.beans.event;

import java.util.EventObject;

/**
 * @author Zhi yong Dai
 */
public class ProcedureCallEvent extends EventObject {

    private Object callObject;
    private String methodName;
    private Object[] arguments;
    private Object returnValue;
    private Procedure procedure;


    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ProcedureCallEvent(Object source, Object callObject, String methodName,
                              Object[] arguments, Object returnValue) {
        super(source);
    }

    public String getMethodName() {
        return methodName;
    }

    public Object[] getArguments() {
        return arguments;
    }

    public Object getReturnValue() {
        return returnValue;
    }

    /**
     * 如果该方法返回了{@link Procedure}，那么会用返回的{@link Procedure}代替源过程
     * 执行，并将该过程的返回值作为原来过程的返回值。
     *
     * @return
     */
    public Procedure getProcedure() {
        return procedure;
    }

    public void setProcedure(Procedure procedure) {
        this.procedure = procedure;
    }
}
