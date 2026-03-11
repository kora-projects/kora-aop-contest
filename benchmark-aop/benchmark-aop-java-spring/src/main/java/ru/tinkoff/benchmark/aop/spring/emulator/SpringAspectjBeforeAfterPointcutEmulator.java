package ru.tinkoff.benchmark.aop.spring.emulator;

import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.AspectConsumer;
import ru.tinkoff.benchmark.aop.utils.AspectEmulator;
import ru.tinkoff.benchmark.aop.utils.AspectEmulatorWorker;
import ru.tinkoff.benchmark.aop.utils.WorkType;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.*;

@Component("BeforeAfterPointcut")
public class SpringAspectjBeforeAfterPointcutEmulator implements AspectEmulator {

    @LoggableBeforeAfterPointcut1
    @Override
    public String doNothing1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBeforeAfterPointcut1
    @LoggableBeforeAfterPointcut2
    @LoggableBeforeAfterPointcut3
    @LoggableBeforeAfterPointcut4
    @LoggableBeforeAfterPointcut5
    @Override
    public String doNothing12345(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBeforeAfterPointcut1(WorkType.BIG)
    @Override
    public String doWorkBig1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBeforeAfterPointcut1(WorkType.BIG)
    @LoggableBeforeAfterPointcut2(WorkType.BIG)
    @LoggableBeforeAfterPointcut3(WorkType.BIG)
    @LoggableBeforeAfterPointcut4(WorkType.BIG)
    @LoggableBeforeAfterPointcut5(WorkType.BIG)
    @Override
    public String doWorkBig12345(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBeforeAfterPointcut1(WorkType.LOGGER_OFF)
    @Override
    public String doWorkLoggerOff1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBeforeAfterPointcut1(WorkType.LOGGER_OFF)
    @LoggableBeforeAfterPointcut2(WorkType.LOGGER_OFF)
    @LoggableBeforeAfterPointcut3(WorkType.LOGGER_OFF)
    @LoggableBeforeAfterPointcut4(WorkType.LOGGER_OFF)
    @LoggableBeforeAfterPointcut5(WorkType.LOGGER_OFF)
    @Override
    public String doWorkLoggerOff12345(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBeforeAfterPointcut1(WorkType.MEDIUM)
    @Override
    public String doWorkMedium1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBeforeAfterPointcut1(WorkType.MEDIUM)
    @LoggableBeforeAfterPointcut2(WorkType.MEDIUM)
    @LoggableBeforeAfterPointcut3(WorkType.MEDIUM)
    @LoggableBeforeAfterPointcut4(WorkType.MEDIUM)
    @LoggableBeforeAfterPointcut5(WorkType.MEDIUM)
    @Override
    public String doWorkMedium12345(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBeforeAfterPointcut1(WorkType.SMALL)
    @Override
    public String doWorkSmall1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @LoggableBeforeAfterPointcut1(WorkType.SMALL)
    @LoggableBeforeAfterPointcut2(WorkType.SMALL)
    @LoggableBeforeAfterPointcut3(WorkType.SMALL)
    @LoggableBeforeAfterPointcut4(WorkType.SMALL)
    @LoggableBeforeAfterPointcut5(WorkType.SMALL)
    @Override
    public String doWorkSmall12345(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }
}
