package ru.tinkoff.benchmark.aop.utils.aot.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.aot.spring.Loggable5;

@Aspect
@Component
public class AspectAotLoggable5 {

    @Around(value = "@annotation(loggableAot)", argNames = "joinPoint,loggableAot")
    public Object doAround(ProceedingJoinPoint joinPoint, Loggable5 loggableAot) throws Throwable {
        return AbstractSpringLoggableAspect.around(joinPoint, loggableAot.value());
    }
}
