package com.github.freeygo.engine.event;

import java.util.List;

/**
 * @author 戴志勇
 */
public class MoveCardEventSubject implements EventSubject {

    private List<EventHandler> eventHandlers;

//    private EventManager eventManager;

    public MoveCardEventSubject(EventSystem eventSystem) {
//        this.eventManager = eventManager;
        // 抽卡不够事件
//        eventManager.register(EventType.DECK_NO_CARD, this);
        // 注册抽卡事件
        eventSystem.register(EventType.DRAW_START, this);
    }


    @Override
    public <T> T notice(Event event, EventAction<? extends T> action) {
        if (event.getEventType() == EventType.DRAW_START) {
            MoveCardEvent e = (MoveCardEvent) event.getTarget();
            event.preventDefaultAction();
            return action.action();
        }
        throw new RuntimeException();
//        eventHandlers.forEach(e -> e.handle(event, callback));
    }
}
