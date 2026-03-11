package ru.tinkoff.benchmark.aop.utils.quarkus.aspect;

import jakarta.interceptor.InvocationContext;
import java.lang.annotation.Annotation;
import ru.tinkoff.benchmark.aop.utils.AspectConsumer;
import ru.tinkoff.benchmark.aop.utils.AspectEmulatorWorker;
import ru.tinkoff.benchmark.aop.utils.WorkType;

public abstract class AbstractLoggableInterceptor<T extends Annotation> {

    protected abstract WorkType getWorkType(InvocationContext context);

    public Object intercept(InvocationContext context) throws Exception {
        WorkType workType = getWorkType(context);

        var parameters = context.getParameters();
        var arg1 = (String) parameters[0];
        var consumer = (AspectConsumer) parameters[1];

        AspectEmulatorWorker.doWork(arg1, consumer, workType);
        var value = context.proceed();
        AspectEmulatorWorker.doWork(arg1, consumer, workType);

        return value;
    }
}
