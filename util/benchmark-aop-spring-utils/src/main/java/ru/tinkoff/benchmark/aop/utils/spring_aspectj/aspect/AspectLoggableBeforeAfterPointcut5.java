package ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.LoggableBeforeAfterPointcut5;

@Aspect
@Component
public class AspectLoggableBeforeAfterPointcut5 {

    @After(value = "matchAnnotatedMethod(loggableBeforeAfterPointcut5)", argNames = "joinPoint,loggableBeforeAfterPointcut5")
    public void doAfter(JoinPoint joinPoint, LoggableBeforeAfterPointcut5 loggableBeforeAfterPointcut5) throws Throwable {
        AbstractSpringLoggableAspect.after(joinPoint, loggableBeforeAfterPointcut5.value());
    }

    @Before(value = "matchAnnotatedMethod(loggableBeforeAfterPointcut5)", argNames = "joinPoint,loggableBeforeAfterPointcut5")
    public void doBefore(JoinPoint joinPoint, LoggableBeforeAfterPointcut5 loggableBeforeAfterPointcut5) throws Throwable {
        AbstractSpringLoggableAspect.before(joinPoint, loggableBeforeAfterPointcut5.value());
    }

    @Pointcut(value = "@annotation(loggableBeforeAfterPointcut5)", argNames = "loggableBeforeAfterPointcut5")
    public void matchAnnotatedMethod(LoggableBeforeAfterPointcut5 loggableBeforeAfterPointcut5) {}
}
