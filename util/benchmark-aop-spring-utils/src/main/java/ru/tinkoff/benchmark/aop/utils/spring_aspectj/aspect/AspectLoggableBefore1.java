package ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.LoggableBefore1;

@Aspect
@Component
public class AspectLoggableBefore1 {

    @Before(value = "@annotation(loggableBefore1)", argNames = "joinPoint,loggableBefore1")
    public void doBefore(JoinPoint joinPoint, LoggableBefore1 loggableBefore1) throws Throwable {
        AbstractSpringLoggableAspect.before(joinPoint, loggableBefore1.value());
    }
}
