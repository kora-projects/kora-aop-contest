package ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableAfterNoJoinPoint2;

@Aspect
@Component
public class AspectLoggableAfterNoJoinPoint2 {

    @After(value = "@annotation(loggablePcwAfterPointcut2)", argNames = "loggablePcwAfterPointcut2")
    public void doAfter(LoggableAfterNoJoinPoint2 loggablePcwAfterPointcut2) throws Throwable {
        AbstractSpringLoggableAspect.after(loggablePcwAfterPointcut2.value());
    }
}
