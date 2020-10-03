package com.github.freeygo.engine.event;

/**
 * @author 戴志勇
 */
public interface EventSubject<T> {

    /**
     * 通知一个事件
     *
     * @param event 事件
     */
    T notice(Event event);
}
