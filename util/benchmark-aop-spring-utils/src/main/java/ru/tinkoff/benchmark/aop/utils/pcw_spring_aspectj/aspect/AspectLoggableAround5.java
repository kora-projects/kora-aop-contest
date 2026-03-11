package ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableAround5;

@Aspect
@Component
public class AspectLoggableAround5 {

    @Around(value = "@annotation(loggablePcwAround5)", argNames = "joinPoint,loggablePcwAround5")
    public Object doAround(ProceedingJoinPoint joinPoint, LoggableAround5 loggablePcwAround5) throws Throwable {
        return AbstractSpringLoggableAspect.around(joinPoint, loggablePcwAround5.value());
    }
}
