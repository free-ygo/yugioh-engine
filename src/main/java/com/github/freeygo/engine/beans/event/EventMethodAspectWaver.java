package com.github.freeygo.engine.beans.event;

/**
 * This is an event method aspect waver. Use the {@link EventMethod<R>} as an
 * target object and the {@link EventMethodAspect} as an aspect.
 *
 * @param <R>
 */
public class EventMethodAspectWaver<R> {


    private final EventMethod<? extends R> method;
    private final EventMethodAspect aspect;

    public EventMethodAspectWaver(EventMethod<? extends R> method,
                                  EventMethodAspect aspect) {
        this.method = method;
        this.aspect = aspect;
    }

    public R call(Object... params) {
        R result = null;
        if (aspect.preCall(params)) {
            result = method.call(params);
            aspect.postCall(result);
        }
        return result;
    }
}
