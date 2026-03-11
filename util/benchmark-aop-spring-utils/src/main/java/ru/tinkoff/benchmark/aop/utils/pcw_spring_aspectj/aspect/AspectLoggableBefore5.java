package ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableBefore5;

@Aspect
@Component
public class AspectLoggableBefore5 {

    @Before(value = "@annotation(loggablePcwBefore5)", argNames = "joinPoint,loggablePcwBefore5")
    public void doBefore(JoinPoint joinPoint, LoggableBefore5 loggablePcwBefore5) throws Throwable {
        AbstractSpringLoggableAspect.before(joinPoint, loggablePcwBefore5.value());
    }
}
