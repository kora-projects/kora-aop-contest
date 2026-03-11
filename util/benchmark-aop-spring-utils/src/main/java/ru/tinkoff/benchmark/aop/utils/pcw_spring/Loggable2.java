package ru.tinkoff.benchmark.aop.utils.pcw_spring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import ru.tinkoff.benchmark.aop.utils.WorkType;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Loggable2 {

    WorkType value() default WorkType.NOTHING;
}
