package ru.tinkoff.benchmark.aop.utils;

public interface AspectProductionCacheOnly {

    User doWorkCacheOnly(String id, AspectConsumer consumer);
}
