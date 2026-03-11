package ru.tinkoff.benchmark.aop.utils;

import java.util.concurrent.CompletableFuture;

public interface AspectProduction {

    // Without @Timeout (cause Spring can't support it)
    User doWork(String id, AspectConsumer consumer);

    // Without @Timeout (cause Spring can't support it)
    CompletableFuture<User> doWorkCompleted(String id, AspectConsumer consumer);

    // Cause Resilient4j @Timeout can't handle Spring SYNC signature
    CompletableFuture<User> doWorkTimeoutAsync(String id, AspectConsumer consumer);

    // Cause Resilient4j @Timeout can't handle Spring SYNC signature
    CompletableFuture<User> doWorkTimeoutCompleted(String id, AspectConsumer consumer);
}
