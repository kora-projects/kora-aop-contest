package ru.tinkoff.benchmark.aop.utils.quarkus.aspect;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import ru.tinkoff.benchmark.aop.utils.WorkType;
import ru.tinkoff.benchmark.aop.utils.quarkus.Loggable3;

@Loggable3
@Priority(10)
@Interceptor
public class Loggable3Interceptor extends AbstractLoggableInterceptor<Loggable3> {

    @Override
    protected WorkType getWorkType(InvocationContext context) {
        return context.getInterceptorBinding(Loggable3.class).value();
    }

    @AroundInvoke
    public Object invoke(InvocationContext context) throws Exception {
        return intercept(context);
    }
}
