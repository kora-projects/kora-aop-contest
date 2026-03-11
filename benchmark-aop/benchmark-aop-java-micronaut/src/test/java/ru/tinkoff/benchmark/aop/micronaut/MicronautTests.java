package ru.tinkoff.benchmark.aop.micronaut;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;
import ru.tinkoff.benchmark.aop.utils.AspectConsumer;
import ru.tinkoff.benchmark.aop.utils.AspectEmulator;

@MicronautTest(transactional = false, rebuildContext = true)
public class MicronautTests {

    @Inject
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
