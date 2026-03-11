package ru.tinkoff.benchmark.aop.utils.aot.pcw_spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.aot.pcw_spring.Loggable3;

@Aspect
@Component
public class AspectAotPcwLoggable3 {

    @Around(value = "@annotation(loggableAotPcw)", argNames = "joinPoint,loggableAotPcw")
    public Object doAround(ProceedingJoinPoint joinPoint, Loggable3 loggableAotPcw) throws Throwable {
        return AbstractSpringLoggableAspect.around(joinPoint, loggableAotPcw.value());
    }
}
