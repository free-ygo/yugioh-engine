///*
// * Copyright (c) 2020 free-ygo
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *     http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//package com.github.freeygo.engine.event;
//
//import com.github.freeygo.engine.DuelContext;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.concurrent.CompletableFuture;
//
///**
// * @author 戴志勇
// */
//public class DuelStartEventBuilder extends EventBuilder<DuelStartEvent> {
//
//    public static Logger logger = LoggerFactory.getLogger(DuelStartEventBuilder.class);
//    private DuelContext context;
//
//    public DuelStartEventBuilder() {
//        setDefaultAction((e) -> {
//            logger.info("A duel start");
//            return EventFactory.duelStart()
//                    .context(context)
//                    .send(context.getEventSystem());
//        });
//    }
//
//    public DuelStartEventBuilder context(DuelContext context) {
//        this.context = context;
//        return this;
//    }
//
//    @Override
//    public <E> CompletableFuture<? super E> sendAsync(EventSystem eventSystem) {
//        return eventSystem.sendAsync(build());
//    }
//
//    @Override
//    public <E> E send(EventSystem eventSystem) {
//        return eventSystem.send(build());
//    }
//
//    @Override
//    public DuelStartEvent build() {
//        DuelStartEvent result = new DuelStartEvent(getTarget());
//        result.setDuelContext(context);
//        result.setEventType(EventType.DUEL_START);
//        return result;
//    }
//}
