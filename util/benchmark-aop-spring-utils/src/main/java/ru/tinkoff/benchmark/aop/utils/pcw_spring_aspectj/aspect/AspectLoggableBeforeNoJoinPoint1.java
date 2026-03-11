package ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableBeforeNoJoinPoint1;

@Aspect
@Component
public class AspectLoggableBeforeNoJoinPoint1 {

    @Before(value = "@annotation(loggablePcwBeforeNoJoinPoint1)", argNames = "loggablePcwBeforeNoJoinPoint1")
    public void doBefore(LoggableBeforeNoJoinPoint1 loggablePcwBeforeNoJoinPoint1) throws Throwable {
        AbstractSpringLoggableAspect.before(loggablePcwBeforeNoJoinPoint1.value());
    }
}
