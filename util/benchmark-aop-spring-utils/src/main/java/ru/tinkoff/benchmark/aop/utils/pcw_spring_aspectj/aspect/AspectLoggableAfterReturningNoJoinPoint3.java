package ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableAfterReturningNoJoinPoint3;

@Aspect
@Component
public class AspectLoggableAfterReturningNoJoinPoint3 {

    @AfterReturning(value = "@annotation(loggablePcwAfterReturningNoJoinPoint3)",
            argNames = "returning3,loggablePcwAfterReturningNoJoinPoint3",
            returning = "returning3")
    public void doAfter(Object returning3, LoggableAfterReturningNoJoinPoint3 loggablePcwAfterReturningNoJoinPoint3)
            throws Throwable {
        AbstractSpringLoggableAspect.afterReturning(returning3, loggablePcwAfterReturningNoJoinPoint3.value());
    }
}
