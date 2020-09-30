package com.github.freeygo.engine.cardscript;

import org.junit.jupiter.api.Test;

class StandardCardScriptCommandTest {

    @Test
    void call() {
        StandardCardScriptCommand command = new StandardCardScriptCommand();
        command.getEventManager().addListener(CallEvent.class, (e) -> {
            System.out.println("发生了召唤事件");
        });
        command.call();
    }
}