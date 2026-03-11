package ru.tinkoff.benchmark.aop.kora;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import ru.tinkoff.benchmark.aop.kora.emulator.KoraAspectEmulator;
import ru.tinkoff.benchmark.aop.utils.AspectEmulator;
import ru.tinkoff.benchmark.common.BenchOptions;
import ru.tinkoff.kora.application.graph.ApplicationGraphDraw;
import ru.tinkoff.kora.application.graph.KoraApplication;
import ru.tinkoff.kora.application.graph.RefreshableGraph;

@State(Scope.Benchmark)
public class Bench {

    @State(Scope.Benchmark)
    public static class StateKora {

        AspectEmulator aspectEmulator;
        RefreshableGraph koraContext;

        @TearDown
        public void cleanup() {
            try {
                koraContext.release();
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }

        @Setup
        public void setup() {
            ApplicationGraphDraw graphDraw = Kora_ApplicationGraph.graph();
            koraContext = KoraApplication.run(() -> graphDraw);
            aspectEmulator = (KoraAspectEmulator) graphDraw.getNodes().stream()
                    .filter(n -> n.type() instanceof Class<?>)
                    .filter(n -> KoraAspectEmulator.class.isAssignableFrom((Class<?>) n.type()))
                    .findFirst()
                    .map(koraContext::get)
                    .orElseThrow();
            System.out
                    .println("\nState - " + StateKora.class.getSimpleName() + ", AspectEmulator - " + aspectEmulator.getClass());
            System.out.println("\n\nWARMUP");
            System.out.print("# Warmup Iteration   1: "); // Otherwise output is broken and parse script won't parse this mess
        }
    }

    public static void main(String[] args) throws RunnerException {
        final Options options = BenchOptions.getOptions(Bench.class,
                BenchOptions.BenchWarmType.PRECISE,
                BenchOptions.BenchMeasureType.STANDARD).build();
        new Runner(options).run();
    }

    @Benchmark
    public void Kora_Java_LoggerOff1(StateKora state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doWorkLoggerOff1("1", blackhole::consume));
    }

    @Benchmark
    public void Kora_Java_LoggerOff12345(StateKora state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doWorkLoggerOff12345("1", blackhole::consume));
    }

    // Kora
    @Benchmark
    public void Kora_Java_Nothing1(StateKora state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing1("1", blackhole::consume));
    }

    @Benchmark
    public void Kora_Java_Nothing12345(StateKora state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing12345("1", blackhole::consume));
    }

    @Benchmark
    public void Kora_Java_Small1(StateKora state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doWorkSmall1("1", blackhole::consume));
    }

    @Benchmark
    public void Kora_Java_Small12345(StateKora state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doWorkSmall12345("1", blackhole::consume));
    }
}
