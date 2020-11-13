package com.example.demo.core.functional;

@FunctionalInterface
public interface Squarer<T> {
    T square(T x);
}
