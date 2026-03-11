package ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.LoggableBeforeAfterReturningPointcut1;

@Aspect
@Component
public class AspectLoggableBeforeAfterReturningPointcut1 {

    @AfterReturning(value = "matchAnnotatedMethod(loggableBeforeAfterReturningPointcut1)",
            argNames = "joinPoint,returning1,loggableBeforeAfterReturningPointcut1",
            returning = "returning1")
    public void doAfterReturning(JoinPoint joinPoint,
                                 Object returning1,
                                 LoggableBeforeAfterReturningPointcut1 loggableBeforeAfterReturningPointcut1)
            throws Throwable {
        AbstractSpringLoggableAspect.afterReturning(joinPoint, returning1, loggableBeforeAfterReturningPointcut1.value());
    }

    @Before(value = "matchAnnotatedMethod(loggableBeforeAfterReturningPointcut1)",
            argNames = "joinPoint,loggableBeforeAfterReturningPointcut1")
    public void doBefore(JoinPoint joinPoint, LoggableBeforeAfterReturningPointcut1 loggableBeforeAfterReturningPointcut1)
            throws Throwable {
        AbstractSpringLoggableAspect.before(joinPoint, loggableBeforeAfterReturningPointcut1.value());
    }

    @Pointcut(value = "@annotation(loggableBeforeAfterReturningPointcut1)", argNames = "loggableBeforeAfterReturningPointcut1")
    public void matchAnnotatedMethod(LoggableBeforeAfterReturningPointcut1 loggableBeforeAfterReturningPointcut1) {}
}
