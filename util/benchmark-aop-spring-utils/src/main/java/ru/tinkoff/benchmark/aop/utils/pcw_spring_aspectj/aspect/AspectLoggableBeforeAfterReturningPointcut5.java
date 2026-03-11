package ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableBeforeAfterReturningPointcut5;

@Aspect
@Component
public class AspectLoggableBeforeAfterReturningPointcut5 {

    @AfterReturning(value = "matchAnnotatedMethod(loggablePcwBeforeAfterReturningPointcut5)",
            argNames = "joinPoint,returning5,loggablePcwBeforeAfterReturningPointcut5",
            returning = "returning5")
    public void doAfterReturning(JoinPoint joinPoint,
                                 Object returning5,
                                 LoggableBeforeAfterReturningPointcut5 loggablePcwBeforeAfterReturningPointcut5)
            throws Throwable {
        AbstractSpringLoggableAspect.afterReturning(joinPoint, returning5, loggablePcwBeforeAfterReturningPointcut5.value());
    }

    @Before(value = "matchAnnotatedMethod(loggablePcwBeforeAfterReturningPointcut5)",
            argNames = "joinPoint,loggablePcwBeforeAfterReturningPointcut5")
    public void doBefore(JoinPoint joinPoint, LoggableBeforeAfterReturningPointcut5 loggablePcwBeforeAfterReturningPointcut5)
            throws Throwable {
        AbstractSpringLoggableAspect.before(joinPoint, loggablePcwBeforeAfterReturningPointcut5.value());
    }

    @Pointcut(value = "@annotation(loggablePcwBeforeAfterReturningPointcut5)",
            argNames = "loggablePcwBeforeAfterReturningPointcut5")
    public void matchAnnotatedMethod(LoggableBeforeAfterReturningPointcut5 loggablePcwBeforeAfterReturningPointcut5) {}
}
