package ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableAround2;

@Aspect
@Component
public class AspectLoggableAround2 {

    @Around(value = "@annotation(loggableAround2)", argNames = "joinPoint,loggableAround2")
    public Object doAround(ProceedingJoinPoint joinPoint, LoggableAround2 loggableAround2) throws Throwable {
        return AbstractSpringLoggableAspect.around(joinPoint, loggableAround2.value());
    }
}
