package ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableAfterNoJoinPoint5;

@Aspect
@Component
public class AspectLoggableAfterNoJoinPoint5 {

    @After(value = "@annotation(loggablePcwAfterPointcut5)", argNames = "loggablePcwAfterPointcut5")
    public void doAfter(LoggableAfterNoJoinPoint5 loggablePcwAfterPointcut5) throws Throwable {
        AbstractSpringLoggableAspect.after(loggablePcwAfterPointcut5.value());
    }
}
