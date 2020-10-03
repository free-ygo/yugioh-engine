package com.github.freeygo.engine;

import com.github.freeygo.engine.event.EventFactory;
import com.github.freeygo.engine.event.EventSystem;
import com.github.freeygo.engine.event.MoveCardEventSubject;
import com.github.freeygo.engine.event.StandardEventSystem;
import org.luaj.vm2.Globals;
import org.luaj.vm2.lib.jse.JsePlatform;

import java.util.concurrent.CompletableFuture;

public class StandardDuelEngine implements DuelEngine {

    public static final String LUA_GLOBALS = "__LUA_GLOBALS__";

    private DuelContext context;

    public StandardDuelEngine() {
        context = new StandardDuelContext();
    }

    public StandardDuelEngine(DuelContext context) {
        this.context = context;
    }

    public void setContext(DuelContext context) {
        this.context = context;
    }

    public DuelContext getContext() {
        return context;
    }


    @Override
    public Object send(String script) {
        // TODO 执行任务
        return null;
    }

    @Override
    public Object send(String script, DuelContext context) {
        try {
            Globals globals = context.getAttribute(LUA_GLOBALS);
            if (globals == null) {
                globals = JsePlatform.standardGlobals();
            }
            return globals.load(script);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    @Override
    public void start(Duel duel) {
        EventSystem eventSystem = new StandardEventSystem();
        new MoveCardEventSubject<CompletableFuture>(eventSystem);
        DuelDisk a = new StandardDuelDisk();
        DuelDisk b = new StandardDuelDisk();
        EventFactory.drawCard().duelDisk(a).send(eventSystem);
        EventFactory.drawCard().duelDisk(b).send(eventSystem);
        EventFactory.round();


    }


    protected String globalContext() {
        return new StringBuilder()
                .toString();
    }
}
