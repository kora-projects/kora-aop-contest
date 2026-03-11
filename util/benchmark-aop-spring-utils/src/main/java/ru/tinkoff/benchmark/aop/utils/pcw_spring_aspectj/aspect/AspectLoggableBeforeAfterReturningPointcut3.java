package ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableBeforeAfterReturningPointcut3;

@Aspect
@Component
public class AspectLoggableBeforeAfterReturningPointcut3 {

    @AfterReturning(value = "matchAnnotatedMethod(loggablePcwBeforeAfterReturningPointcut3)",
            argNames = "joinPoint,returning3,loggablePcwBeforeAfterReturningPointcut3",
            returning = "returning3")
    public void doAfterReturning(JoinPoint joinPoint,
                                 Object returning3,
                                 LoggableBeforeAfterReturningPointcut3 loggablePcwBeforeAfterReturningPointcut3)
            throws Throwable {
        AbstractSpringLoggableAspect.afterReturning(joinPoint, returning3, loggablePcwBeforeAfterReturningPointcut3.value());
    }

    @Before(value = "matchAnnotatedMethod(loggablePcwBeforeAfterReturningPointcut3)",
            argNames = "joinPoint,loggablePcwBeforeAfterReturningPointcut3")
    public void doBefore(JoinPoint joinPoint, LoggableBeforeAfterReturningPointcut3 loggablePcwBeforeAfterReturningPointcut3)
            throws Throwable {
        AbstractSpringLoggableAspect.before(joinPoint, loggablePcwBeforeAfterReturningPointcut3.value());
    }

    @Pointcut(value = "@annotation(loggablePcwBeforeAfterReturningPointcut3)",
            argNames = "loggablePcwBeforeAfterReturningPointcut3")
    public void matchAnnotatedMethod(LoggableBeforeAfterReturningPointcut3 loggablePcwBeforeAfterReturningPointcut3) {}
}
