package ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.LoggableAfterReturningNoJoinPoint3;

@Aspect
@Component
public class AspectLoggableAfterReturningNoJoinPoint3 {

    @AfterReturning(value = "@annotation(loggableAfterReturningNoJoinPoint3)",
            argNames = "returning3,loggableAfterReturningNoJoinPoint3",
            returning = "returning3")
    public void doAfter(Object returning3, LoggableAfterReturningNoJoinPoint3 loggableAfterReturningNoJoinPoint3)
            throws Throwable {
        AbstractSpringLoggableAspect.afterReturning(returning3, loggableAfterReturningNoJoinPoint3.value());
    }
}
