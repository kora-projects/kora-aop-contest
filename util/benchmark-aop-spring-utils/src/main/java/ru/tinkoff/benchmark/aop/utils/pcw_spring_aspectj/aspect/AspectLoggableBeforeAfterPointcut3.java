package ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableBeforeAfterPointcut3;

@Aspect
@Component
public class AspectLoggableBeforeAfterPointcut3 {

    @After(value = "matchAnnotatedMethod(loggablePcwBeforeAfterPointcut3)",
            argNames = "joinPoint,loggablePcwBeforeAfterPointcut3")
    public void doAfter(JoinPoint joinPoint, LoggableBeforeAfterPointcut3 loggablePcwBeforeAfterPointcut3) throws Throwable {
        AbstractSpringLoggableAspect.after(joinPoint, loggablePcwBeforeAfterPointcut3.value());
    }

    @Before(value = "matchAnnotatedMethod(loggablePcwBeforeAfterPointcut3)",
            argNames = "joinPoint,loggablePcwBeforeAfterPointcut3")
    public void doBefore(JoinPoint joinPoint, LoggableBeforeAfterPointcut3 loggablePcwBeforeAfterPointcut3) throws Throwable {
        AbstractSpringLoggableAspect.before(joinPoint, loggablePcwBeforeAfterPointcut3.value());
    }

    @Pointcut(value = "@annotation(loggablePcwBeforeAfterPointcut3)", argNames = "loggablePcwBeforeAfterPointcut3")
    public void matchAnnotatedMethod(LoggableBeforeAfterPointcut3 loggablePcwBeforeAfterPointcut3) {}
}
