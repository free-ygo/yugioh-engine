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

import com.github.freeygo.engine.beans.event.ProcedureCallListener.AfterCallListener;
import com.github.freeygo.engine.beans.event.ProcedureCallListener.BeforeCallListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.EventListener;

/**
 * @author Zhi yong Dai
 */
public class AbstractProcedure implements Procedure {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractProcedure.class);

    private String procedureName;

    private Object[] arguments;

    private Object caller;

    private Object context;

    private AfterCallListener afterCallListener;
    private BeforeCallListener beforeCallListener;


    private TargetProcedure targetProcedure = (context, caller, method, args) -> {
        LOG.debug("Method {} is called with args [{}] by caller {} ",
                method, Arrays.toString(args), caller);
        return null;
    };


    @Override
    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public Object[] getArguments() {
        return arguments;
    }

    @Override
    public void setArguments(Object... arguments) {
        this.arguments = arguments;
    }

    public Object getCaller() {
        return caller;
    }

    @Override
    public void setCaller(Object caller) {
        this.caller = caller;
    }

    public TargetProcedure getTargetProcedure() {
        return targetProcedure;
    }

    @Override
    public void setTargetProcedure(TargetProcedure targetProcedure) {
        if (targetProcedure != null) {
            this.targetProcedure = targetProcedure;
        }
    }

    @Override
    public Object getContext() {
        return context;
    }

    @Override
    public void setContext(Object context) {
        this.context = context;
    }

    @Override
    public Object call() {
        if (targetProcedure != null) {
            Procedure p = fireCallProcedureEvent(beforeCallListener, null);
            TargetProcedure tp = p != null ?
                    p.getTargetProcedure() : targetProcedure;
            if (tp != null) {
                Object result = tp.procedure(getContext(), getCaller(), procedureName, arguments);
                fireCallProcedureEvent(afterCallListener, result);
                return result;
            }
        }
        return null;
    }

    public void addAfterCallListener(AfterCallListener listener) {
        if (this.afterCallListener != null) {
            this.afterCallListener = listener;
        }
    }

    public void addBeforeCallListener(BeforeCallListener listener) {
        if (this.beforeCallListener != null) {
            this.beforeCallListener = listener;
        }
    }

    protected Procedure fireCallProcedureEvent(EventListener listener,
                                               Object returnValue) {
        if (listener != null) {
            ProcedureCallEvent e = new ProcedureCallEvent(this, caller,
                    procedureName, arguments, returnValue);
            if (listener instanceof BeforeCallListener) {
                beforeCallListener.beforeCall(e);
                return e.getProcedure();
            }
            if (listener instanceof AfterCallListener) {
                afterCallListener.afterCall(e);
            }
        }
        return null;
    }
}
