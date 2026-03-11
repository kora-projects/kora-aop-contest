package ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableBefore4;

@Aspect
@Component
public class AspectLoggableBefore4 {

    @Before(value = "@annotation(loggablePcwBefore4)", argNames = "joinPoint,loggablePcwBefore4")
    public void doBefore(JoinPoint joinPoint, LoggableBefore4 loggablePcwBefore4) throws Throwable {
        AbstractSpringLoggableAspect.before(joinPoint, loggablePcwBefore4.value());
    }
}
