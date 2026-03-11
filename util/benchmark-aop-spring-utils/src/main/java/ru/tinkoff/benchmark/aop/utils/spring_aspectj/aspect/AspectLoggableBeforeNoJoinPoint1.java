package ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.LoggableBeforeNoJoinPoint1;

@Aspect
@Component
public class AspectLoggableBeforeNoJoinPoint1 {

    @Before(value = "@annotation(loggableBeforeNoJoinPoint1)", argNames = "loggableBeforeNoJoinPoint1")
    public void doBefore(LoggableBeforeNoJoinPoint1 loggableBeforeNoJoinPoint1) throws Throwable {
        AbstractSpringLoggableAspect.before(loggableBeforeNoJoinPoint1.value());
    }
}
