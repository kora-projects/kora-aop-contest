package ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableAfterReturning5;

@Aspect
@Component
public class AspectLoggableAfterReturning5 {

    @AfterReturning(value = "@annotation(loggablePcwAfterReturning5)",
            argNames = "joinPoint,returning5,loggablePcwAfterReturning5",
            returning = "returning5")
    public void doAfter(JoinPoint joinPoint, Object returning5, LoggableAfterReturning5 loggablePcwAfterReturning5)
            throws Throwable {
        AbstractSpringLoggableAspect.afterReturning(joinPoint, returning5, loggablePcwAfterReturning5.value());
    }
}
