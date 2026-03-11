package ru.tinkoff.benchmark.aop.utils.aot.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.aot.spring.Loggable2;

@Aspect
@Component
public class AspectAotLoggable2 {

    @Around(value = "@annotation(loggableAot)", argNames = "joinPoint,loggableAot")
    public Object doAround(ProceedingJoinPoint joinPoint, Loggable2 loggableAot) throws Throwable {
        return AbstractSpringLoggableAspect.around(joinPoint, loggableAot.value());
    }
}
