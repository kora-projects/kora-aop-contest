package ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.LoggableBeforeNoJoinPoint4;

@Aspect
@Component
public class AspectLoggableBeforeNoJoinPoint4 {

    @Before(value = "@annotation(loggableBeforeNoJoinPoint4)", argNames = "loggableBeforeNoJoinPoint4")
    public void doBefore(LoggableBeforeNoJoinPoint4 loggableBeforeNoJoinPoint4) throws Throwable {
        AbstractSpringLoggableAspect.before(loggableBeforeNoJoinPoint4.value());
    }
}
