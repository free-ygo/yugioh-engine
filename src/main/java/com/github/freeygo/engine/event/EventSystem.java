package com.github.freeygo.engine.event;

import java.util.concurrent.CompletableFuture;

public interface EventSystem {

    void register(EventType eventType, EventSubject subject);

    void send(Event event);

    <T> T send(Event event, EventAction<T> action);

    void sendAsync(Event event);

    <T> CompletableFuture<T> sendAsync(Event event, EventAction<T> action);
}
