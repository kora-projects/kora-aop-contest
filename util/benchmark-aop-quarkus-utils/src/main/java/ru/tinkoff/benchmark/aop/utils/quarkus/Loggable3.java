package ru.tinkoff.benchmark.aop.utils.quarkus;

import jakarta.enterprise.util.Nonbinding;
import jakarta.interceptor.InterceptorBinding;
import java.lang.annotation.*;
import ru.tinkoff.benchmark.aop.utils.WorkType;

@Inherited
@InterceptorBinding
@Target({ ElementType.METHOD, ElementType.TYPE, ElementType.CONSTRUCTOR })
@Retention(RetentionPolicy.RUNTIME)
public @interface Loggable3 {

    @Nonbinding
    WorkType value() default WorkType.NOTHING;
}
