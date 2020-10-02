package com.github.freeygo.engine.cardscript;

/**
 * @author 戴志勇
 */
public interface EventAnswer<T> {

    void accept(T t);
}
