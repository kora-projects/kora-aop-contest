package ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.LoggableBefore3;

@Aspect
@Component
public class AspectLoggableBefore3 {

    @Before(value = "@annotation(loggableBefore3)", argNames = "joinPoint,loggableBefore3")
    public void doBefore(JoinPoint joinPoint, LoggableBefore3 loggableBefore3) throws Throwable {
        AbstractSpringLoggableAspect.before(joinPoint, loggableBefore3.value());
    }
}
