package ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableBefore2;

@Aspect
@Component
public class AspectLoggableBefore2 {

    @Before(value = "@annotation(loggablePcwBefore2)", argNames = "joinPoint,loggablePcwBefore2")
    public void doBefore(JoinPoint joinPoint, LoggableBefore2 loggablePcwBefore2) throws Throwable {
        AbstractSpringLoggableAspect.before(joinPoint, loggablePcwBefore2.value());
    }
}
