package ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.LoggableAfterNoJoinPoint1;

@Aspect
@Component
public class AspectLoggableAfterNoJoinPoint1 {

    @After(value = "@annotation(loggableAfterPointcut1)", argNames = "loggableAfterPointcut1")
    public void doAfter(LoggableAfterNoJoinPoint1 loggableAfterPointcut1) throws Throwable {
        AbstractSpringLoggableAspect.after(loggableAfterPointcut1.value());
    }
}
