package ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableAfterNoJoinPoint3;

@Aspect
@Component
public class AspectLoggableAfterNoJoinPoint3 {

    @After(value = "@annotation(loggablePcwAfterPointcut3)", argNames = "loggablePcwAfterPointcut3")
    public void doAfter(LoggableAfterNoJoinPoint3 loggablePcwAfterPointcut3) throws Throwable {
        AbstractSpringLoggableAspect.after(loggablePcwAfterPointcut3.value());
    }
}
