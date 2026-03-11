package ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableAround1;

@Aspect
@Component
public class AspectLoggableAround1 {

    @Around(value = "@annotation(loggablePcwAround1)", argNames = "joinPoint,loggablePcwAround1")
    public Object doAround(ProceedingJoinPoint joinPoint, LoggableAround1 loggablePcwAround1) throws Throwable {
        return AbstractSpringLoggableAspect.around(joinPoint, loggablePcwAround1.value());
    }
}
