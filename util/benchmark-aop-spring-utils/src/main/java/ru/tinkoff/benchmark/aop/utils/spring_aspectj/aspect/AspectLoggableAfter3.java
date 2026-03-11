package ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.LoggableAfter3;

@Aspect
@Component
public class AspectLoggableAfter3 {

    @After(value = "@annotation(loggableAfter3)", argNames = "joinPoint,loggableAfter3")
    public void doAfter(JoinPoint joinPoint, LoggableAfter3 loggableAfter3) throws Throwable {
        AbstractSpringLoggableAspect.after(joinPoint, loggableAfter3.value());
    }
}
