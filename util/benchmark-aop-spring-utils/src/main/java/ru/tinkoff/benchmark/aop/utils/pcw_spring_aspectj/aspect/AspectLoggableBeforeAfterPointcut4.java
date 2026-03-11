package ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableBeforeAfterPointcut4;

@Aspect
@Component
public class AspectLoggableBeforeAfterPointcut4 {

    @After(value = "matchAnnotatedMethod(loggablePcwBeforeAfterPointcut4)",
            argNames = "joinPoint,loggablePcwBeforeAfterPointcut4")
    public void doAfter(JoinPoint joinPoint, LoggableBeforeAfterPointcut4 loggablePcwBeforeAfterPointcut4) throws Throwable {
        AbstractSpringLoggableAspect.after(joinPoint, loggablePcwBeforeAfterPointcut4.value());
    }

    @Before(value = "matchAnnotatedMethod(loggablePcwBeforeAfterPointcut4)",
            argNames = "joinPoint,loggablePcwBeforeAfterPointcut4")
    public void doBefore(JoinPoint joinPoint, LoggableBeforeAfterPointcut4 loggablePcwBeforeAfterPointcut4) throws Throwable {
        AbstractSpringLoggableAspect.before(joinPoint, loggablePcwBeforeAfterPointcut4.value());
    }

    @Pointcut(value = "@annotation(loggablePcwBeforeAfterPointcut4)", argNames = "loggablePcwBeforeAfterPointcut4")
    public void matchAnnotatedMethod(LoggableBeforeAfterPointcut4 loggablePcwBeforeAfterPointcut4) {}
}
