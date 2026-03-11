package ru.tinkoff.benchmark.aop.java.emulator;

import ru.tinkoff.benchmark.aop.utils.AspectConsumer;
import ru.tinkoff.benchmark.aop.utils.AspectEmulator;
import ru.tinkoff.benchmark.aop.utils.AspectEmulatorWorker;
import ru.tinkoff.benchmark.aop.utils.WorkType;

public class JavaAspectEmulator implements AspectEmulator {

    @Override
    public String doNothing1(String arg1, AspectConsumer consumer) {
        var workType = WorkType.NOTHING;
        AspectEmulatorWorker.doWork(arg1, consumer, workType);
        String value = AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
        AspectEmulatorWorker.doWork(arg1, consumer, workType);
        return value;
    }

    @Override
    public String doNothing12345(String arg1, AspectConsumer consumer) {
        var workType = WorkType.NOTHING;
        doSomethingBefore12345(arg1, consumer, workType);
        String value = AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
        doSomethingAfter12345(arg1, consumer, workType);
        return value;
    }

    @Override
    public String doWorkBig1(String arg1, AspectConsumer consumer) {
        var workType = WorkType.BIG;
        AspectEmulatorWorker.doWork(arg1, consumer, workType);
        String value = AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
        AspectEmulatorWorker.doWork(arg1, consumer, workType);
        return value;
    }

    @Override
    public String doWorkBig12345(String arg1, AspectConsumer consumer) {
        var workType = WorkType.BIG;
        doSomethingBefore12345(arg1, consumer, workType);
        String value = AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
        doSomethingAfter12345(arg1, consumer, workType);
        return value;
    }

    @Override
    public String doWorkLoggerOff1(String arg1, AspectConsumer consumer) {
        var workType = WorkType.LOGGER_OFF;
        AspectEmulatorWorker.doWork(arg1, consumer, workType);
        String value = AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
        AspectEmulatorWorker.doWork(arg1, consumer, workType);
        return value;
    }

    @Override
    public String doWorkLoggerOff12345(String arg1, AspectConsumer consumer) {
        var workType = WorkType.LOGGER_OFF;
        doSomethingBefore12345(arg1, consumer, workType);
        String value = AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
        doSomethingAfter12345(arg1, consumer, workType);
        return value;
    }

    @Override
    public String doWorkMedium1(String arg1, AspectConsumer consumer) {
        var workType = WorkType.MEDIUM;
        AspectEmulatorWorker.doWork(arg1, consumer, workType);
        String value = AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
        AspectEmulatorWorker.doWork(arg1, consumer, workType);
        return value;
    }

    @Override
    public String doWorkMedium12345(String arg1, AspectConsumer consumer) {
        var workType = WorkType.MEDIUM;
        doSomethingBefore12345(arg1, consumer, workType);
        String value = AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
        doSomethingAfter12345(arg1, consumer, workType);
        return value;
    }

    @Override
    public String doWorkSmall1(String arg1, AspectConsumer consumer) {
        var workType = WorkType.SMALL;
        AspectEmulatorWorker.doWork(arg1, consumer, workType);
        String value = AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
        AspectEmulatorWorker.doWork(arg1, consumer, workType);
        return value;
    }

    @Override
    public String doWorkSmall12345(String arg1, AspectConsumer consumer) {
        var workType = WorkType.SMALL;
        doSomethingBefore12345(arg1, consumer, workType);
        String value = AspectEmulatorWorker.doWork(arg1, consumer, WorkType.NOTHING);
        doSomethingAfter12345(arg1, consumer, workType);
        return value;
    }

    private void doSomethingAfter12345(String arg1, AspectConsumer consumer, WorkType workType) {
        AspectEmulatorWorker.doWork(arg1, consumer, workType);
        AspectEmulatorWorker.doWork(arg1, consumer, workType);
        AspectEmulatorWorker.doWork(arg1, consumer, workType);
        AspectEmulatorWorker.doWork(arg1, consumer, workType);
        AspectEmulatorWorker.doWork(arg1, consumer, workType);
    }

    private void doSomethingBefore12345(String arg1, AspectConsumer consumer, WorkType workType) {
        AspectEmulatorWorker.doWork(arg1, consumer, workType);
        AspectEmulatorWorker.doWork(arg1, consumer, workType);
        AspectEmulatorWorker.doWork(arg1, consumer, workType);
        AspectEmulatorWorker.doWork(arg1, consumer, workType);
        AspectEmulatorWorker.doWork(arg1, consumer, workType);
    }
}
