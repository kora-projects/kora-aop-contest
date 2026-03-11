package ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.openjdk.jmh.infra.Blackhole;
import ru.tinkoff.benchmark.aop.utils.AspectConsumer;
import ru.tinkoff.benchmark.aop.utils.AspectEmulatorWorker;
import ru.tinkoff.benchmark.aop.utils.WorkType;

public final class AbstractSpringLoggableAspect {

    private static final Blackhole BLACKHOLE = new Blackhole(
            "Today's password is swordfish. I understand instantiating Blackholes directly is dangerous.");
    private static final AspectConsumer NO_JOIN_POINT_CONSUMER = BLACKHOLE::consume;

    private AbstractSpringLoggableAspect() {}

    public static Object after(JoinPoint joinPoint, WorkType workType) {
        var args = joinPoint.getArgs();
        var arg1 = ((String) args[0]);
        var consumer = ((AspectConsumer) args[1]);

        AspectEmulatorWorker.doWork(arg1, consumer, workType);

        return arg1;
    }

    // THIS USAGE WILL RESULT IN INCONSISTENT BEHAVIOR TO IMPLS WITH JOIN_POINT CAUSE BLACKHOLE IS NOT
    // USED
    public static Object after(WorkType workType) {
        return AspectEmulatorWorker.doWork("1", NO_JOIN_POINT_CONSUMER, workType);
    }

    public static Object afterReturning(JoinPoint joinPoint, Object returning, WorkType workType) {
        var consumer = ((AspectConsumer) joinPoint.getArgs()[1]);

        String proceed = returning.toString();

        return AspectEmulatorWorker.doWork(proceed, consumer, workType);
    }

    // THIS USAGE WILL RESULT IN INCONSISTENT BEHAVIOR TO IMPLS WITH JOIN_POINT CAUSE BLACKHOLE IS NOT
    // USED
    public static Object afterReturning(Object returning, WorkType workType) {
        String proceed = returning.toString();

        return AspectEmulatorWorker.doWork(proceed, NO_JOIN_POINT_CONSUMER, workType);
    }

    public static Object around(ProceedingJoinPoint joinPoint, WorkType workType) throws Throwable {
        var args = joinPoint.getArgs();
        var arg1 = ((String) args[0]);
        var consumer = ((AspectConsumer) args[1]);

        AspectEmulatorWorker.doWork(arg1, consumer, workType);

        String proceed = joinPoint.proceed().toString();

        AspectEmulatorWorker.doWork(proceed, consumer, workType);

        return proceed;
    }

    public static Object before(JoinPoint joinPoint, WorkType workType) {
        var args = joinPoint.getArgs();
        var arg1 = ((String) args[0]);
        var consumer = ((AspectConsumer) args[1]);

        AspectEmulatorWorker.doWork(arg1, consumer, workType);

        return arg1;
    }

    // THIS USAGE WILL RESULT IN INCONSISTENT BEHAVIOR TO IMPLS WITH JOIN_POINT CAUSE BLACKHOLE IS NOT
    // USED
    public static Object before(WorkType workType) {
        return AspectEmulatorWorker.doWork("1", NO_JOIN_POINT_CONSUMER, workType);
    }
}
