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

package com.github.freeygo.engine.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zhi yong Dai
 */
public class ViewUtils {
    public static List<String> getCommands() {
        return Arrays.asList("s");
    }

    public static void commandMenu() {
        String view = "";
        view += "*******************************************";
        view += "*               Command Menu              *";
        view += "*******************************************";
        view += "* Commands:                               *";
        view += "* command arg1 arg2...                    *";
        view += "* s    Summon monster                     *";
        view += "* arguments:                              *";
        view += "* s [id] [area]    usages:  s 21 1        *";
        view += "*******************************************";
        System.out.println(view);
    }

    public static String[] resolve(String line) {
        String[] result = line.split("\\s+");
        List<String> l = new ArrayList<>();
        for (String s : result) {
            if (s != null) {
                l.add(s);
            }
        }
        return l.toArray(new String[]{});
    }

    public static boolean inputCorrect(String line) {
        return getCommands().contains(resolve(line)[0]);
    }

    public static void displayDuelField(Duel duel) {
        String s = "";
        s += "**************************************************************";
        s += "* P1: Hand: %s, Grave: %s, Deck: %s, Extra Deck: %s           ";
        s += "*   Hand: %s %s                                               *";
    }
}
