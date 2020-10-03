package com.github.freeygo.engine.event;

/**
 * @author 戴志勇
 */
public interface EventHandler {

    <T> T handle(Event event);
}
