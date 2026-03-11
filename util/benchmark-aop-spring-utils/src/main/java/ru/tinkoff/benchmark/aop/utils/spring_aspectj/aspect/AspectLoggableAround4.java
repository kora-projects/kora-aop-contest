package ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableAround4;

@Aspect
@Component
public class AspectLoggableAround4 {

    @Around(value = "@annotation(loggableAround4)", argNames = "joinPoint,loggableAround4")
    public Object doAround(ProceedingJoinPoint joinPoint, LoggableAround4 loggableAround4) throws Throwable {
        return AbstractSpringLoggableAspect.around(joinPoint, loggableAround4.value());
    }
}
