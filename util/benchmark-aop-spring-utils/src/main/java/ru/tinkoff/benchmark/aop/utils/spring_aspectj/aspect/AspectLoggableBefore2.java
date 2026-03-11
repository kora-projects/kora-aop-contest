package ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.LoggableBefore2;

@Aspect
@Component
public class AspectLoggableBefore2 {

    @Before(value = "@annotation(loggableBefore2)", argNames = "joinPoint,loggableBefore2")
    public void doBefore(JoinPoint joinPoint, LoggableBefore2 loggableBefore2) throws Throwable {
        AbstractSpringLoggableAspect.before(joinPoint, loggableBefore2.value());
    }
}
