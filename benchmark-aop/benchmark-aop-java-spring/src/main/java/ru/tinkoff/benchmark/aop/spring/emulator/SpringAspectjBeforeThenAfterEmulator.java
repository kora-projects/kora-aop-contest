package ru.tinkoff.benchmark.aop.spring.emulator;

import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.AspectConsumer;
import ru.tinkoff.benchmark.aop.utils.AspectEmulator;
import ru.tinkoff.benchmark.aop.utils.AspectEmulatorWorker;
import ru.tinkoff.benchmark.aop.utils.WorkType;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.*;

@Component("BeforeThenAfter")
public class SpringAspectjBeforeThenAfterEmulator implements AspectEmulator {

    @LoggableBefore1
    @LoggableAfter1
    @Override
    public String doNothing1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBefore1
    @LoggableBefore2
    @LoggableBefore3
    @LoggableBefore4
    @LoggableBefore5
    @LoggableAfter1
    @LoggableAfter2
    @LoggableAfter3
    @LoggableAfter4
    @LoggableAfter5
    @Override
    public String doNothing12345(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBefore1(WorkType.BIG)
    @LoggableAfter1(WorkType.BIG)
    @Override
    public String doWorkBig1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBefore1(WorkType.BIG)
    @LoggableBefore2(WorkType.BIG)
    @LoggableBefore3(WorkType.BIG)
    @LoggableBefore4(WorkType.BIG)
    @LoggableBefore5(WorkType.BIG)
    @LoggableAfter1(WorkType.BIG)
    @LoggableAfter2(WorkType.BIG)
    @LoggableAfter3(WorkType.BIG)
    @LoggableAfter4(WorkType.BIG)
    @LoggableAfter5(WorkType.BIG)
    @Override
    public String doWorkBig12345(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBefore1(WorkType.LOGGER_OFF)
    @LoggableAfter1(WorkType.LOGGER_OFF)
    @Override
    public String doWorkLoggerOff1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBefore1(WorkType.LOGGER_OFF)
    @LoggableBefore2(WorkType.LOGGER_OFF)
    @LoggableBefore3(WorkType.LOGGER_OFF)
    @LoggableBefore4(WorkType.LOGGER_OFF)
    @LoggableBefore5(WorkType.LOGGER_OFF)
    @LoggableAfter1(WorkType.LOGGER_OFF)
    @LoggableAfter2(WorkType.LOGGER_OFF)
    @LoggableAfter3(WorkType.LOGGER_OFF)
    @LoggableAfter4(WorkType.LOGGER_OFF)
    @LoggableAfter5(WorkType.LOGGER_OFF)
    @Override
    public String doWorkLoggerOff12345(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBefore1(WorkType.MEDIUM)
    @LoggableAfter1(WorkType.MEDIUM)
    @Override
    public String doWorkMedium1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBefore1(WorkType.MEDIUM)
    @LoggableBefore2(WorkType.MEDIUM)
    @LoggableBefore3(WorkType.MEDIUM)
    @LoggableBefore4(WorkType.MEDIUM)
    @LoggableBefore5(WorkType.MEDIUM)
    @LoggableAfter1(WorkType.MEDIUM)
    @LoggableAfter2(WorkType.MEDIUM)
    @LoggableAfter3(WorkType.MEDIUM)
    @LoggableAfter4(WorkType.MEDIUM)
    @LoggableAfter5(WorkType.MEDIUM)
    @Override
    public String doWorkMedium12345(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBefore1(WorkType.SMALL)
    @LoggableAfter1(WorkType.SMALL)
    @Override
    public String doWorkSmall1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBefore1(WorkType.SMALL)
    @LoggableBefore2(WorkType.SMALL)
    @LoggableBefore3(WorkType.SMALL)
    @LoggableBefore4(WorkType.SMALL)
    @LoggableBefore5(WorkType.SMALL)
    @LoggableAfter1(WorkType.SMALL)
    @LoggableAfter2(WorkType.SMALL)
    @LoggableAfter3(WorkType.SMALL)
    @LoggableAfter4(WorkType.SMALL)
    @LoggableAfter5(WorkType.SMALL)
    @Override
    public String doWorkSmall12345(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }
}
