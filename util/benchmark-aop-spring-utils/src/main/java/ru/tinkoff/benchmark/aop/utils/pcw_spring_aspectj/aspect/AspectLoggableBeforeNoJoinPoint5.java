package ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableBeforeNoJoinPoint5;

@Aspect
@Component
public class AspectLoggableBeforeNoJoinPoint5 {

    @Before(value = "@annotation(loggablePcwBeforeNoJoinPoint5)", argNames = "loggablePcwBeforeNoJoinPoint5")
    public void doBefore(LoggableBeforeNoJoinPoint5 loggablePcwBeforeNoJoinPoint5) throws Throwable {
        AbstractSpringLoggableAspect.before(loggablePcwBeforeNoJoinPoint5.value());
    }
}
