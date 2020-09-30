package com.github.freeygo.engine;

public interface ScoreIndicator<E> {

    void plus(E e);

    void minus(E e);
}
