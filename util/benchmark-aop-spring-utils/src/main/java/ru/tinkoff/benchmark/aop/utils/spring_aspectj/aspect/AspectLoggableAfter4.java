package ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.LoggableAfter4;

@Aspect
@Component
public class AspectLoggableAfter4 {

    @After(value = "@annotation(loggableAfter4)", argNames = "joinPoint,loggableAfter4")
    public void doAfter(JoinPoint joinPoint, LoggableAfter4 loggableAfter4) throws Throwable {
        AbstractSpringLoggableAspect.after(joinPoint, loggableAfter4.value());
    }
}
