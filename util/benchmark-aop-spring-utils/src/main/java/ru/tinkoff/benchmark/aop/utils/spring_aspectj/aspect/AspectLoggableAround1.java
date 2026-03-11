package ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableAround1;

@Aspect
@Component
public class AspectLoggableAround1 {

    @Around(value = "@annotation(loggableAround1)", argNames = "joinPoint,loggableAround1")
    public Object doAround(ProceedingJoinPoint joinPoint, LoggableAround1 loggableAround1) throws Throwable {
        return AbstractSpringLoggableAspect.around(joinPoint, loggableAround1.value());
    }
}
