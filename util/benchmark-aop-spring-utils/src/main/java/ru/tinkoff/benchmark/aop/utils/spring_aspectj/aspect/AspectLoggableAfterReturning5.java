package ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.LoggableAfterReturning5;

@Aspect
@Component
public class AspectLoggableAfterReturning5 {

    @AfterReturning(value = "@annotation(loggableAfterReturning5)",
            argNames = "joinPoint,returning5,loggableAfterReturning5",
            returning = "returning5")
    public void doAfter(JoinPoint joinPoint, Object returning5, LoggableAfterReturning5 loggableAfterReturning5)
            throws Throwable {
        AbstractSpringLoggableAspect.afterReturning(joinPoint, returning5, loggableAfterReturning5.value());
    }
}
