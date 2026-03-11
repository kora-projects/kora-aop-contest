package ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.LoggableAfterNoJoinPoint3;

@Aspect
@Component
public class AspectLoggableAfterNoJoinPoint3 {

    @After(value = "@annotation(loggableAfterPointcut3)", argNames = "loggableAfterPointcut3")
    public void doAfter(LoggableAfterNoJoinPoint3 loggableAfterPointcut3) throws Throwable {
        AbstractSpringLoggableAspect.after(loggableAfterPointcut3.value());
    }
}
