package ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableAfterNoJoinPoint4;

@Aspect
@Component
public class AspectLoggableAfterNoJoinPoint4 {

    @After(value = "@annotation(loggablePcwAfterPointcut4)", argNames = "loggablePcwAfterPointcut4")
    public void doAfter(LoggableAfterNoJoinPoint4 loggablePcwAfterPointcut4) throws Throwable {
        AbstractSpringLoggableAspect.after(loggablePcwAfterPointcut4.value());
    }
}
