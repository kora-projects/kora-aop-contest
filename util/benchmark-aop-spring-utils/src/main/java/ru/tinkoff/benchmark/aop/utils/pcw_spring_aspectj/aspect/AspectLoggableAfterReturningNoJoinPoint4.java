package ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableAfterReturningNoJoinPoint4;

@Aspect
@Component
public class AspectLoggableAfterReturningNoJoinPoint4 {

    @AfterReturning(value = "@annotation(loggablePcwAfterReturningNoJoinPoint4)",
            argNames = "returning4,loggablePcwAfterReturningNoJoinPoint4",
            returning = "returning4")
    public void doAfter(Object returning4, LoggableAfterReturningNoJoinPoint4 loggablePcwAfterReturningNoJoinPoint4)
            throws Throwable {
        AbstractSpringLoggableAspect.afterReturning(returning4, loggablePcwAfterReturningNoJoinPoint4.value());
    }
}
