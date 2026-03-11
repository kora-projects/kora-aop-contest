package ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableAfterNoJoinPoint1;

@Aspect
@Component
public class AspectLoggableAfterNoJoinPoint1 {

    @After(value = "@annotation(loggablePcwAfterPointcut1)", argNames = "loggablePcwAfterPointcut1")
    public void doAfter(LoggableAfterNoJoinPoint1 loggablePcwAfterPointcut1) throws Throwable {
        AbstractSpringLoggableAspect.after(loggablePcwAfterPointcut1.value());
    }
}
