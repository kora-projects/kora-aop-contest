package ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.LoggableAfter5;

@Aspect
@Component
public class AspectLoggableAfter5 {

    @After(value = "@annotation(loggableAfter5)", argNames = "joinPoint,loggableAfter5")
    public void doAfter(JoinPoint joinPoint, LoggableAfter5 loggableAfter5) throws Throwable {
        AbstractSpringLoggableAspect.after(joinPoint, loggableAfter5.value());
    }
}
