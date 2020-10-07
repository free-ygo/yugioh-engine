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
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author Zhi yong Dai
// */
//public final class ClazzInfo {
//    private Map<String, Property> properties;
//
//    private Map<String, Procedure> procedures;
//
//    private static final String STATIC_MEMBER_NAME_PREFIX = "~";
//
//    public ClazzInfo() {
//        properties = new HashMap<>();
//        procedures = new HashMap<>();
//    }
//
//    public void addProperty(String name, Property property) {
//        requireMemberName(name);
//        properties.put(name, property);
//    }
//
//    public void addStaticProperty(String name, Property property) {
//        properties.put(staticMemberName(name), property);
//    }
//
//    public <T> Property<T> removeProperty(String name) {
//        requireMemberName(name);
//        return properties.remove(name);
//    }
//
//    public <T> Property<T> removeStaticProperty(String name) {
//        return properties.remove(staticMemberName(name));
//    }
//
//
//    public <T> Property<T> getProperty(String name) {
//        if (name == null) return null;
//        return properties.get(name);
//    }
//
//    public <T> Property<T> getStaticProperty(String name) {
//        return properties.get(staticMemberName(name));
//    }
//
//
//    public void addMethod(String name, Procedure method) {
//        requireMemberName(name);
//        procedures.put(name, method);
//    }
//
//    public void addStaticMethod(String name, Procedure method) {
//        addMethod(staticMemberName(name), method);
//    }
//
//    public Procedure getMethod(String name) {
//        if (name == null) return null;
//        return procedures.get(name);
//    }
//
//    public Procedure getStaticMethod(String name) {
//        return getMethod(staticMemberName(name));
//    }
//
//    public Procedure removeMethod(String name) {
//        requireMemberName(name);
//        return procedures.remove(name);
//    }
//
//    public Procedure removeStaticMethod(String name) {
//        return removeMethod(staticMemberName(name));
//    }
//
//    private static boolean isStaticMember(String name) {
//        return name != null && !name.startsWith(STATIC_MEMBER_NAME_PREFIX);
//    }
//
//    private static void requireMemberName(String name) {
//        if (name == null) {
//            throw new ClassDefineException("The member name cannot be null");
//        }
//    }
//
//    private static String staticMemberName(String name) {
//        if (name == null) {
//            throw new ClassDefineException("The static member name cannot be null");
//        }
//        return STATIC_MEMBER_NAME_PREFIX + name;
//    }
//}
