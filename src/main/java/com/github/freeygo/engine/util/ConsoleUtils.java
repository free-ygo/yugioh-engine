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

import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author Zhi yong Dai
 */
public class ConsoleUtils {

    public static String readLine() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        scanner.close();
        return line;
    }

    public static String readLine(String s) {
        System.out.println(s);
        return readLine();
    }

    public static PrintStream println() {
        println("\n");
        return System.out;
    }


    public static void println(String s) {
        System.out.println(s);
    }

    public static void print(String s) {
        System.out.println(s);
    }

    public static PrintBuilder printLines(String s) {
        PrintBuilder builder = new PrintBuilder();
        builder.append(s);
        return builder;
    }

    public static class PrintBuilder {
        private StringBuilder sb = new StringBuilder();

        public PrintBuilder append(String s) {
            sb.append(s);
            return this;
        }

        public PrintBuilder appendln(String s) {
            sb.append(s).append("\n");
            return this;
        }

        public PrintBuilder print() {
            System.out.print(sb);
            return this;
        }

        public PrintBuilder clear() {
            sb = new StringBuilder();
            return this;
        }
    }
}
