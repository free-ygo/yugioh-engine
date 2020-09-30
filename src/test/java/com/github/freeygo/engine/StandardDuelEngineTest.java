package com.github.freeygo.engine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class StandardDuelEngineTest {

    private DuelContext context;
    private StandardDuelEngine engine;

    @BeforeEach
    void setUp() {
        context = new StandardDuelContext();
        engine = new StandardDuelEngine();
    }

    @Test
    void setContext() {
        assertDoesNotThrow(() -> engine.setContext(context));
    }

    @Test
    void getContext() {
        assertNotNull(engine.getContext(), "context cannot be null");
    }

    @Test
    void send() {
        assertDoesNotThrow(() -> engine.send("script"));
    }

    @Test
    void send2() {
        assertDoesNotThrow(() -> engine.send("script", new StandardDuelContext()));
    }

    @Test
    void play() {
        engine.send("发动效果 ", context);
        Duel duel = new StandardDuel();
        Duelist duelistA = new StandardDuelist();
        duel.setDuelistPair(new DuelistPair());
    }
}