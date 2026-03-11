package ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableBeforeAfterPointcut2;

@Aspect
@Component
public class AspectLoggableBeforeAfterPointcut2 {

    @After(value = "matchAnnotatedMethod(loggablePcwBeforeAfterPointcut2)",
            argNames = "joinPoint,loggablePcwBeforeAfterPointcut2")
    public void doAfter(JoinPoint joinPoint, LoggableBeforeAfterPointcut2 loggablePcwBeforeAfterPointcut2) throws Throwable {
        AbstractSpringLoggableAspect.after(joinPoint, loggablePcwBeforeAfterPointcut2.value());
    }

    @Before(value = "matchAnnotatedMethod(loggablePcwBeforeAfterPointcut2)",
            argNames = "joinPoint,loggablePcwBeforeAfterPointcut2")
    public void doBefore(JoinPoint joinPoint, LoggableBeforeAfterPointcut2 loggablePcwBeforeAfterPointcut2) throws Throwable {
        AbstractSpringLoggableAspect.before(joinPoint, loggablePcwBeforeAfterPointcut2.value());
    }

    @Pointcut(value = "@annotation(loggablePcwBeforeAfterPointcut2)", argNames = "loggablePcwBeforeAfterPointcut2")
    public void matchAnnotatedMethod(LoggableBeforeAfterPointcut2 loggablePcwBeforeAfterPointcut2) {}
}
