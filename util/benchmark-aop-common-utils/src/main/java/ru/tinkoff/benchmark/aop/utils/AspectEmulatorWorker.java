package ru.tinkoff.benchmark.aop.utils;

import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class AspectEmulatorWorker {

    private static final Logger logger = LoggerFactory.getLogger(AspectEmulatorWorker.class);

    private AspectEmulatorWorker() {}

    public static String doWork(String arg1, AspectConsumer consumer, WorkType workType) {
        return switch (workType) {
            case NOTHING -> doNothing(arg1, consumer);
            case SMALL -> doWorkSmall(arg1, consumer);
            case MEDIUM -> doWorkMedium(arg1, consumer);
            case BIG -> doWorkBig(arg1, consumer);
            case LOGGER_OFF -> doWorkLoggerOff(arg1, consumer);
        };
    }

    private static String doNothing(String arg1, AspectConsumer consumer) {
        consumer.consume(arg1);
        return arg1;
    }

    private static String doWorkBig(String arg1, AspectConsumer consumer) {
        StringBuilder builder = new StringBuilder(arg1);
        for (int i = 0; i < 25; i++) {
            builder.append(UUID.randomUUID());
        }
        String result = builder.toString();
        consumer.consume(result);
        return result;
    }

    private static String doWorkLoggerOff(String arg1, AspectConsumer consumer) {
        if (logger.isTraceEnabled()) {
            logger.trace("Emulate to trace method argument: {}", arg1);
            consumer.consume(arg1);
        }

        var result = arg1;
        consumer.consume(result);

        if (logger.isTraceEnabled()) {
            logger.trace("Emulate to trace method result: {}", result);
            consumer.consume(result);
        }

        return result;
    }

    private static String doWorkMedium(String arg1, AspectConsumer consumer) {
        String result = arg1
                + UUID.randomUUID()
                + UUID.randomUUID()
                + UUID.randomUUID()
                + UUID.randomUUID()
                + UUID.randomUUID();
        consumer.consume(result);
        return result;
    }

    private static String doWorkSmall(String arg1, AspectConsumer consumer) {
        String result = arg1 + UUID.randomUUID();
        consumer.consume(result);
        return result;
    }
}
