package com.github.freeygo.engine.event;

import java.util.concurrent.CompletableFuture;

public interface EventSystem {

    void register(EventType eventType, EventSubject subject);

    <T> T send(Event event);

    <T> T send(Event event, EventAction<T> action);

    <T> CompletableFuture<? super T> sendAsync(Event event);

    <T> CompletableFuture<T> sendAsync(Event event, EventAction<T> action);
}
