package ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableBeforeAfterReturningPointcut4;

@Aspect
@Component
public class AspectLoggableBeforeAfterReturningPointcut4 {

    @AfterReturning(value = "matchAnnotatedMethod(loggablePcwBeforeAfterReturningPointcut4)",
            argNames = "joinPoint,returning4,loggablePcwBeforeAfterReturningPointcut4",
            returning = "returning4")
    public void doAfterReturning(JoinPoint joinPoint,
                                 Object returning4,
                                 LoggableBeforeAfterReturningPointcut4 loggablePcwBeforeAfterReturningPointcut4)
            throws Throwable {
        AbstractSpringLoggableAspect.afterReturning(joinPoint, returning4, loggablePcwBeforeAfterReturningPointcut4.value());
    }

    @Before(value = "matchAnnotatedMethod(loggablePcwBeforeAfterReturningPointcut4)",
            argNames = "joinPoint,loggablePcwBeforeAfterReturningPointcut4")
    public void doBefore(JoinPoint joinPoint, LoggableBeforeAfterReturningPointcut4 loggablePcwBeforeAfterReturningPointcut4)
            throws Throwable {
        AbstractSpringLoggableAspect.before(joinPoint, loggablePcwBeforeAfterReturningPointcut4.value());
    }

    @Pointcut(value = "@annotation(loggablePcwBeforeAfterReturningPointcut4)",
            argNames = "loggablePcwBeforeAfterReturningPointcut4")
    public void matchAnnotatedMethod(LoggableBeforeAfterReturningPointcut4 loggablePcwBeforeAfterReturningPointcut4) {}
}
