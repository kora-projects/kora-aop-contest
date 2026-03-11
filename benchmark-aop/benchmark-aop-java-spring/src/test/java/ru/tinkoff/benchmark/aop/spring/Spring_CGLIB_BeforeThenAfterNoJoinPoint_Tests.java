package ru.tinkoff.benchmark.aop.spring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.aot.DisabledInAotMode;
import ru.tinkoff.benchmark.aop.utils.AspectConsumer;
import ru.tinkoff.benchmark.aop.utils.AspectEmulator;
import ru.tinkoff.benchmark.aop.utils.spring_aspectj.aspect.AbstractSpringLoggableAspect;

@DisabledInAotMode
@DirtiesContext(
        methodMode = DirtiesContext.MethodMode.BEFORE_METHOD,
        classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.NONE,
        classes = { SpringApplication_CGLIB.class })
public class Spring_CGLIB_BeforeThenAfterNoJoinPoint_Tests {

    @Qualifier("BeforeThenAfterNoJoinPoint")
    @Autowired
    private AspectEmulator emulator;

    // Always 1 invocation cause NoJoinPoint do not use method arguments -> can't invoke AspectConsumer
    @Test
    public void emulatorNoBlackHoleIsFromArgumentInvoked() {
        AtomicInteger counter = new AtomicInteger(0);
        AspectConsumer consumer = object -> counter.incrementAndGet();

        try (var mockedStatic = Mockito.mockStatic(AbstractSpringLoggableAspect.class)) {
            assertNotNull(emulator.doNothing1("1", consumer));
            mockedStatic.verify(() -> AbstractSpringLoggableAspect.before(Mockito.any()), Mockito.times(1));
            assertEquals(1, counter.get());
            mockedStatic.verify(() -> AbstractSpringLoggableAspect.after(Mockito.any()), Mockito.times(1));
            counter.set(0);
            mockedStatic.reset();

            assertNotNull(emulator.doNothing12345("1", consumer));
            mockedStatic.verify(() -> AbstractSpringLoggableAspect.before(Mockito.any()), Mockito.times(5));
            assertEquals(1, counter.get());
            mockedStatic.verify(() -> AbstractSpringLoggableAspect.after(Mockito.any()), Mockito.times(5));
            counter.set(0);
            mockedStatic.reset();

            assertNotNull(emulator.doWorkSmall1("1", consumer));
            mockedStatic.verify(() -> AbstractSpringLoggableAspect.before(Mockito.any()), Mockito.times(1));
            assertEquals(1, counter.get());
            mockedStatic.verify(() -> AbstractSpringLoggableAspect.after(Mockito.any()), Mockito.times(1));
            counter.set(0);
            mockedStatic.reset();

            assertNotNull(emulator.doWorkSmall12345("1", consumer));
            mockedStatic.verify(() -> AbstractSpringLoggableAspect.before(Mockito.any()), Mockito.times(5));
            assertEquals(1, counter.get());
            mockedStatic.verify(() -> AbstractSpringLoggableAspect.after(Mockito.any()), Mockito.times(5));
            counter.set(0);
            mockedStatic.reset();

            assertNotNull(emulator.doWorkMedium1("1", consumer));
            mockedStatic.verify(() -> AbstractSpringLoggableAspect.before(Mockito.any()), Mockito.times(1));
            assertEquals(1, counter.get());
            mockedStatic.verify(() -> AbstractSpringLoggableAspect.after(Mockito.any()), Mockito.times(1));
            counter.set(0);
            mockedStatic.reset();

            assertNotNull(emulator.doWorkMedium12345("1", consumer));
            mockedStatic.verify(() -> AbstractSpringLoggableAspect.before(Mockito.any()), Mockito.times(5));
            assertEquals(1, counter.get());
            mockedStatic.verify(() -> AbstractSpringLoggableAspect.after(Mockito.any()), Mockito.times(5));
            counter.set(0);
            mockedStatic.reset();

            assertNotNull(emulator.doWorkBig1("1", consumer));
            mockedStatic.verify(() -> AbstractSpringLoggableAspect.before(Mockito.any()), Mockito.times(1));
            assertEquals(1, counter.get());
            mockedStatic.verify(() -> AbstractSpringLoggableAspect.after(Mockito.any()), Mockito.times(1));
            counter.set(0);
            mockedStatic.reset();

            assertNotNull(emulator.doWorkBig12345("1", consumer));
            mockedStatic.verify(() -> AbstractSpringLoggableAspect.before(Mockito.any()), Mockito.times(5));
            assertEquals(1, counter.get());
            mockedStatic.verify(() -> AbstractSpringLoggableAspect.after(Mockito.any()), Mockito.times(5));
            counter.set(0);
            mockedStatic.reset();
        }
    }
}
