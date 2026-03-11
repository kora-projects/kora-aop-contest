package ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableAfterReturning1;

@Aspect
@Component
public class AspectLoggableAfterReturning1 {

    @AfterReturning(value = "@annotation(loggablePcwAfterReturning1)",
            argNames = "joinPoint,returning1,loggablePcwAfterReturning1",
            returning = "returning1")
    public void doAfter(JoinPoint joinPoint, Object returning1, LoggableAfterReturning1 loggablePcwAfterReturning1)
            throws Throwable {
        AbstractSpringLoggableAspect.afterReturning(joinPoint, returning1, loggablePcwAfterReturning1.value());
    }
}
