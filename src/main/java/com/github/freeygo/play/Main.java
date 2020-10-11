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
//package com.github.freeygo.play;
//
//import com.github.freeygo.engine.Card;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author Zhi yong Dai
// */
//public class Main {
//    public static void main(String[] args) {
//        Player p1 = newPlayer("p1", newDeck());
//        Player p2 = newPlayer("p2", newDeck());
//        PlayerTurn turn = new PlayerTurn(p1, p2);
//        while (true) {
//            Player mp = turn.nextPlayer();
//            if (mp.getDeck().isEmpty()) {
//                System.out.println(mp.getName() + " LOSE");
//            }
//            // TODO draw card from deck.
//
//            // TODO Main turn player action.
//
//            // TODO Turn is over.
//
//            // wait operate.
//        }
//    }
//
//    private static PlayerTurn getTurn(Player p1, Player p2) {
//        return new PlayerTurn(p1, p2);
//    }
//
//
//    private static List<Card> newDeck() {
//        return new ArrayList<>();
//    }
//
//    private static Player newPlayer(String name, List<Card> cards) {
//        return new Player(name, cards);
//    }
//}
