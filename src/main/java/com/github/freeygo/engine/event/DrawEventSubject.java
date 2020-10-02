package com.github.freeygo.engine.event;

/**
 * @author 戴志勇
 */
public class DrawEventSubject implements EventSubject {

//    private EventManager eventManager;

    public DrawEventSubject(EventManager eventManager) {
//        this.eventManager = eventManager;
        // 抽卡不够事件
//        eventManager.register(EventType.DECK_NO_CARD, this);
        // 注册抽卡事件
        eventManager.register(EventType.DRAW_CARD, this);
    }

    @Override
    public void notice(Event event) {

    }
}
