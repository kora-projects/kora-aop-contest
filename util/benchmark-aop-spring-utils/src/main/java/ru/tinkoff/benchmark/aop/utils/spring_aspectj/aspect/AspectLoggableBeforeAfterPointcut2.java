package ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.LoggableBeforeAfterPointcut2;

@Aspect
@Component
public class AspectLoggableBeforeAfterPointcut2 {

    @After(value = "matchAnnotatedMethod(loggableBeforeAfterPointcut2)", argNames = "joinPoint,loggableBeforeAfterPointcut2")
    public void doAfter(JoinPoint joinPoint, LoggableBeforeAfterPointcut2 loggableBeforeAfterPointcut2) throws Throwable {
        AbstractSpringLoggableAspect.after(joinPoint, loggableBeforeAfterPointcut2.value());
    }

    @Before(value = "matchAnnotatedMethod(loggableBeforeAfterPointcut2)", argNames = "joinPoint,loggableBeforeAfterPointcut2")
    public void doBefore(JoinPoint joinPoint, LoggableBeforeAfterPointcut2 loggableBeforeAfterPointcut2) throws Throwable {
        AbstractSpringLoggableAspect.before(joinPoint, loggableBeforeAfterPointcut2.value());
    }

    @Pointcut(value = "@annotation(loggableBeforeAfterPointcut2)", argNames = "loggableBeforeAfterPointcut2")
    public void matchAnnotatedMethod(LoggableBeforeAfterPointcut2 loggableBeforeAfterPointcut2) {}
}
