package ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.LoggableBeforeNoJoinPoint2;

@Aspect
@Component
public class AspectLoggableBeforeNoJoinPoint2 {

    @Before(value = "@annotation(loggableBeforeNoJoinPoint2)", argNames = "loggableBeforeNoJoinPoint2")
    public void doBefore(LoggableBeforeNoJoinPoint2 loggableBeforeNoJoinPoint2) throws Throwable {
        AbstractSpringLoggableAspect.before(loggableBeforeNoJoinPoint2.value());
    }
}
