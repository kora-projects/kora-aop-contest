package ru.tinkoff.benchmark.aop.utils.pcw_spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring.Loggable2;

@Aspect
@Component
public class AspectLoggable2 {

    @Around(value = "@annotation(loggablePcw)", argNames = "joinPoint,loggablePcw")
    public Object doAround(ProceedingJoinPoint joinPoint, Loggable2 loggablePcw) throws Throwable {
        return AbstractSpringLoggableAspect.around(joinPoint, loggablePcw.value());
    }
}
