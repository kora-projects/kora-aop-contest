package ru.tinkoff.benchmark.aop.utils.micronaut.aspect;

import io.micronaut.aop.InterceptorBean;
import io.micronaut.core.annotation.Introspected;
import jakarta.inject.Singleton;
import ru.tinkoff.benchmark.aop.utils.micronaut.Loggable4;

@Introspected
@InterceptorBean(Loggable4.class)
@Singleton
public class Loggable4Interceptor extends AbstractLoggableInterceptor<Loggable4> {

    @Override
    protected Class<Loggable4> annotation() {
        return Loggable4.class;
    }
}
