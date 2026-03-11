package ru.tinkoff.benchmark.aop.utils.micronaut.aspect;

import io.micronaut.aop.InterceptorBean;
import io.micronaut.core.annotation.Introspected;
import jakarta.inject.Singleton;
import ru.tinkoff.benchmark.aop.utils.micronaut.Loggable5;

@Introspected
@InterceptorBean(Loggable5.class)
@Singleton
public class Loggable5Interceptor extends AbstractLoggableInterceptor<Loggable5> {

    @Override
    protected Class<Loggable5> annotation() {
        return Loggable5.class;
    }
}
