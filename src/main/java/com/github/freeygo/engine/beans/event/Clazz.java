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
//package com.github.freeygo.engine.beans.event;
//
//import com.github.freeygo.engine.beans.event.Procedure.TargetProcedure;
//
///**
// * @author Zhi yong Dai
// */
//public interface Clazz {
//    <T> void addProperty(String name, T value);
//
//    <T> T removeProperty(String name);
//
//    <T> void addStaticProperty(String name, T value);
//
//    <T> T removeStaticProperty(String name);
//
//    <T> T getValue(String name);
//
//    void addMethod(String name, TargetProcedure procedure);
//
//    TargetProcedure removeMethod(String name);
//
//    void addStaticMethod(String name);
//
//    TargetProcedure removeStaticMethod(String name, TargetProcedure procedure);
//
//    Object call(String name, Object... args);
//
//    Clazz newInstance(Object... args);
//
//    ClazzInfo getClazzInfo();
//}