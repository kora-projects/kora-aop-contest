package ru.tinkoff.benchmark.aop.spring.pcw;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.aot.DisabledInAotMode;
import ru.tinkoff.benchmark.aop.utils.AspectConsumer;
import ru.tinkoff.benchmark.aop.utils.AspectEmulator;

@DisabledInAotMode
@DirtiesContext(
        methodMode = DirtiesContext.MethodMode.BEFORE_METHOD,
        classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.NONE,
        classes = { SpringApplication_JdkDynamic_AspectJ_PCW.class })
public class Spring_AspectJ_JdkDynamic_PCW_BeforeThenAfterReturning_Tests {

    @Qualifier("BeforeThenAfterReturning")
    @Autowired
    private AspectEmulator emulator;

    @Test
    public void emulatorSuccess() {
        AtomicInteger counter = new AtomicInteger(0);
        AspectConsumer consumer = object -> counter.incrementAndGet();

        assertNotNull(emulator.doNothing1("1", consumer));
        assertEquals(3, counter.get());
        counter.set(0);

        assertNotNull(emulator.doNothing12345("1", consumer));
        assertEquals(11, counter.get());
        counter.set(0);

        assertNotNull(emulator.doWorkSmall1("1", consumer));
        assertEquals(3, counter.get());
        counter.set(0);

        assertNotNull(emulator.doWorkSmall12345("1", consumer));
        assertEquals(11, counter.get());
        counter.set(0);

        assertNotNull(emulator.doWorkMedium1("1", consumer));
        assertEquals(3, counter.get());
        counter.set(0);

        assertNotNull(emulator.doWorkMedium12345("1", consumer));
        assertEquals(11, counter.get());
        counter.set(0);

        assertNotNull(emulator.doWorkBig1("1", consumer));
        assertEquals(3, counter.get());
        counter.set(0);

        assertNotNull(emulator.doWorkBig12345("1", consumer));
        assertEquals(11, counter.get());
        counter.set(0);
    }
}
