package ru.tinkoff.benchmark.aop.spring.emulator;

import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.AspectConsumer;
import ru.tinkoff.benchmark.aop.utils.AspectEmulator;
import ru.tinkoff.benchmark.aop.utils.AspectEmulatorWorker;
import ru.tinkoff.benchmark.aop.utils.WorkType;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.*;

@Component("BeforeAfterReturningPointcut")
public class SpringAspectjBeforeAfterReturningPointcutEmulator implements AspectEmulator {

    @LoggableBeforeAfterReturningPointcut1
    @Override
    public String doNothing1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBeforeAfterReturningPointcut1
    @LoggableBeforeAfterReturningPointcut2
    @LoggableBeforeAfterReturningPointcut3
    @LoggableBeforeAfterReturningPointcut4
    @LoggableBeforeAfterReturningPointcut5
    @Override
    public String doNothing12345(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBeforeAfterReturningPointcut1(WorkType.BIG)
    @Override
    public String doWorkBig1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBeforeAfterReturningPointcut1(WorkType.BIG)
    @LoggableBeforeAfterReturningPointcut2(WorkType.BIG)
    @LoggableBeforeAfterReturningPointcut3(WorkType.BIG)
    @LoggableBeforeAfterReturningPointcut4(WorkType.BIG)
    @LoggableBeforeAfterReturningPointcut5(WorkType.BIG)
    @Override
    public String doWorkBig12345(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBeforeAfterReturningPointcut1(WorkType.LOGGER_OFF)
    @Override
    public String doWorkLoggerOff1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBeforeAfterReturningPointcut1(WorkType.LOGGER_OFF)
    @LoggableBeforeAfterReturningPointcut2(WorkType.LOGGER_OFF)
    @LoggableBeforeAfterReturningPointcut3(WorkType.LOGGER_OFF)
    @LoggableBeforeAfterReturningPointcut4(WorkType.LOGGER_OFF)
    @LoggableBeforeAfterReturningPointcut5(WorkType.LOGGER_OFF)
    @Override
    public String doWorkLoggerOff12345(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBeforeAfterReturningPointcut1(WorkType.MEDIUM)
    @Override
    public String doWorkMedium1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBeforeAfterReturningPointcut1(WorkType.MEDIUM)
    @LoggableBeforeAfterReturningPointcut2(WorkType.MEDIUM)
    @LoggableBeforeAfterReturningPointcut3(WorkType.MEDIUM)
    @LoggableBeforeAfterReturningPointcut4(WorkType.MEDIUM)
    @LoggableBeforeAfterReturningPointcut5(WorkType.MEDIUM)
    @Override
    public String doWorkMedium12345(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBeforeAfterReturningPointcut1(WorkType.SMALL)
    @Override
    public String doWorkSmall1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBeforeAfterReturningPointcut1(WorkType.SMALL)
    @LoggableBeforeAfterReturningPointcut2(WorkType.SMALL)
    @LoggableBeforeAfterReturningPointcut3(WorkType.SMALL)
    @LoggableBeforeAfterReturningPointcut4(WorkType.SMALL)
    @LoggableBeforeAfterReturningPointcut5(WorkType.SMALL)
    @Override
    public String doWorkSmall12345(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }
}
