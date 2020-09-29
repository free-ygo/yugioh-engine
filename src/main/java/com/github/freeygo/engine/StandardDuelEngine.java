package com.github.freeygo.engine;

import org.luaj.vm2.Globals;
import org.luaj.vm2.lib.jse.JsePlatform;

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
            Globals luaGlobals = context.getAttribute(LUA_GLOBALS);
            if (luaGlobals == null) {
                luaGlobals = JsePlatform.standardGlobals();
            }
            return luaGlobals.load(script);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    protected String globalContext() {
        return new StringBuilder()
                .toString();
    }
}
