package com.github.freeygo.engine.event;

public interface EventManager {

    void register(EventType eventType, EventSubject subject);

    void send(EventType eventType, Object o);
}
