package ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableBefore3;

@Aspect
@Component
public class AspectLoggableBefore3 {

    @Before(value = "@annotation(loggablePcwBefore3)", argNames = "joinPoint,loggablePcwBefore3")
    public void doBefore(JoinPoint joinPoint, LoggableBefore3 loggablePcwBefore3) throws Throwable {
        AbstractSpringLoggableAspect.before(joinPoint, loggablePcwBefore3.value());
    }
}
