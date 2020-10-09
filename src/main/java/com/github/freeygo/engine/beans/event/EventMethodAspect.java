package com.github.freeygo.engine.beans.event;

public interface EventMethodAspect {

    boolean preCall(Object... params);

    <T> T postCall(T t);
}
