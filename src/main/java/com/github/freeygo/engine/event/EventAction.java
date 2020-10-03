package com.github.freeygo.engine.event;

/**
 * 事件行为
 *
 * @author 戴志勇
 */
public interface EventAction<T> {

     T action(Event event);
}
