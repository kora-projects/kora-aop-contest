package ru.tinkoff.benchmark.aop.utils.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.spring.Loggable5;

@Aspect
@Component
public class AspectLoggable5 {

    @Around(value = "@annotation(loggable)", argNames = "joinPoint,loggable")
    public Object doAround(ProceedingJoinPoint joinPoint, Loggable5 loggable) throws Throwable {
        return AbstractSpringLoggableAspect.around(joinPoint, loggable.value());
    }
}
