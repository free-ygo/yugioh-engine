package com.github.freeygo.engine;

@FunctionalInterface
public interface CardCondition {
    boolean isMatch(Card card);
}
