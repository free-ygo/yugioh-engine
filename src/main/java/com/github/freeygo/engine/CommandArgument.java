/*
 * Copyright (c) 2020 free-ygo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.freeygo.engine;

/**
 * @author Zhi yong Dai
 */
public class CommandArgument {

    /**
     * Normal summon command
     */
    public static final int NORMAL_SUMMON = 1001;
    public static final int MONSTER_AREA = 1101;
    public static final int FIRST = 1201;
    public static final int SECOND = 1202;

    private int location;
    private int destinationArea;
    private Card card;
    private int commandType;
    private int duelist;


    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getDestinationArea() {
        return destinationArea;
    }

    public void setDestinationArea(int destinationArea) {
        this.destinationArea = destinationArea;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public int getCommandType() {
        return commandType;
    }

    public void setCommandType(int commandType) {
        this.commandType = commandType;
    }

    public int getDuelist() {
        return duelist;
    }

    public void setDuelist(int duelist) {
        this.duelist = duelist;
    }
}
