package ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.LoggableBeforeAfterPointcut4;

@Aspect
@Component
public class AspectLoggableBeforeAfterPointcut4 {

    @After(value = "matchAnnotatedMethod(loggableBeforeAfterPointcut4)", argNames = "joinPoint,loggableBeforeAfterPointcut4")
    public void doAfter(JoinPoint joinPoint, LoggableBeforeAfterPointcut4 loggableBeforeAfterPointcut4) throws Throwable {
        AbstractSpringLoggableAspect.after(joinPoint, loggableBeforeAfterPointcut4.value());
    }

    @Before(value = "matchAnnotatedMethod(loggableBeforeAfterPointcut4)", argNames = "joinPoint,loggableBeforeAfterPointcut4")
    public void doBefore(JoinPoint joinPoint, LoggableBeforeAfterPointcut4 loggableBeforeAfterPointcut4) throws Throwable {
        AbstractSpringLoggableAspect.before(joinPoint, loggableBeforeAfterPointcut4.value());
    }

    @Pointcut(value = "@annotation(loggableBeforeAfterPointcut4)", argNames = "loggableBeforeAfterPointcut4")
    public void matchAnnotatedMethod(LoggableBeforeAfterPointcut4 loggableBeforeAfterPointcut4) {}
}
