package ru.tinkoff.benchmark.aop.utils;

public interface AspectEmulator {

    String doNothing1(String arg1, AspectConsumer consumer);

    String doNothing12345(String arg1, AspectConsumer consumer);

    String doWorkBig1(String arg1, AspectConsumer consumer);

    String doWorkBig12345(String arg1, AspectConsumer consumer);

    String doWorkLoggerOff1(String arg1, AspectConsumer consumer);

    String doWorkLoggerOff12345(String arg1, AspectConsumer consumer);

    String doWorkMedium1(String arg1, AspectConsumer consumer);

    String doWorkMedium12345(String arg1, AspectConsumer consumer);

    String doWorkSmall1(String arg1, AspectConsumer consumer);

    String doWorkSmall12345(String arg1, AspectConsumer consumer);
}
