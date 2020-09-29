package com.github.freeygo.engine;

public class StandardDuelEngine implements DuelEngine {


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
        return null;
    }
}
