package ru.tinkoff.benchmark.aop.spring.ctw.emulator;

import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.AspectConsumer;
import ru.tinkoff.benchmark.aop.utils.AspectEmulator;
import ru.tinkoff.benchmark.aop.utils.AspectEmulatorWorker;
import ru.tinkoff.benchmark.aop.utils.WorkType;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.*;

@Component("AfterNoJoinPoint")
public class SpringAspectjAfterNoJoinPointEmulator_CTW implements AspectEmulator {

    @LoggableAfterNoJoinPoint1
    @Override
    public String doNothing1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableAfterNoJoinPoint1
    @LoggableAfterNoJoinPoint2
    @LoggableAfterNoJoinPoint3
    @LoggableAfterNoJoinPoint4
    @LoggableAfterNoJoinPoint5
    @Override
    public String doNothing12345(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableAfterNoJoinPoint1(WorkType.BIG)
    @Override
    public String doWorkBig1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableAfterNoJoinPoint1(WorkType.BIG)
    @LoggableAfterNoJoinPoint2(WorkType.BIG)
    @LoggableAfterNoJoinPoint3(WorkType.BIG)
    @LoggableAfterNoJoinPoint4(WorkType.BIG)
    @LoggableAfterNoJoinPoint5(WorkType.BIG)
    @Override
    public String doWorkBig12345(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableAfterNoJoinPoint1(WorkType.LOGGER_OFF)
    @Override
    public String doWorkLoggerOff1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableAfterNoJoinPoint1(WorkType.LOGGER_OFF)
    @LoggableAfterNoJoinPoint2(WorkType.LOGGER_OFF)
    @LoggableAfterNoJoinPoint3(WorkType.LOGGER_OFF)
    @LoggableAfterNoJoinPoint4(WorkType.LOGGER_OFF)
    @LoggableAfterNoJoinPoint5(WorkType.LOGGER_OFF)
    @Override
    public String doWorkLoggerOff12345(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableAfterNoJoinPoint1(WorkType.MEDIUM)
    @Override
    public String doWorkMedium1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableAfterNoJoinPoint1(WorkType.MEDIUM)
    @LoggableAfterNoJoinPoint2(WorkType.MEDIUM)
    @LoggableAfterNoJoinPoint3(WorkType.MEDIUM)
    @LoggableAfterNoJoinPoint4(WorkType.MEDIUM)
    @LoggableAfterNoJoinPoint5(WorkType.MEDIUM)
    @Override
    public String doWorkMedium12345(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableAfterNoJoinPoint1(WorkType.SMALL)
    @Override
    public String doWorkSmall1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableAfterNoJoinPoint1(WorkType.SMALL)
    @LoggableAfterNoJoinPoint2(WorkType.SMALL)
    @LoggableAfterNoJoinPoint3(WorkType.SMALL)
    @LoggableAfterNoJoinPoint4(WorkType.SMALL)
    @LoggableAfterNoJoinPoint5(WorkType.SMALL)
    @Override
    public String doWorkSmall12345(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }
}
