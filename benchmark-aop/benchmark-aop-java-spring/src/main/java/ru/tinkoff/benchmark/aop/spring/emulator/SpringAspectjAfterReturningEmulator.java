package ru.tinkoff.benchmark.aop.spring.emulator;

import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.AspectConsumer;
import ru.tinkoff.benchmark.aop.utils.AspectEmulator;
import ru.tinkoff.benchmark.aop.utils.AspectEmulatorWorker;
import ru.tinkoff.benchmark.aop.utils.WorkType;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.*;

@Component("AfterReturning")
public class SpringAspectjAfterReturningEmulator implements AspectEmulator {

    @LoggableAfterReturning1
    @Override
    public String doNothing1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableAfterReturning1
    @LoggableAfterReturning2
    @LoggableAfterReturning3
    @LoggableAfterReturning4
    @LoggableAfterReturning5
    @Override
    public String doNothing12345(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableAfterReturning1(WorkType.BIG)
    @Override
    public String doWorkBig1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableAfterReturning1(WorkType.BIG)
    @LoggableAfterReturning2(WorkType.BIG)
    @LoggableAfterReturning3(WorkType.BIG)
    @LoggableAfterReturning4(WorkType.BIG)
    @LoggableAfterReturning5(WorkType.BIG)
    @Override
    public String doWorkBig12345(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableAfterReturning1(WorkType.LOGGER_OFF)
    @Override
    public String doWorkLoggerOff1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableAfterReturning1(WorkType.LOGGER_OFF)
    @LoggableAfterReturning2(WorkType.LOGGER_OFF)
    @LoggableAfterReturning3(WorkType.LOGGER_OFF)
    @LoggableAfterReturning4(WorkType.LOGGER_OFF)
    @LoggableAfterReturning5(WorkType.LOGGER_OFF)
    @Override
    public String doWorkLoggerOff12345(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableAfterReturning1(WorkType.MEDIUM)
    @Override
    public String doWorkMedium1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableAfterReturning1(WorkType.MEDIUM)
    @LoggableAfterReturning2(WorkType.MEDIUM)
    @LoggableAfterReturning3(WorkType.MEDIUM)
    @LoggableAfterReturning4(WorkType.MEDIUM)
    @LoggableAfterReturning5(WorkType.MEDIUM)
    @Override
    public String doWorkMedium12345(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableAfterReturning1(WorkType.SMALL)
    @Override
    public String doWorkSmall1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableAfterReturning1(WorkType.SMALL)
    @LoggableAfterReturning2(WorkType.SMALL)
    @LoggableAfterReturning3(WorkType.SMALL)
    @LoggableAfterReturning4(WorkType.SMALL)
    @LoggableAfterReturning5(WorkType.SMALL)
    @Override
    public String doWorkSmall12345(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }
}
