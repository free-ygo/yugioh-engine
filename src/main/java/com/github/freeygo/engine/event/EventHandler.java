package com.github.freeygo.engine.event;

/**
 * @author 戴志勇
 */
public interface EventHandler {

    Object handle(Event event, EventAction callback);
}
