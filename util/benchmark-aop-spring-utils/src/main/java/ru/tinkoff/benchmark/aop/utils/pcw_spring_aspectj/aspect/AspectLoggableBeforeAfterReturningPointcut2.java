package ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableBeforeAfterReturningPointcut2;

@Aspect
@Component
public class AspectLoggableBeforeAfterReturningPointcut2 {

    @AfterReturning(value = "matchAnnotatedMethod(loggablePcwBeforeAfterReturningPointcut2)",
            argNames = "joinPoint,returning2,loggablePcwBeforeAfterReturningPointcut2",
            returning = "returning2")
    public void doAfterReturning(JoinPoint joinPoint,
                                 Object returning2,
                                 LoggableBeforeAfterReturningPointcut2 loggablePcwBeforeAfterReturningPointcut2)
            throws Throwable {
        AbstractSpringLoggableAspect.afterReturning(joinPoint, returning2, loggablePcwBeforeAfterReturningPointcut2.value());
    }

    @Before(value = "matchAnnotatedMethod(loggablePcwBeforeAfterReturningPointcut2)",
            argNames = "joinPoint,loggablePcwBeforeAfterReturningPointcut2")
    public void doBefore(JoinPoint joinPoint, LoggableBeforeAfterReturningPointcut2 loggablePcwBeforeAfterReturningPointcut2)
            throws Throwable {
        AbstractSpringLoggableAspect.before(joinPoint, loggablePcwBeforeAfterReturningPointcut2.value());
    }

    @Pointcut(value = "@annotation(loggablePcwBeforeAfterReturningPointcut2)",
            argNames = "loggablePcwBeforeAfterReturningPointcut2")
    public void matchAnnotatedMethod(LoggableBeforeAfterReturningPointcut2 loggablePcwBeforeAfterReturningPointcut2) {}
}
