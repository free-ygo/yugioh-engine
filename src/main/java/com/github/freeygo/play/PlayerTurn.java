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
///**
// * @author Zhi yong Dai
// */
//public class PlayerTurn {
//
//    private Player p1;
//    private Player p2;
//    private Player currentPlayer;
//
//    public PlayerTurn(Player p1, Player p2) {
//        this.p1 = p1;
//        this.p2 = p2;
//    }
//
//    public Player nextPlayer() {
//        if (currentPlayer == null) {
//            return currentPlayer = p1;
//        }
//        return currentPlayer = getOpponent(currentPlayer);
//    }
//
//    public Player getOpponent(Player p) {
//        if (p == p1) {
//            return p2;
//        }
//        return p1;
//    }
//}
