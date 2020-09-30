package com.github.freeygo.engine.cardscript;

public interface EventListener<T extends Event> {
    void action(T e);
}
