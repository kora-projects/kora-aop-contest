package ru.tinkoff.benchmark.aop.spring.ltw.emulator;

import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.AspectConsumer;
import ru.tinkoff.benchmark.aop.utils.AspectEmulator;
import ru.tinkoff.benchmark.aop.utils.AspectEmulatorWorker;
import ru.tinkoff.benchmark.aop.utils.WorkType;
import ru.tinkoff.benchmark.aop.utils.spring.*;

@Component
public class SpringAspectEmulator_LTW implements AspectEmulator {

    @Loggable1
    @Override
    public String doNothing1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @Loggable1
    @Loggable2
    @Loggable3
    @Loggable4
    @Loggable5
    @Override
    public String doNothing12345(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @Loggable1(WorkType.BIG)
    @Override
    public String doWorkBig1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @Loggable1(WorkType.BIG)
    @Loggable2(WorkType.BIG)
    @Loggable3(WorkType.BIG)
    @Loggable4(WorkType.BIG)
    @Loggable5(WorkType.BIG)
    @Override
    public String doWorkBig12345(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @Loggable1(WorkType.LOGGER_OFF)
    @Override
    public String doWorkLoggerOff1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @Loggable1(WorkType.LOGGER_OFF)
    @Loggable2(WorkType.LOGGER_OFF)
    @Loggable3(WorkType.LOGGER_OFF)
    @Loggable4(WorkType.LOGGER_OFF)
    @Loggable5(WorkType.LOGGER_OFF)
    @Override
    public String doWorkLoggerOff12345(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @Loggable1(WorkType.MEDIUM)
    @Override
    public String doWorkMedium1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @Loggable1(WorkType.MEDIUM)
    @Loggable2(WorkType.MEDIUM)
    @Loggable3(WorkType.MEDIUM)
    @Loggable4(WorkType.MEDIUM)
    @Loggable5(WorkType.MEDIUM)
    @Override
    public String doWorkMedium12345(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @Loggable1(WorkType.SMALL)
    @Override
    public String doWorkSmall1(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }

    @Loggable1(WorkType.SMALL)
    @Loggable2(WorkType.SMALL)
    @Loggable3(WorkType.SMALL)
    @Loggable4(WorkType.SMALL)
    @Loggable5(WorkType.SMALL)
    @Override
    public String doWorkSmall12345(String arg1, AspectConsumer consumer) {
        return AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
    }
}
