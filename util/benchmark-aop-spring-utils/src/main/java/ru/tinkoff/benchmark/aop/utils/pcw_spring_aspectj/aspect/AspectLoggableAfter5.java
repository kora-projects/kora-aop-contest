package ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableAfter5;

@Aspect
@Component
public class AspectLoggableAfter5 {

    @After(value = "@annotation(loggablePcwAfter5)", argNames = "joinPoint,loggablePcwAfter5")
    public void doAfter(JoinPoint joinPoint, LoggableAfter5 loggablePcwAfter5) throws Throwable {
        AbstractSpringLoggableAspect.after(joinPoint, loggablePcwAfter5.value());
    }
}
