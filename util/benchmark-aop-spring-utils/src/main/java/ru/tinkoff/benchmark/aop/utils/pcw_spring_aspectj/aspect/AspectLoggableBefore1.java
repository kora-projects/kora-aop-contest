package ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableBefore1;

@Aspect
@Component
public class AspectLoggableBefore1 {

    @Before(value = "@annotation(loggablePcwBefore1)", argNames = "joinPoint,loggablePcwBefore1")
    public void doBefore(JoinPoint joinPoint, LoggableBefore1 loggablePcwBefore1) throws Throwable {
        AbstractSpringLoggableAspect.before(joinPoint, loggablePcwBefore1.value());
    }
}
