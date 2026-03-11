package ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.LoggableAfter1;

@Aspect
@Component
public class AspectLoggableAfter1 {

    @After(value = "@annotation(loggableAfter1)", argNames = "joinPoint,loggableAfter1")
    public void doAfter(JoinPoint joinPoint, LoggableAfter1 loggableAfter1) throws Throwable {
        AbstractSpringLoggableAspect.after(joinPoint, loggableAfter1.value());
    }
}
