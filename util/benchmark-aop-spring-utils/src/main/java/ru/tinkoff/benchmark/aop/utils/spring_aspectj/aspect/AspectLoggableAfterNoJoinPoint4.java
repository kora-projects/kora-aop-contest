package ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.LoggableAfterNoJoinPoint4;

@Aspect
@Component
public class AspectLoggableAfterNoJoinPoint4 {

    @After(value = "@annotation(loggableAfterPointcut4)", argNames = "loggableAfterPointcut4")
    public void doAfter(LoggableAfterNoJoinPoint4 loggableAfterPointcut4) throws Throwable {
        AbstractSpringLoggableAspect.after(loggableAfterPointcut4.value());
    }
}
