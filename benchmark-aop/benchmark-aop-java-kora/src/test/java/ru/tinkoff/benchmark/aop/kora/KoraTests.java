package ru.tinkoff.benchmark.aop.kora;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;
import ru.tinkoff.benchmark.aop.kora.emulator.KoraAspectEmulator;
import ru.tinkoff.benchmark.aop.utils.AspectConsumer;
import ru.tinkoff.kora.test.extension.junit5.KoraAppTest;
import ru.tinkoff.kora.test.extension.junit5.TestComponent;

@KoraAppTest(Kora_Application.class)
class KoraTests {

    @TestComponent
    private KoraAspectEmulator work;

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
