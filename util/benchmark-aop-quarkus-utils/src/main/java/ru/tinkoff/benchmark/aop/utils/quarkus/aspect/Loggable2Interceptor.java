package ru.tinkoff.benchmark.aop.utils.quarkus.aspect;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import ru.tinkoff.benchmark.aop.utils.WorkType;
import ru.tinkoff.benchmark.aop.utils.quarkus.Loggable2;

@Loggable2
@Priority(10)
@Interceptor
public class Loggable2Interceptor extends AbstractLoggableInterceptor<Loggable2> {

    @Override
    protected WorkType getWorkType(InvocationContext context) {
        return context.getInterceptorBinding(Loggable2.class).value();
    }

    @AroundInvoke
    public Object invoke(InvocationContext context) throws Exception {
        return intercept(context);
    }
}
