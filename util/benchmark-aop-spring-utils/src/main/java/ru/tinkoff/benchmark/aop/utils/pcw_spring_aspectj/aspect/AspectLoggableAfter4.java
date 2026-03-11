package ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableAfter4;

@Aspect
@Component
public class AspectLoggableAfter4 {

    @After(value = "@annotation(loggablePcwAfter4)", argNames = "joinPoint,loggablePcwAfter4")
    public void doAfter(JoinPoint joinPoint, LoggableAfter4 loggablePcwAfter4) throws Throwable {
        AbstractSpringLoggableAspect.after(joinPoint, loggablePcwAfter4.value());
    }
}
