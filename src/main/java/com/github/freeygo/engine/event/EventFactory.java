package com.github.freeygo.engine.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 戴志勇
 */
public class EventFactory {

    private static final Logger log = LoggerFactory.getLogger(EventFactory.class);
    private static EventSystem eventSystem;

    public static void setEventSystem(EventSystem eventSystem) {
        EventFactory.eventSystem = eventSystem;
    }

    public static MoveCardEventBuilder moveCard() {
        return new MoveCardEventBuilder();
    }

    public static DrawCardEventBuilder drawCard() {
        return new DrawCardEventBuilder();
    }

    public static RoundChangeEventBuilder roundChange() {
        return new RoundChangeEventBuilder();
    }

    public static DuelStartEventBuilder duelStart() {
        return new DuelStartEventBuilder();
    }
}
