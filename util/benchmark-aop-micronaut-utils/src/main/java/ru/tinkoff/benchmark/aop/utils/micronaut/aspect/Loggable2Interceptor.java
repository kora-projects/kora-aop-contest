package ru.tinkoff.benchmark.aop.utils.micronaut.aspect;

import io.micronaut.aop.InterceptorBean;
import io.micronaut.core.annotation.Introspected;
import jakarta.inject.Singleton;
import ru.tinkoff.benchmark.aop.utils.micronaut.Loggable2;

@Introspected
@InterceptorBean(Loggable2.class)
@Singleton
public class Loggable2Interceptor extends AbstractLoggableInterceptor<Loggable2> {

    @Override
    protected Class<Loggable2> annotation() {
        return Loggable2.class;
    }
}
