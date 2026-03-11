package ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.LoggableBefore4;

@Aspect
@Component
public class AspectLoggableBefore4 {

    @Before(value = "@annotation(loggableBefore4)", argNames = "joinPoint,loggableBefore4")
    public void doBefore(JoinPoint joinPoint, LoggableBefore4 loggableBefore4) throws Throwable {
        AbstractSpringLoggableAspect.before(joinPoint, loggableBefore4.value());
    }
}
