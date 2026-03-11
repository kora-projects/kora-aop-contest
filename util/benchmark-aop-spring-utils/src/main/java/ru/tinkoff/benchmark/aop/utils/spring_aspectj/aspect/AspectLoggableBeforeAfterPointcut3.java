package ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.LoggableBeforeAfterPointcut3;

@Aspect
@Component
public class AspectLoggableBeforeAfterPointcut3 {

    @After(value = "matchAnnotatedMethod(loggableBeforeAfterPointcut3)", argNames = "joinPoint,loggableBeforeAfterPointcut3")
    public void doAfter(JoinPoint joinPoint, LoggableBeforeAfterPointcut3 loggableBeforeAfterPointcut3) throws Throwable {
        AbstractSpringLoggableAspect.after(joinPoint, loggableBeforeAfterPointcut3.value());
    }

    @Before(value = "matchAnnotatedMethod(loggableBeforeAfterPointcut3)", argNames = "joinPoint,loggableBeforeAfterPointcut3")
    public void doBefore(JoinPoint joinPoint, LoggableBeforeAfterPointcut3 loggableBeforeAfterPointcut3) throws Throwable {
        AbstractSpringLoggableAspect.before(joinPoint, loggableBeforeAfterPointcut3.value());
    }

    @Pointcut(value = "@annotation(loggableBeforeAfterPointcut3)", argNames = "loggableBeforeAfterPointcut3")
    public void matchAnnotatedMethod(LoggableBeforeAfterPointcut3 loggableBeforeAfterPointcut3) {}
}
