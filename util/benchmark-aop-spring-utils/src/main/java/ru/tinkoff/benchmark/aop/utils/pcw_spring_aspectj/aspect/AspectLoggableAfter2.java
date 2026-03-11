package ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableAfter2;

@Aspect
@Component
public class AspectLoggableAfter2 {

    @After(value = "@annotation(loggablePcwAfter2)", argNames = "joinPoint,loggablePcwAfter2")
    public void doAfter(JoinPoint joinPoint, LoggableAfter2 loggablePcwAfter2) throws Throwable {
        AbstractSpringLoggableAspect.after(joinPoint, loggablePcwAfter2.value());
    }
}
