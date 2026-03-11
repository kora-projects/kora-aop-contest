package ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableBeforeAfterReturningPointcut1;

@Aspect
@Component
public class AspectLoggableBeforeAfterReturningPointcut1 {

    @AfterReturning(value = "matchAnnotatedMethod(loggablePcwBeforeAfterReturningPointcut1)",
            argNames = "joinPoint,returning1,loggablePcwBeforeAfterReturningPointcut1",
            returning = "returning1")
    public void doAfterReturning(JoinPoint joinPoint,
                                 Object returning1,
                                 LoggableBeforeAfterReturningPointcut1 loggablePcwBeforeAfterReturningPointcut1)
            throws Throwable {
        AbstractSpringLoggableAspect.afterReturning(joinPoint, returning1, loggablePcwBeforeAfterReturningPointcut1.value());
    }

    @Before(value = "matchAnnotatedMethod(loggablePcwBeforeAfterReturningPointcut1)",
            argNames = "joinPoint,loggablePcwBeforeAfterReturningPointcut1")
    public void doBefore(JoinPoint joinPoint, LoggableBeforeAfterReturningPointcut1 loggablePcwBeforeAfterReturningPointcut1)
            throws Throwable {
        AbstractSpringLoggableAspect.before(joinPoint, loggablePcwBeforeAfterReturningPointcut1.value());
    }

    @Pointcut(value = "@annotation(loggablePcwBeforeAfterReturningPointcut1)",
            argNames = "loggablePcwBeforeAfterReturningPointcut1")
    public void matchAnnotatedMethod(LoggableBeforeAfterReturningPointcut1 loggablePcwBeforeAfterReturningPointcut1) {}
}
