package ru.tinkoff.benchmark.aop.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;
import ru.tinkoff.benchmark.aop.java.emulator.JavaAspectEmulator;
import ru.tinkoff.benchmark.aop.utils.AspectConsumer;

class JavaTests {

    private final JavaAspectEmulator work = new JavaAspectEmulator();

    @Test
    public void emulatorSuccess() {
        AtomicInteger counter = new AtomicInteger(0);
        AspectConsumer consumer = object -> counter.incrementAndGet();

        assertNotNull(work.doNothing1("1", consumer));
        assertEquals(3, counter.get());
        counter.set(0);

        assertNotNull(work.doNothing12345("1", consumer));
        assertEquals(11, counter.get());
        counter.set(0);

        assertNotNull(work.doWorkSmall1("1", consumer));
        assertEquals(3, counter.get());
        counter.set(0);

        assertNotNull(work.doWorkSmall12345("1", consumer));
        assertEquals(11, counter.get());
        counter.set(0);

        assertNotNull(work.doWorkMedium1("1", consumer));
        assertEquals(3, counter.get());
        counter.set(0);

        assertNotNull(work.doWorkMedium12345("1", consumer));
        assertEquals(11, counter.get());
        counter.set(0);

        assertNotNull(work.doWorkBig1("1", consumer));
        assertEquals(3, counter.get());
        counter.set(0);

        assertNotNull(work.doWorkBig12345("1", consumer));
        assertEquals(11, counter.get());
        counter.set(0);
    }
}
