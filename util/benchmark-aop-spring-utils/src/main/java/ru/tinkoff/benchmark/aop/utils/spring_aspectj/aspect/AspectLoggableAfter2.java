package ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.LoggableAfter2;

@Aspect
@Component
public class AspectLoggableAfter2 {

    @After(value = "@annotation(loggableAfter2)", argNames = "joinPoint,loggableAfter2")
    public void doAfter(JoinPoint joinPoint, LoggableAfter2 loggableAfter2) throws Throwable {
        AbstractSpringLoggableAspect.after(joinPoint, loggableAfter2.value());
    }
}
