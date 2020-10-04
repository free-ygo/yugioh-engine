package com.github.freeygo.engine.event;

import com.github.freeygo.engine.DuelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

/**
 * @author 戴志勇
 */
public class DuelStartEventBuilder extends EventBuilder<DuelStartEvent> {

    public static Logger logger = LoggerFactory.getLogger(DuelStartEventBuilder.class);
    private DuelContext context;

    public DuelStartEventBuilder() {
        defaultAction((e) -> {
            logger.info("A duel start");
            return EventFactory.duelStart()
                    .context(context)
                    .send(context.getEventSystem());
        });
    }

    public DuelStartEventBuilder context(DuelContext context) {
        this.context = context;
        return this;
    }

    @Override
    public <E> CompletableFuture<? super E> sendAsync(EventSystem eventSystem) {
        return eventSystem.sendAsync(build());
    }

    @Override
    public <E> E send(EventSystem eventSystem) {
        return eventSystem.send(build());
    }

    @Override
    public DuelStartEvent build() {
        DuelStartEvent result = new DuelStartEvent(context);
        result.setDuelContext(context);
        result.setEventType(EventType.DUEL_START);
        return result;
    }
}
