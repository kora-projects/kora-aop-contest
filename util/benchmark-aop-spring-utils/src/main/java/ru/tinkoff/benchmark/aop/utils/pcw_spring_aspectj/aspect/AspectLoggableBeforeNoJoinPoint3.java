package ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableBeforeNoJoinPoint3;

@Aspect
@Component
public class AspectLoggableBeforeNoJoinPoint3 {

    @Before(value = "@annotation(loggablePcwBeforeNoJoinPoint3)", argNames = "loggablePcwBeforeNoJoinPoint3")
    public void doBefore(LoggableBeforeNoJoinPoint3 loggablePcwBeforeNoJoinPoint3) throws Throwable {
        AbstractSpringLoggableAspect.before(loggablePcwBeforeNoJoinPoint3.value());
    }
}
