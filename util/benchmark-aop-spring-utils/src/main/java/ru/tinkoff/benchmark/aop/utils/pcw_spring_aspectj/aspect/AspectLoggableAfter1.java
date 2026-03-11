package ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableAfter1;

@Aspect
@Component
public class AspectLoggableAfter1 {

    @After(value = "@annotation(loggablePcwAfter1)", argNames = "joinPoint,loggablePcwAfter1")
    public void doAfter(JoinPoint joinPoint, LoggableAfter1 loggablePcwAfter1) throws Throwable {
        AbstractSpringLoggableAspect.after(joinPoint, loggablePcwAfter1.value());
    }
}
