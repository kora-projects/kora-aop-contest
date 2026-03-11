package ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableBeforeNoJoinPoint2;

@Aspect
@Component
public class AspectLoggableBeforeNoJoinPoint2 {

    @Before(value = "@annotation(loggablePcwBeforeNoJoinPoint2)", argNames = "loggablePcwBeforeNoJoinPoint2")
    public void doBefore(LoggableBeforeNoJoinPoint2 loggablePcwBeforeNoJoinPoint2) throws Throwable {
        AbstractSpringLoggableAspect.before(loggablePcwBeforeNoJoinPoint2.value());
    }
}
