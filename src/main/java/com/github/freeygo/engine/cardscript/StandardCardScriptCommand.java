package com.github.freeygo.engine.cardscript;

import com.github.freeygo.engine.DuelContext;

public class StandardCardScriptCommand implements CardScriptCommand {

    private final EventManager eventManager;
    private DuelContext context;

    public StandardCardScriptCommand() {
        eventManager = new StandardEventManager();
    }

    @Override
    public void call() {
//        CallEvent e = new CallEven;
        // 通知监听器
//        System.out.println("准备召唤");
//        eventManager.send(e);
//        System.out.println("执行召唤");
    }


    public EventManager getEventManager() {
        return eventManager;
    }
}
