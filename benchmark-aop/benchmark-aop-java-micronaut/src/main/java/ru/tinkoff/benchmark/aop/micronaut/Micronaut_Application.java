package ru.tinkoff.benchmark.aop.micronaut;

import io.micronaut.runtime.Micronaut;

public class Micronaut_Application {

    public static void main(String[] args) {
        Micronaut.build(args)
                .eagerInitSingletons(true)
                .eagerInitConfiguration(true)
                .banner(false)
                .start();
    }
}
