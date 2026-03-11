package ru.tinkoff.benchmark.aop.utils.micronaut.aspect;

import io.micronaut.aop.InterceptorBean;
import io.micronaut.core.annotation.Introspected;
import jakarta.inject.Singleton;
import ru.tinkoff.benchmark.aop.utils.micronaut.Loggable1;

@Introspected
@InterceptorBean(Loggable1.class)
@Singleton
public class Loggable1Interceptor extends AbstractLoggableInterceptor<Loggable1> {

    @Override
    protected Class<Loggable1> annotation() {
        return Loggable1.class;
    }
}
