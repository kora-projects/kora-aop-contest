package ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableAfterReturningNoJoinPoint5;

@Aspect
@Component
public class AspectLoggableAfterReturningNoJoinPoint5 {

    @AfterReturning(value = "@annotation(loggablePcwAfterReturningNoJoinPoint5)",
            argNames = "returning5,loggablePcwAfterReturningNoJoinPoint5",
            returning = "returning5")
    public void doAfter(Object returning5, LoggableAfterReturningNoJoinPoint5 loggablePcwAfterReturningNoJoinPoint5)
            throws Throwable {
        AbstractSpringLoggableAspect.afterReturning(returning5, loggablePcwAfterReturningNoJoinPoint5.value());
    }
}
