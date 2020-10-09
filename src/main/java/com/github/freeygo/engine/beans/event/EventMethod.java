package com.github.freeygo.engine.beans.event;

public interface EventMethod<R> {


    <T> R call(T t);

}
