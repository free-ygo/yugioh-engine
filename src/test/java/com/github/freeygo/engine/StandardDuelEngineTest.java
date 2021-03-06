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
//package com.github.freeygo.engine;
//
//import com.github.freeygo.engine.event.EventSystem;
//import com.github.freeygo.engine.event.StandardEventSystem;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
///**
// * @author Zhi yong Dai
// */
//class StandardDuelEngineTest {
//
//    private DuelEngine duelEngine;
////    private DuelEngineContext engineContext;
//    private Duel duel;
//
//
//    @BeforeEach
//    void setUp() {
////        Function<Integer, Card> supplier = (i) -> {
////            Card card = new StandardCard();
////            card.setRuntimeId("" + i);
////            card.setName("童话动物·小兔子");
////            card.setTags(Arrays.asList("童话动物"));
////            card.setCategory(Card.Category.MONSTER);
////            card.setAttack(0);
////            card.setDefense(2100);
////            card.setLevel(2);
////            card.setAttribute(Card.Attribute.EARTH);
////            card.setRace(Card.Race.BEAST);
////            return card;
////        };
////
////        List<Card> cards1 = IntStream.rangeClosed(1, 40)
////                .mapToObj(i -> supplier.apply(i))
////                .collect(Collectors.toList());
////        List<Card> cards2 = IntStream.rangeClosed(41, 80)
////                .mapToObj(i -> supplier.apply(i))
////                .collect(Collectors.toList());
////
////        engineContext = new StandardDuelEngineContext();
////        duelEngine = new StandardDuelEngine();
////
////        EventSystem eventSystem = new StandardEventSystem();
////        duelEngine.setEventSystem(eventSystem);
////
////        DuelDisk firstDisk = new AbstractDuelDisk();
//////        firstDisk.getDeckArea().addAll(cards1);
////
////        Duelist first = new StandardDuelist();
////        first.setDuelDisk(firstDisk);
////
////        DuelDisk secondDisk = new AbstractDuelDisk();
//////        secondDisk.getDeckArea().addAll(cards2);
////
////        Duelist second = new StandardDuelist();
////        second.setDuelDisk(secondDisk);
////
////        DuelistPair pair = new DuelistPair();
////        pair.setFirstDuelist(first);
////        pair.setSecondDuelist(second);
////
////
////        duel = new StandardDuel();
////        duel.setDuelistPair(pair);
////        duel.setContext(new StandardDuelContext());
////        duel.setCurrentRound(new StandardRound(1));
//
//    }
//
//
//    @Test
//    void setContext() {
//        duelEngine.setEngineContext(engineContext);
//    }
//
//    @Test
//    void getContext() {
//        duelEngine.setEngineContext(engineContext);
//        assertThat(duelEngine).isNotNull();
//    }
//
//    @Test
//    void send() {
//
//    }
//
//    @Test
//    void testSend() {
//    }
//
//    @Test
//    void start() {
//    }
//
//    @Test
//    void globalContext() {
//    }
//
//    @Test
//    void sendCommand() {
//        assertThat(duel).isNotNull();
//
////        CommandArgument args = new CommandArgument();
////        args.setCommandType(CommandArgument.NORMAL_SUMMON);
////        args.setDestinationArea(CommandArgument.MONSTER_AREA);
////        args.setCard(card);
////        args.setLocation(1);
////        args.setDuelist(CommandArgument.FIRST);
//        duelEngine.start(duel);
////        duelEngine.send(args);
//    }
//}