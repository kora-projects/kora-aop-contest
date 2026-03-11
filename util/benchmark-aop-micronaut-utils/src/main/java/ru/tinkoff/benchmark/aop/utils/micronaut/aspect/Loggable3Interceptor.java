package ru.tinkoff.benchmark.aop.utils.micronaut.aspect;

import io.micronaut.aop.InterceptorBean;
import io.micronaut.core.annotation.Introspected;
import jakarta.inject.Singleton;
import ru.tinkoff.benchmark.aop.utils.micronaut.Loggable3;

@Introspected
@InterceptorBean(Loggable3.class)
@Singleton
public class Loggable3Interceptor extends AbstractLoggableInterceptor<Loggable3> {

    @Override
    protected Class<Loggable3> annotation() {
        return Loggable3.class;
    }
}
