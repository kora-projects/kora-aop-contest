package ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableAround3;

@Aspect
@Component
public class AspectLoggableAround3 {

    @Around(value = "@annotation(loggableAround3)", argNames = "joinPoint,loggableAround3")
    public Object doAround(ProceedingJoinPoint joinPoint, LoggableAround3 loggableAround3) throws Throwable {
        return AbstractSpringLoggableAspect.around(joinPoint, loggableAround3.value());
    }
}
