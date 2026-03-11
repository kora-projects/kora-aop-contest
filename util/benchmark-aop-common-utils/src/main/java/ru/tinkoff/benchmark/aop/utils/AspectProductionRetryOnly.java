package ru.tinkoff.benchmark.aop.utils;

public interface AspectProductionRetryOnly {

    User doWorkRetryOnly(String id, AspectConsumer consumer);
}
