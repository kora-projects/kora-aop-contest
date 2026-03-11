package ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.LoggableAfterNoJoinPoint5;

@Aspect
@Component
public class AspectLoggableAfterNoJoinPoint5 {

    @After(value = "@annotation(loggableAfterPointcut5)", argNames = "loggableAfterPointcut5")
    public void doAfter(LoggableAfterNoJoinPoint5 loggableAfterPointcut5) throws Throwable {
        AbstractSpringLoggableAspect.after(loggableAfterPointcut5.value());
    }
}
