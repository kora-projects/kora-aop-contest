package ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.LoggableBefore5;

@Aspect
@Component
public class AspectLoggableBefore5 {

    @Before(value = "@annotation(loggableBefore5)", argNames = "joinPoint,loggableBefore5")
    public void doBefore(JoinPoint joinPoint, LoggableBefore5 loggableBefore5) throws Throwable {
        AbstractSpringLoggableAspect.before(joinPoint, loggableBefore5.value());
    }
}
