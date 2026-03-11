package ru.tinkoff.benchmark.aop.spring.emulator;

import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.AspectConsumer;
import ru.tinkoff.benchmark.aop.utils.AspectEmulator;
import ru.tinkoff.benchmark.aop.utils.AspectEmulatorWorker;
import ru.tinkoff.benchmark.aop.utils.WorkType;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.*;

@Component("BeforeThenAfterNoJoinPoint")
public class SpringAspectjBeforeNoJoinPointThenAfterNoJoinPointEmulator implements AspectEmulator {

    @LoggableBeforeNoJoinPoint1
    @LoggableAfterNoJoinPoint1
    @Override
    public String doNothing1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBeforeNoJoinPoint1
    @LoggableBeforeNoJoinPoint2
    @LoggableBeforeNoJoinPoint3
    @LoggableBeforeNoJoinPoint4
    @LoggableBeforeNoJoinPoint5
    @LoggableAfterNoJoinPoint1
    @LoggableAfterNoJoinPoint2
    @LoggableAfterNoJoinPoint3
    @LoggableAfterNoJoinPoint4
    @LoggableAfterNoJoinPoint5
    @Override
    public String doNothing12345(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBeforeNoJoinPoint1(WorkType.BIG)
    @LoggableAfterNoJoinPoint1(WorkType.BIG)
    @Override
    public String doWorkBig1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBeforeNoJoinPoint1(WorkType.BIG)
    @LoggableBeforeNoJoinPoint2(WorkType.BIG)
    @LoggableBeforeNoJoinPoint3(WorkType.BIG)
    @LoggableBeforeNoJoinPoint4(WorkType.BIG)
    @LoggableBeforeNoJoinPoint5(WorkType.BIG)
    @LoggableAfterNoJoinPoint1(WorkType.BIG)
    @LoggableAfterNoJoinPoint2(WorkType.BIG)
    @LoggableAfterNoJoinPoint3(WorkType.BIG)
    @LoggableAfterNoJoinPoint4(WorkType.BIG)
    @LoggableAfterNoJoinPoint5(WorkType.BIG)
    @Override
    public String doWorkBig12345(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBeforeNoJoinPoint1(WorkType.LOGGER_OFF)
    @LoggableAfterNoJoinPoint1(WorkType.LOGGER_OFF)
    @Override
    public String doWorkLoggerOff1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBeforeNoJoinPoint1(WorkType.LOGGER_OFF)
    @LoggableBeforeNoJoinPoint2(WorkType.LOGGER_OFF)
    @LoggableBeforeNoJoinPoint3(WorkType.LOGGER_OFF)
    @LoggableBeforeNoJoinPoint4(WorkType.LOGGER_OFF)
    @LoggableBeforeNoJoinPoint5(WorkType.LOGGER_OFF)
    @LoggableAfterNoJoinPoint1(WorkType.LOGGER_OFF)
    @LoggableAfterNoJoinPoint2(WorkType.LOGGER_OFF)
    @LoggableAfterNoJoinPoint3(WorkType.LOGGER_OFF)
    @LoggableAfterNoJoinPoint4(WorkType.LOGGER_OFF)
    @LoggableAfterNoJoinPoint5(WorkType.LOGGER_OFF)
    @Override
    public String doWorkLoggerOff12345(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBeforeNoJoinPoint1(WorkType.MEDIUM)
    @LoggableAfterNoJoinPoint1(WorkType.MEDIUM)
    @Override
    public String doWorkMedium1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBeforeNoJoinPoint1(WorkType.MEDIUM)
    @LoggableBeforeNoJoinPoint2(WorkType.MEDIUM)
    @LoggableBeforeNoJoinPoint3(WorkType.MEDIUM)
    @LoggableBeforeNoJoinPoint4(WorkType.MEDIUM)
    @LoggableBeforeNoJoinPoint5(WorkType.MEDIUM)
    @LoggableAfterNoJoinPoint1(WorkType.MEDIUM)
    @LoggableAfterNoJoinPoint2(WorkType.MEDIUM)
    @LoggableAfterNoJoinPoint3(WorkType.MEDIUM)
    @LoggableAfterNoJoinPoint4(WorkType.MEDIUM)
    @LoggableAfterNoJoinPoint5(WorkType.MEDIUM)
    @Override
    public String doWorkMedium12345(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBeforeNoJoinPoint1(WorkType.SMALL)
    @LoggableAfterNoJoinPoint1(WorkType.SMALL)
    @Override
    public String doWorkSmall1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBeforeNoJoinPoint1(WorkType.SMALL)
    @LoggableBeforeNoJoinPoint2(WorkType.SMALL)
    @LoggableBeforeNoJoinPoint3(WorkType.SMALL)
    @LoggableBeforeNoJoinPoint4(WorkType.SMALL)
    @LoggableBeforeNoJoinPoint5(WorkType.SMALL)
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
