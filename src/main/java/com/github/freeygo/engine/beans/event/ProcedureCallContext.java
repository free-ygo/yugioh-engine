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

import com.github.freeygo.engine.beans.event.Procedure.TargetProcedure;

/**
 * @author Zhi yong Dai
 */
public final class ProcedureCallContext {

    private Object context;
    private Object caller;
    private Object[] arguments;
    private Object returnValue;
    private String procedureName;
    private TargetProcedure targetProcedure;


    public ProcedureCallContext(Object context, Object caller, Object[] arguments,
                                Object returnValue, String procedureName, TargetProcedure targetProcedure) {
        this.context = context;
        this.caller = caller;
        this.arguments = arguments;
        this.returnValue = returnValue;
        this.procedureName = procedureName;
        this.targetProcedure = targetProcedure;
    }

    public Object getContext() {
        return context;
    }

    public void setContext(Object context) {
        this.context = context;
    }

    public Object getCaller() {
        return caller;
    }

    public void setCaller(Object caller) {
        this.caller = caller;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public Object[] getArguments() {
        return arguments;
    }

    public void setArguments(Object... arguments) {
        this.arguments = arguments;
    }

    public Object getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(Object returnValue) {
        this.returnValue = returnValue;
    }

    public TargetProcedure getTargetProcedure() {
        return targetProcedure;
    }

    public void setTargetProcedure(TargetProcedure targetProcedure) {
        this.targetProcedure = targetProcedure;
    }

    //    Procedure getProcedure();
//    void setProcedure(Procedure procedure);
}