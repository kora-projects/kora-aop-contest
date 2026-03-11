package ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableAfter3;

@Aspect
@Component
public class AspectLoggableAfter3 {

    @After(value = "@annotation(loggablePcwAfter3)", argNames = "joinPoint,loggablePcwAfter3")
    public void doAfter(JoinPoint joinPoint, LoggableAfter3 loggablePcwAfter3) throws Throwable {
        AbstractSpringLoggableAspect.after(joinPoint, loggablePcwAfter3.value());
    }
}
