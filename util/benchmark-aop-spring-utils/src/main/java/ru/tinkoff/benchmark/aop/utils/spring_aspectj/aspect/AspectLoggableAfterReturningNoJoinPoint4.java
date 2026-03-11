package ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.LoggableAfterReturningNoJoinPoint4;

@Aspect
@Component
public class AspectLoggableAfterReturningNoJoinPoint4 {

    @AfterReturning(value = "@annotation(loggableAfterReturningNoJoinPoint4)",
            argNames = "returning4,loggableAfterReturningNoJoinPoint4",
            returning = "returning4")
    public void doAfter(Object returning4, LoggableAfterReturningNoJoinPoint4 loggableAfterReturningNoJoinPoint4)
            throws Throwable {
        AbstractSpringLoggableAspect.afterReturning(returning4, loggableAfterReturningNoJoinPoint4.value());
    }
}
