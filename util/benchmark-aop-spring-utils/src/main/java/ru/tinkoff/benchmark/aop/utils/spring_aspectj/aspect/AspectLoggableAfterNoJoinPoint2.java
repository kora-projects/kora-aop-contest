package ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.LoggableAfterNoJoinPoint2;

@Aspect
@Component
public class AspectLoggableAfterNoJoinPoint2 {

    @After(value = "@annotation(loggableAfterPointcut2)", argNames = "loggableAfterPointcut2")
    public void doAfter(LoggableAfterNoJoinPoint2 loggableAfterPointcut2) throws Throwable {
        AbstractSpringLoggableAspect.after(loggableAfterPointcut2.value());
    }
}
