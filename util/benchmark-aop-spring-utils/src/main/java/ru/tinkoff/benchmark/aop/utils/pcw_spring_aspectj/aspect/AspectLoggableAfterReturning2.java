package ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableAfterReturning2;

@Aspect
@Component
public class AspectLoggableAfterReturning2 {

    @AfterReturning(value = "@annotation(loggablePcwAfterReturning2)",
            argNames = "joinPoint,returning2,loggablePcwAfterReturning2",
            returning = "returning2")
    public void doAfter(JoinPoint joinPoint, Object returning2, LoggableAfterReturning2 loggablePcwAfterReturning2)
            throws Throwable {
        AbstractSpringLoggableAspect.afterReturning(joinPoint, returning2, loggablePcwAfterReturning2.value());
    }
}
