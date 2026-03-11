package ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.LoggableBeforeAfterReturningPointcut5;

@Aspect
@Component
public class AspectLoggableBeforeAfterReturningPointcut5 {

    @AfterReturning(value = "matchAnnotatedMethod(loggableBeforeAfterReturningPointcut5)",
            argNames = "joinPoint,returning5,loggableBeforeAfterReturningPointcut5",
            returning = "returning5")
    public void doAfterReturning(JoinPoint joinPoint,
                                 Object returning5,
                                 LoggableBeforeAfterReturningPointcut5 loggableBeforeAfterReturningPointcut5)
            throws Throwable {
        AbstractSpringLoggableAspect.afterReturning(joinPoint, returning5, loggableBeforeAfterReturningPointcut5.value());
    }

    @Before(value = "matchAnnotatedMethod(loggableBeforeAfterReturningPointcut5)",
            argNames = "joinPoint,loggableBeforeAfterReturningPointcut5")
    public void doBefore(JoinPoint joinPoint, LoggableBeforeAfterReturningPointcut5 loggableBeforeAfterReturningPointcut5)
            throws Throwable {
        AbstractSpringLoggableAspect.before(joinPoint, loggableBeforeAfterReturningPointcut5.value());
    }

    @Pointcut(value = "@annotation(loggableBeforeAfterReturningPointcut5)", argNames = "loggableBeforeAfterReturningPointcut5")
    public void matchAnnotatedMethod(LoggableBeforeAfterReturningPointcut5 loggableBeforeAfterReturningPointcut5) {}
}
