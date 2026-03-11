package ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.LoggableAfterReturningNoJoinPoint2;

@Aspect
@Component
public class AspectLoggableAfterReturningNoJoinPoint2 {

    @AfterReturning(value = "@annotation(loggableAfterReturningNoJoinPoint2)",
            argNames = "returning2,loggableAfterReturningNoJoinPoint2",
            returning = "returning2")
    public void doAfter(Object returning2, LoggableAfterReturningNoJoinPoint2 loggableAfterReturningNoJoinPoint2)
            throws Throwable {
        AbstractSpringLoggableAspect.afterReturning(returning2, loggableAfterReturningNoJoinPoint2.value());
    }
}
