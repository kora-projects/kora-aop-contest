package ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableAfterReturning4;

@Aspect
@Component
public class AspectLoggableAfterReturning4 {

    @AfterReturning(value = "@annotation(loggablePcwAfterReturning4)",
            argNames = "joinPoint,returning4,loggablePcwAfterReturning4",
            returning = "returning4")
    public void doAfter(JoinPoint joinPoint, Object returning4, LoggableAfterReturning4 loggablePcwAfterReturning4)
            throws Throwable {
        AbstractSpringLoggableAspect.afterReturning(joinPoint, returning4, loggablePcwAfterReturning4.value());
    }
}
