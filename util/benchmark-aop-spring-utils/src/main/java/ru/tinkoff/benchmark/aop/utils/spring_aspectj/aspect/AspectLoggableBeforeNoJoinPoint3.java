package ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.LoggableBeforeNoJoinPoint3;

@Aspect
@Component
public class AspectLoggableBeforeNoJoinPoint3 {

    @Before(value = "@annotation(loggableBeforeNoJoinPoint3)", argNames = "loggableBeforeNoJoinPoint3")
    public void doBefore(LoggableBeforeNoJoinPoint3 loggableBeforeNoJoinPoint3) throws Throwable {
        AbstractSpringLoggableAspect.before(loggableBeforeNoJoinPoint3.value());
    }
}
