package ru.tinkoff.benchmark.aop.spring.ctw.emulator;

import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.AspectConsumer;
import ru.tinkoff.benchmark.aop.utils.AspectEmulator;
import ru.tinkoff.benchmark.aop.utils.AspectEmulatorWorker;
import ru.tinkoff.benchmark.aop.utils.WorkType;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.*;

@Component("BeforeThenAfterReturningNoJoinPoint")
public class SpringAspectjBeforeThenAfterReturningNoJoinPointEmulator_CTW implements AspectEmulator {

    @LoggableBeforeNoJoinPoint1
    @LoggableAfterReturningNoJoinPoint1
    @Override
    public String doNothing1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBeforeNoJoinPoint1
    @LoggableBeforeNoJoinPoint2
    @LoggableBeforeNoJoinPoint3
    @LoggableBeforeNoJoinPoint4
    @LoggableBeforeNoJoinPoint5
    @LoggableAfterReturningNoJoinPoint1
    @LoggableAfterReturningNoJoinPoint2
    @LoggableAfterReturningNoJoinPoint3
    @LoggableAfterReturningNoJoinPoint4
    @LoggableAfterReturningNoJoinPoint5
    @Override
    public String doNothing12345(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBeforeNoJoinPoint1(WorkType.BIG)
    @LoggableAfterReturningNoJoinPoint1(WorkType.BIG)
    @Override
    public String doWorkBig1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBeforeNoJoinPoint1(WorkType.BIG)
    @LoggableBeforeNoJoinPoint2(WorkType.BIG)
    @LoggableBeforeNoJoinPoint3(WorkType.BIG)
    @LoggableBeforeNoJoinPoint4(WorkType.BIG)
    @LoggableBeforeNoJoinPoint5(WorkType.BIG)
    @LoggableAfterReturningNoJoinPoint1(WorkType.BIG)
    @LoggableAfterReturningNoJoinPoint2(WorkType.BIG)
    @LoggableAfterReturningNoJoinPoint3(WorkType.BIG)
    @LoggableAfterReturningNoJoinPoint4(WorkType.BIG)
    @LoggableAfterReturningNoJoinPoint5(WorkType.BIG)
    @Override
    public String doWorkBig12345(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBeforeNoJoinPoint1(WorkType.LOGGER_OFF)
    @LoggableAfterReturningNoJoinPoint1(WorkType.LOGGER_OFF)
    @Override
    public String doWorkLoggerOff1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBeforeNoJoinPoint1(WorkType.LOGGER_OFF)
    @LoggableBeforeNoJoinPoint2(WorkType.LOGGER_OFF)
    @LoggableBeforeNoJoinPoint3(WorkType.LOGGER_OFF)
    @LoggableBeforeNoJoinPoint4(WorkType.LOGGER_OFF)
    @LoggableBeforeNoJoinPoint5(WorkType.LOGGER_OFF)
    @LoggableAfterReturningNoJoinPoint1(WorkType.LOGGER_OFF)
    @LoggableAfterReturningNoJoinPoint2(WorkType.LOGGER_OFF)
    @LoggableAfterReturningNoJoinPoint3(WorkType.LOGGER_OFF)
    @LoggableAfterReturningNoJoinPoint4(WorkType.LOGGER_OFF)
    @LoggableAfterReturningNoJoinPoint5(WorkType.LOGGER_OFF)
    @Override
    public String doWorkLoggerOff12345(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBeforeNoJoinPoint1(WorkType.MEDIUM)
    @LoggableAfterReturningNoJoinPoint1(WorkType.MEDIUM)
    @Override
    public String doWorkMedium1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBeforeNoJoinPoint1(WorkType.MEDIUM)
    @LoggableBeforeNoJoinPoint2(WorkType.MEDIUM)
    @LoggableBeforeNoJoinPoint3(WorkType.MEDIUM)
    @LoggableBeforeNoJoinPoint4(WorkType.MEDIUM)
    @LoggableBeforeNoJoinPoint5(WorkType.MEDIUM)
    @LoggableAfterReturningNoJoinPoint1(WorkType.MEDIUM)
    @LoggableAfterReturningNoJoinPoint2(WorkType.MEDIUM)
    @LoggableAfterReturningNoJoinPoint3(WorkType.MEDIUM)
    @LoggableAfterReturningNoJoinPoint4(WorkType.MEDIUM)
    @LoggableAfterReturningNoJoinPoint5(WorkType.MEDIUM)
    @Override
    public String doWorkMedium12345(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBeforeNoJoinPoint1(WorkType.SMALL)
    @LoggableAfterReturningNoJoinPoint1(WorkType.SMALL)
    @Override
    public String doWorkSmall1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBeforeNoJoinPoint1(WorkType.SMALL)
    @LoggableBeforeNoJoinPoint2(WorkType.SMALL)
    @LoggableBeforeNoJoinPoint3(WorkType.SMALL)
    @LoggableBeforeNoJoinPoint4(WorkType.SMALL)
    @LoggableBeforeNoJoinPoint5(WorkType.SMALL)
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
