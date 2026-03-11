package ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableBeforeAfterPointcut1;

@Aspect
@Component
public class AspectLoggableBeforeAfterPointcut1 {

    @After(value = "matchAnnotatedMethod(loggablePcwBeforeAfterPointcut1)",
            argNames = "joinPoint,loggablePcwBeforeAfterPointcut1")
    public void doAfter(JoinPoint joinPoint, LoggableBeforeAfterPointcut1 loggablePcwBeforeAfterPointcut1) throws Throwable {
        AbstractSpringLoggableAspect.after(joinPoint, loggablePcwBeforeAfterPointcut1.value());
    }

    @Before(value = "matchAnnotatedMethod(loggablePcwBeforeAfterPointcut1)",
            argNames = "joinPoint,loggablePcwBeforeAfterPointcut1")
    public void doBefore(JoinPoint joinPoint, LoggableBeforeAfterPointcut1 loggablePcwBeforeAfterPointcut1) throws Throwable {
        AbstractSpringLoggableAspect.before(joinPoint, loggablePcwBeforeAfterPointcut1.value());
    }

    @Pointcut(value = "@annotation(loggablePcwBeforeAfterPointcut1)", argNames = "loggablePcwBeforeAfterPointcut1")
    public void matchAnnotatedMethod(LoggableBeforeAfterPointcut1 loggablePcwBeforeAfterPointcut1) {}
}
