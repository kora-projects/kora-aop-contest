package ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.LoggableAfterReturning4;

@Aspect
@Component
public class AspectLoggableAfterReturning4 {

    @AfterReturning(value = "@annotation(loggableAfterReturning4)",
            argNames = "joinPoint,returning4,loggableAfterReturning4",
            returning = "returning4")
    public void doAfter(JoinPoint joinPoint, Object returning4, LoggableAfterReturning4 loggableAfterReturning4)
            throws Throwable {
        AbstractSpringLoggableAspect.afterReturning(joinPoint, returning4, loggableAfterReturning4.value());
    }
}
