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

package com.github.freeygo.temp;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author Zhiyong Dai
 */
public class JsonAnswer extends HashMap<String, Object> {
    /**
     * 同步类型结果，返回的{@code data}即是结果。
     */
    public static final int SYNC_DATA = 1;
    /**
     * 异步类型的结果，请求已经处理，如果要查看结果，必须通过其他接口。
     */
    public static final int ASYNC_DATA = 2;

    private static final Consumer<Throwable> exceptionHandler = (Throwable t) -> {
        t.printStackTrace();
        throw new RuntimeException(t);
    };


    /**
     * 请求处理状态，true：成功，false：失败。
     */
    private boolean status;
    /**
     * 成功的提示消息。
     */
    private String successMessage;
    /**
     * 失败的提示消息。
     */
    private String failureMessage;
    /**
     * 错误代码。
     * 提示错误类型。
     */
    private String errorCode;
    /**
     * 请求处理结果。
     */
    private Map<String, Object> data;
    /**
     * 请求处理结果类型。
     */
    private int dataType;


    /**
     * 模板返回数据
     */
    public void templateAnswer() {
        put("status", status);
        put("successMessage", successMessage);
        put("failureMessage", failureMessage);
        put("errorCode", errorCode);
        put("data", data);
        put("dataType", dataType);
    }


    /**
     * @param name
     * @param value
     * @return
     */
    public JsonAnswer set(String name, Object value) {
        getData().put(name, value);
        return this;
    }

    public <T> JsonAnswer set(String name,
                              Supplier<T> supplier,
                              Consumer<Throwable> exceptionHandler) {
        try {
            getData().put(name, supplier.get());
        } catch (Throwable t) {
            processException(t, exceptionHandler);
        }
        return this;
    }

    public <T> JsonAnswer set(String name, Supplier<T> supplier) {
        return set(name, supplier, null);
    }

    protected void
    processException(Throwable t, Consumer<Throwable> exceptionHandler) {
        if (getExceptionHandler(exceptionHandler) != null) {
            getExceptionHandler(exceptionHandler).accept(t);
        }
    }

    private Consumer<Throwable>
    getExceptionHandler(Consumer<Throwable> exceptionHandler) {
        return exceptionHandler != null ?
                exceptionHandler : JsonAnswer.exceptionHandler;
    }


    public <R> R find(String name) {
        return (R) getData().get(name);
    }

    protected Map<String, Object> getData() {
        return data;
    }


}
