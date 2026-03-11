package ru.tinkoff.benchmark.aop.utils.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import ru.tinkoff.benchmark.aop.utils.AspectConsumer;
import ru.tinkoff.benchmark.aop.utils.AspectEmulatorWorker;
import ru.tinkoff.benchmark.aop.utils.WorkType;

public final class AbstractSpringLoggableAspect {

    private AbstractSpringLoggableAspect() {}

    static Object around(ProceedingJoinPoint joinPoint, WorkType workType) throws Throwable {
        var args = joinPoint.getArgs();
        var arg1 = ((String) args[0]);
        var consumer = ((AspectConsumer) args[1]);

        AspectEmulatorWorker.doWork(arg1, consumer, workType);
        Object proceed = joinPoint.proceed();
        AspectEmulatorWorker.doWork(arg1, consumer, workType);

        return proceed;
    }
}
