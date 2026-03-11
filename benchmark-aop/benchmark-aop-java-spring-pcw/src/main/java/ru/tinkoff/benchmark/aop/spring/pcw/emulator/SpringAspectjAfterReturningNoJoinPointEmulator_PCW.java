package ru.tinkoff.benchmark.aop.spring.pcw.emulator;

import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.AspectConsumer;
import ru.tinkoff.benchmark.aop.utils.AspectEmulator;
import ru.tinkoff.benchmark.aop.utils.AspectEmulatorWorker;
import ru.tinkoff.benchmark.aop.utils.WorkType;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.*;

@Component("AfterReturningNoJoinPoint")
public class SpringAspectjAfterReturningNoJoinPointEmulator_PCW implements AspectEmulator {

    @LoggableAfterReturningNoJoinPoint1
    @Override
    public String doNothing1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableAfterReturningNoJoinPoint1
    @LoggableAfterReturningNoJoinPoint2
    @LoggableAfterReturningNoJoinPoint3
    @LoggableAfterReturningNoJoinPoint4
    @LoggableAfterReturningNoJoinPoint5
    @Override
    public String doNothing12345(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableAfterReturningNoJoinPoint1(WorkType.BIG)
    @Override
    public String doWorkBig1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableAfterReturningNoJoinPoint1(WorkType.BIG)
    @LoggableAfterReturningNoJoinPoint2(WorkType.BIG)
    @LoggableAfterReturningNoJoinPoint3(WorkType.BIG)
    @LoggableAfterReturningNoJoinPoint4(WorkType.BIG)
    @LoggableAfterReturningNoJoinPoint5(WorkType.BIG)
    @Override
    public String doWorkBig12345(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableAfterReturningNoJoinPoint1(WorkType.LOGGER_OFF)
    @Override
    public String doWorkLoggerOff1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableAfterReturningNoJoinPoint1(WorkType.LOGGER_OFF)
    @LoggableAfterReturningNoJoinPoint2(WorkType.LOGGER_OFF)
    @LoggableAfterReturningNoJoinPoint3(WorkType.LOGGER_OFF)
    @LoggableAfterReturningNoJoinPoint4(WorkType.LOGGER_OFF)
    @LoggableAfterReturningNoJoinPoint5(WorkType.LOGGER_OFF)
    @Override
    public String doWorkLoggerOff12345(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableAfterReturningNoJoinPoint1(WorkType.MEDIUM)
    @Override
    public String doWorkMedium1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableAfterReturningNoJoinPoint1(WorkType.MEDIUM)
    @LoggableAfterReturningNoJoinPoint2(WorkType.MEDIUM)
    @LoggableAfterReturningNoJoinPoint3(WorkType.MEDIUM)
    @LoggableAfterReturningNoJoinPoint4(WorkType.MEDIUM)
    @LoggableAfterReturningNoJoinPoint5(WorkType.MEDIUM)
    @Override
    public String doWorkMedium12345(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableAfterReturningNoJoinPoint1(WorkType.SMALL)
    @Override
    public String doWorkSmall1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableAfterReturningNoJoinPoint1(WorkType.SMALL)
    @LoggableAfterReturningNoJoinPoint2(WorkType.SMALL)
    @LoggableAfterReturningNoJoinPoint3(WorkType.SMALL)
    @LoggableAfterReturningNoJoinPoint4(WorkType.SMALL)
    @LoggableAfterReturningNoJoinPoint5(WorkType.SMALL)
    @Override
    public String doWorkSmall12345(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }
}
