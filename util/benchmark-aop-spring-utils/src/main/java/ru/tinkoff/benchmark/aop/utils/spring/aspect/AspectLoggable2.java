package ru.tinkoff.benchmark.aop.utils.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.spring.Loggable2;

@Aspect
@Component
public class AspectLoggable2 {

    @Around(value = "@annotation(loggable)", argNames = "joinPoint,loggable")
    public Object doAround(ProceedingJoinPoint joinPoint, Loggable2 loggable) throws Throwable {
        return AbstractSpringLoggableAspect.around(joinPoint, loggable.value());
    }
}
