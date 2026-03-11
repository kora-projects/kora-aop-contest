package ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.LoggableBeforeAfterReturningPointcut2;

@Aspect
@Component
public class AspectLoggableBeforeAfterReturningPointcut2 {

    @AfterReturning(value = "matchAnnotatedMethod(loggableBeforeAfterReturningPointcut2)",
            argNames = "joinPoint,returning2,loggableBeforeAfterReturningPointcut2",
            returning = "returning2")
    public void doAfterReturning(JoinPoint joinPoint,
                                 Object returning2,
                                 LoggableBeforeAfterReturningPointcut2 loggableBeforeAfterReturningPointcut2)
            throws Throwable {
        AbstractSpringLoggableAspect.afterReturning(joinPoint, returning2, loggableBeforeAfterReturningPointcut2.value());
    }

    @Before(value = "matchAnnotatedMethod(loggableBeforeAfterReturningPointcut2)",
            argNames = "joinPoint,loggableBeforeAfterReturningPointcut2")
    public void doBefore(JoinPoint joinPoint, LoggableBeforeAfterReturningPointcut2 loggableBeforeAfterReturningPointcut2)
            throws Throwable {
        AbstractSpringLoggableAspect.before(joinPoint, loggableBeforeAfterReturningPointcut2.value());
    }

    @Pointcut(value = "@annotation(loggableBeforeAfterReturningPointcut2)", argNames = "loggableBeforeAfterReturningPointcut2")
    public void matchAnnotatedMethod(LoggableBeforeAfterReturningPointcut2 loggableBeforeAfterReturningPointcut2) {}
}
