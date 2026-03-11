package ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.LoggableBeforeAfterPointcut5;

@Aspect
@Component
public class AspectLoggableBeforeAfterPointcut5 {

    @After(value = "matchAnnotatedMethod(loggablePcwBeforeAfterPointcut5)",
            argNames = "joinPoint,loggablePcwBeforeAfterPointcut5")
    public void doAfter(JoinPoint joinPoint, LoggableBeforeAfterPointcut5 loggablePcwBeforeAfterPointcut5) throws Throwable {
        AbstractSpringLoggableAspect.after(joinPoint, loggablePcwBeforeAfterPointcut5.value());
    }

    @Before(value = "matchAnnotatedMethod(loggablePcwBeforeAfterPointcut5)",
            argNames = "joinPoint,loggablePcwBeforeAfterPointcut5")
    public void doBefore(JoinPoint joinPoint, LoggableBeforeAfterPointcut5 loggablePcwBeforeAfterPointcut5) throws Throwable {
        AbstractSpringLoggableAspect.before(joinPoint, loggablePcwBeforeAfterPointcut5.value());
    }

    @Pointcut(value = "@annotation(loggablePcwBeforeAfterPointcut5)", argNames = "loggablePcwBeforeAfterPointcut5")
    public void matchAnnotatedMethod(LoggableBeforeAfterPointcut5 loggablePcwBeforeAfterPointcut5) {}
}
