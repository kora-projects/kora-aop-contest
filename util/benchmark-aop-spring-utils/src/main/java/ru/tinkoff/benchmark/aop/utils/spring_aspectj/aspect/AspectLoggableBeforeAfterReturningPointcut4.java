package ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.LoggableBeforeAfterReturningPointcut4;

@Aspect
@Component
public class AspectLoggableBeforeAfterReturningPointcut4 {

    @AfterReturning(value = "matchAnnotatedMethod(loggableBeforeAfterReturningPointcut4)",
            argNames = "joinPoint,returning4,loggableBeforeAfterReturningPointcut4",
            returning = "returning4")
    public void doAfterReturning(JoinPoint joinPoint,
                                 Object returning4,
                                 LoggableBeforeAfterReturningPointcut4 loggableBeforeAfterReturningPointcut4)
            throws Throwable {
        AbstractSpringLoggableAspect.afterReturning(joinPoint, returning4, loggableBeforeAfterReturningPointcut4.value());
    }

    @Before(value = "matchAnnotatedMethod(loggableBeforeAfterReturningPointcut4)",
            argNames = "joinPoint,loggableBeforeAfterReturningPointcut4")
    public void doBefore(JoinPoint joinPoint, LoggableBeforeAfterReturningPointcut4 loggableBeforeAfterReturningPointcut4)
            throws Throwable {
        AbstractSpringLoggableAspect.before(joinPoint, loggableBeforeAfterReturningPointcut4.value());
    }

    @Pointcut(value = "@annotation(loggableBeforeAfterReturningPointcut4)", argNames = "loggableBeforeAfterReturningPointcut4")
    public void matchAnnotatedMethod(LoggableBeforeAfterReturningPointcut4 loggableBeforeAfterReturningPointcut4) {}
}
