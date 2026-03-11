package ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.LoggableAfterReturning3;

@Aspect
@Component
public class AspectLoggableAfterReturning3 {

    @AfterReturning(value = "@annotation(loggableAfterReturning3)",
            argNames = "joinPoint,returning3,loggableAfterReturning3",
            returning = "returning3")
    public void doAfter(JoinPoint joinPoint, Object returning3, LoggableAfterReturning3 loggableAfterReturning3)
            throws Throwable {
        AbstractSpringLoggableAspect.afterReturning(joinPoint, returning3, loggableAfterReturning3.value());
    }
}
