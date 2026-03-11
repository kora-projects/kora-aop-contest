package ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.LoggableAfterReturningNoJoinPoint1;

@Aspect
@Component
public class AspectLoggableAfterReturningNoJoinPoint1 {

    @AfterReturning(value = "@annotation(loggableAfterReturningNoJoinPoint1)",
            argNames = "returning1,loggableAfterReturningNoJoinPoint1",
            returning = "returning1")
    public void doAfter(Object returning1, LoggableAfterReturningNoJoinPoint1 loggableAfterReturningNoJoinPoint1)
            throws Throwable {
        AbstractSpringLoggableAspect.afterReturning(returning1, loggableAfterReturningNoJoinPoint1.value());
    }
}
