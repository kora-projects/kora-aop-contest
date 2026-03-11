package ru.tinkoff.benchmark.aop.utils.micronaut;

import io.micronaut.aop.Around;
import io.micronaut.context.annotation.Type;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import ru.tinkoff.benchmark.aop.utils.WorkType;
import ru.tinkoff.benchmark.aop.utils.micronaut.aspect.Loggable5Interceptor;

@Around
@Type(Loggable5Interceptor.class)
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Loggable5 {

    WorkType value() default WorkType.NOTHING;
}
