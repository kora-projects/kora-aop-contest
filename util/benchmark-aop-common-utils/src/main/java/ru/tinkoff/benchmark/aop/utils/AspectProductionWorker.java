package ru.tinkoff.benchmark.aop.utils;

public final class AspectProductionWorker {

    private AspectProductionWorker() {}

    public static User doWorkWithId(String id, AspectConsumer consumer) {
        User user = new User(id, "Foo");
        consumer.consume(user);
        return user;
    }
}
