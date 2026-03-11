package ru.tinkoff.benchmark.aop.utils.aot.pcw_spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.aot.pcw_spring.Loggable1;

@Aspect
@Component
public class AspectAotPcwLoggable1 {

    @Around(value = "@annotation(loggableAotPcw)", argNames = "joinPoint,loggableAotPcw")
    public Object doAround(ProceedingJoinPoint joinPoint, Loggable1 loggableAotPcw) throws Throwable {
        return AbstractSpringLoggableAspect.around(joinPoint, loggableAotPcw.value());
    }
}
