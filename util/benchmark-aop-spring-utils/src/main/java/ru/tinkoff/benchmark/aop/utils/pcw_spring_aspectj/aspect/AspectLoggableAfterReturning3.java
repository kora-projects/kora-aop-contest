package ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableAfterReturning3;

@Aspect
@Component
public class AspectLoggableAfterReturning3 {

    @AfterReturning(value = "@annotation(loggablePcwAfterReturning3)",
            argNames = "joinPoint,returning3,loggablePcwAfterReturning3",
            returning = "returning3")
    public void doAfter(JoinPoint joinPoint, Object returning3, LoggableAfterReturning3 loggablePcwAfterReturning3)
            throws Throwable {
        AbstractSpringLoggableAspect.afterReturning(joinPoint, returning3, loggablePcwAfterReturning3.value());
    }
}
