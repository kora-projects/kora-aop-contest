package ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableAfterReturningNoJoinPoint2;

@Aspect
@Component
public class AspectLoggableAfterReturningNoJoinPoint2 {

    @AfterReturning(value = "@annotation(loggablePcwAfterReturningNoJoinPoint2)",
            argNames = "returning2,loggablePcwAfterReturningNoJoinPoint2",
            returning = "returning2")
    public void doAfter(Object returning2, LoggableAfterReturningNoJoinPoint2 loggablePcwAfterReturningNoJoinPoint2)
            throws Throwable {
        AbstractSpringLoggableAspect.afterReturning(returning2, loggablePcwAfterReturningNoJoinPoint2.value());
    }
}
