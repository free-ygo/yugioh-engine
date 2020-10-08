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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Zhi yong Dai
 */
public abstract class AbstractProcedure implements Procedure {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractProcedure.class);
    private static final String BEFORE_CALL = "beforeCall";
    private static final String AFTER_CALL = "afterCall";
    private final String procedureName;
    private ProcedureCallContext context;
    private final Object eventSource;
    private EventListenerRegistry listenerRegistry;


    public AbstractProcedure(Object eventSource, String procedureName,
                             ProcedureCallContext context) {
        this.procedureName = procedureName;
        this.context = context;
        this.eventSource = eventSource;
    }


    @Override
    public String getProcedureName() {
        return procedureName;
    }

    @Override
    public Object call() {
        if (context == null || context.getTargetProcedure() == null) {
            return null;
        }
        Procedure p = fireProcedureCallEvent(BEFORE_CALL, newBeforeCallEvent());
        TargetProcedure tp = p == null ?
                context.getTargetProcedure() :
                p.getContext().getTargetProcedure();
        Object returnValue = null;
        if (tp != null) {
            returnValue = tp.procedure(() -> context);
            context.setReturnValue(returnValue);
            fireProcedureCallEvent(AFTER_CALL, newAfterCallEvent());
        }
        return returnValue;
    }

    public Object getEventSource() {
        return eventSource;
    }

    private Procedure fireProcedureCallEvent(String eventType, CallEvent e) {
        if (e == null) {
            throw new RuntimeException("Procedure call event cannot be null");
        }
        if (e.getProcedureCallContext() == null) {
            throw new RuntimeException("Procedure call context cannot be null");
        }
        if (listenerRegistry == null) {
            listenerRegistry = new StandardEventListenerRegistry();
        }
        if (BEFORE_CALL.equals(eventType)) {
            listenerRegistry.push(getProcedureName(), e);
            if (e.getProcedure() != null) {
                return e.getProcedure();
            }
        }
        if (AFTER_CALL.equals(eventType)) {
            listenerRegistry.push(getProcedureName(), e);
        }
        return null;
    }

    protected abstract CallEvent newAfterCallEvent();

    protected abstract CallEvent newBeforeCallEvent();

    @Override
    public ProcedureCallContext getContext() {
        return context;
    }

    @Override
    public void setContext(ProcedureCallContext context) {
        this.context = context;
    }


//
//
//    @Override
//    public Object call() {
//        if (targetProcedure != null) {
//            Procedure p = fireCallProcedureEvent(beforeCallListener, null);
//            TargetProcedure tp = p != null ?
//                    p.getTargetProcedure() : targetProcedure;
//            if (tp != null) {
//                Object result = tp.procedure(getContext(), getCaller(), procedureName, arguments);
//                fireCallProcedureEvent(afterCallListener, result);
//                return result;
//            }
//        }
//        return null;
//    }
//
//    public void addAfterCallListener(AfterCallListener listener) {
//        if (this.afterCallListener != null) {
//            this.afterCallListener = listener;
//        }
//    }
//
//    public void addBeforeCallListener(BeforeCallListener listener) {
//        if (this.beforeCallListener != null) {
//            this.beforeCallListener = listener;
//        }
//    }
//
//    protected Procedure fireCallProcedureEvent(EventListener listener,
//                                               Object returnValue) {
//        if (listener != null) {
//            StandardProcedureCallContext context = new StandardProcedureCallContext();
//            ProcedureCallEvent e = new ProcedureCallEvent(this, );
//            if (listener instanceof BeforeCallListener) {
//                beforeCallListener.beforeCall(e);
//                return e.getProcedure();
//            }
//            if (listener instanceof AfterCallListener) {
//                afterCallListener.afterCall(e);
//            }
//        }
//        return null;
//    }
}
