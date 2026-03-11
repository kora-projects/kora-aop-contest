package ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.LoggableAfterReturning2;

@Aspect
@Component
public class AspectLoggableAfterReturning2 {

    @AfterReturning(value = "@annotation(loggableAfterReturning2)",
            argNames = "joinPoint,returning2,loggableAfterReturning2",
            returning = "returning2")
    public void doAfter(JoinPoint joinPoint, Object returning2, LoggableAfterReturning2 loggableAfterReturning2)
            throws Throwable {
        AbstractSpringLoggableAspect.afterReturning(joinPoint, returning2, loggableAfterReturning2.value());
    }
}
