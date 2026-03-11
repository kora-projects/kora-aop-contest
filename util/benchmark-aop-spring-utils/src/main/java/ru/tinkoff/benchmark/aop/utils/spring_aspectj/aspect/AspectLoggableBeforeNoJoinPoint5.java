package ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.LoggableBeforeNoJoinPoint5;

@Aspect
@Component
public class AspectLoggableBeforeNoJoinPoint5 {

    @Before(value = "@annotation(loggableBeforeNoJoinPoint5)", argNames = "loggableBeforeNoJoinPoint5")
    public void doBefore(LoggableBeforeNoJoinPoint5 loggableBeforeNoJoinPoint5) throws Throwable {
        AbstractSpringLoggableAspect.before(loggableBeforeNoJoinPoint5.value());
    }
}
