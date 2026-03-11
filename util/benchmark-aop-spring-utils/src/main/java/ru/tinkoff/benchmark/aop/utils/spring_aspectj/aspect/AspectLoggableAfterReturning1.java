package ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.LoggableAfterReturning1;

@Aspect
@Component
public class AspectLoggableAfterReturning1 {

    @AfterReturning(value = "@annotation(loggableAfterReturning1)",
            argNames = "joinPoint,returning1,loggableAfterReturning1",
            returning = "returning1")
    public void doAfter(JoinPoint joinPoint, Object returning1, LoggableAfterReturning1 loggableAfterReturning1)
            throws Throwable {
        AbstractSpringLoggableAspect.afterReturning(joinPoint, returning1, loggableAfterReturning1.value());
    }
}
