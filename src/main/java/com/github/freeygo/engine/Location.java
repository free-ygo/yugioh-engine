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

import com.github.freeygo.engine.DuelDisk.Area;

/**
 * The class is the card in the location of {@link CardArea} and {@link CardGrid};
 *
 * @author Zhi yong Dai
 */
public final class Location {

    private DuelDisk duelDisk;
    private Area area;
    private int grid;
    private int index;

    /**
     * @param area
     * @param grid
     * @param index
     */
    public Location(DuelDisk duelDisk, Area area, int grid, int index) {
        this.duelDisk = duelDisk;
        this.area = area;
        this.grid = grid;
        this.index = index;
    }

    public DuelDisk getDuelDisk() {
        return duelDisk;
    }

    public void setDuelDisk(DuelDisk duelDisk) {
        this.duelDisk = duelDisk;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public int getGrid() {
        return grid;
    }

    public void setGrid(int grid) {
        this.grid = grid;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
