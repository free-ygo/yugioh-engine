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

/**
 * @author Zhi yong Dai
 */
public interface Procedure {

    /**
     * Get the name of procedure.
     *
     * @return procedure name
     */
    String getProcedureName();

    /**
     * Set this procedure name. The procedure name can be null
     *
     * @param name procedure name
     */
    void setProcedureName(String name);

    /**
     * The method will return arguments of {@link Procedure}. The return value
     * is not null.
     *
     * @return Arguments of {@link Procedure}
     */
    Object[] getArguments();

    /**
     * Set arguments for {@link Procedure}.
     *
     * @param arguments arguments for {@link Procedure}
     */
    void setArguments(Object... arguments);

    /**
     * The caller of {@link Procedure}. This return value can be null. The
     * {@code caller} object for static method is define context and for
     * instance method is caller of calling. If the caller is a null that prove
     * the procedure is not associated to calling context.
     *
     * @return caller, can be null.
     */
    Object getCaller();

    /**
     * Set the caller of {@link Procedure}. The parameter can be null.
     *
     * @param caller the caller of {@link Procedure}
     */
    void setCaller(Object caller);

    /**
     * Call this {@link Procedure}. In fact, The call of procedure delegate to
     * another real method or procedure. If the {@link #getTargetProcedure()}
     * is null, it will do nothing and return null, or will return the target
     * procedure's return value.
     *
     * @return return value of target procedure
     * @see #getTargetProcedure()
     * @see #setTargetProcedure(TargetProcedure)
     */
    Object call();

    /**
     * Return the target {@link Procedure}.
     *
     * @return target procedure
     */
    TargetProcedure getTargetProcedure();

    /**
     * Set the target {@link Procedure}. It can be null. If target procedure is
     * null, {@link Procedure} will do nothing and return {@code null}.
     *
     * @param targetProcedure {@link Procedure}
     */
    void setTargetProcedure(TargetProcedure targetProcedure);

    /**
     * An interface for target procedure.
     */
    @FunctionalInterface
    interface TargetProcedure {
        Object procedure(Object caller, String method, Object... args);
    }
}
