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
        DuelistPair pair = duel.getDuelistPair();
        Duelist a = pair.getFirstDuelist();
        Duelist b = pair.getSecondDuelist();
        DuelDisk aDisk = a.getDuelDisk();
        DuelDisk bDisk = b.getDuelDisk();
        // 回合开始
        int initCards = 5;
        for (int i = 0; i < initCards; i++) {
            aDisk.getHandArea().push(aDisk.getDeckArea().pop());
        }

        for (int i = 0; i < initCards; i++) {
            bDisk.getHandArea().push(aDisk.getDeckArea().pop());
        }
    }


    protected String globalContext() {
        return new StringBuilder()
                .toString();
    }
}
