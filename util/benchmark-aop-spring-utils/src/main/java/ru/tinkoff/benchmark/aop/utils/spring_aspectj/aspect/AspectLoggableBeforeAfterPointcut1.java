package ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.LoggableBeforeAfterPointcut1;

@Aspect
@Component
public class AspectLoggableBeforeAfterPointcut1 {

    @After(value = "matchAnnotatedMethod(loggableBeforeAfterPointcut1)", argNames = "joinPoint,loggableBeforeAfterPointcut1")
    public void doAfter(JoinPoint joinPoint, LoggableBeforeAfterPointcut1 loggableBeforeAfterPointcut1) throws Throwable {
        AbstractSpringLoggableAspect.after(joinPoint, loggableBeforeAfterPointcut1.value());
    }

    @Before(value = "matchAnnotatedMethod(loggableBeforeAfterPointcut1)", argNames = "joinPoint,loggableBeforeAfterPointcut1")
    public void doBefore(JoinPoint joinPoint, LoggableBeforeAfterPointcut1 loggableBeforeAfterPointcut1) throws Throwable {
        AbstractSpringLoggableAspect.before(joinPoint, loggableBeforeAfterPointcut1.value());
    }

    @Pointcut(value = "@annotation(loggableBeforeAfterPointcut1)", argNames = "loggableBeforeAfterPointcut1")
    public void matchAnnotatedMethod(LoggableBeforeAfterPointcut1 loggableBeforeAfterPointcut1) {}
}
