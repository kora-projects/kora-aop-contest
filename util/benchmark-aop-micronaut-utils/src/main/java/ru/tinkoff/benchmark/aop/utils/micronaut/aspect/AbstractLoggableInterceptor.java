package ru.tinkoff.benchmark.aop.utils.micronaut.aspect;

import io.micronaut.aop.InterceptPhase;
import io.micronaut.aop.MethodInterceptor;
import io.micronaut.aop.MethodInvocationContext;
import java.lang.annotation.Annotation;
import ru.tinkoff.benchmark.aop.utils.AspectConsumer;
import ru.tinkoff.benchmark.aop.utils.AspectEmulatorWorker;
import ru.tinkoff.benchmark.aop.utils.WorkType;

public abstract class AbstractLoggableInterceptor<T extends Annotation> implements MethodInterceptor<Object, Object> {

    protected abstract Class<T> annotation();

    @Override
    public int getOrder() {
        return InterceptPhase.TRANSACTION.getPosition() - 5;
    }

    @Override
    public Object intercept(MethodInvocationContext<Object, Object> context) {
        WorkType workType = context.findAnnotation(annotation())
                .map(a -> a.enumValue("value", WorkType.class).orElse(WorkType.NOTHING))
                .orElse(WorkType.NOTHING);

        var parameters = context.getParameterValues();
        var arg1 = ((String) parameters[0]);
        var consumer = ((AspectConsumer) parameters[1]);

        AspectEmulatorWorker.doWork(arg1, consumer, workType);
        var value = context.proceed();
        AspectEmulatorWorker.doWork(arg1, consumer, workType);

        return value;
    }
}
