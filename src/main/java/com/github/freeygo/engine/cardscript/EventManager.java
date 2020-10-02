package com.github.freeygo.engine.cardscript;

public interface EventManager {

//    <T extends Event> void send(T e);
//
//    <T extends Event> void addListener(Class<T> clazz, EventListener<T> listener);

    void register(int eventType, EventListener listener);

    void push(Event event);

    <T> void push(Event event, EventAnswer<T> answer);
}
