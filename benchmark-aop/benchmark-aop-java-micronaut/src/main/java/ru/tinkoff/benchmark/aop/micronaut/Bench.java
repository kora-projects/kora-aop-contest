package ru.tinkoff.benchmark.aop.micronaut;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.Micronaut;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import ru.tinkoff.benchmark.aop.utils.AspectEmulator;
import ru.tinkoff.benchmark.common.BenchOptions;

@State(Scope.Benchmark)
public class Bench {

    @State(Scope.Benchmark)
    public static class StateMicronaut_Resilient4j {

        AspectEmulator aspectEmulator;
        ApplicationContext micronautContext;

        @TearDown
        public void cleanup() {
            micronautContext.close();
        }

        @Setup
        public void setup() {
            micronautContext = Micronaut.build(new String[] {})
                    .mainClass(Micronaut_Application.class)
                    .eagerInitSingletons(true)
                    .eagerInitConfiguration(true)
                    .banner(false)
                    .start();
            aspectEmulator = micronautContext.getBean(AspectEmulator.class);

            System.out.println(
                    "\nState - " + StateMicronaut_Resilient4j.class.getSimpleName() + ", AspectEmulator - "
                            + aspectEmulator.getClass());
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
    public void Micronaut_Java_LoggerOff1(StateMicronaut_Resilient4j state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doWorkLoggerOff1("1", blackhole::consume));
    }

    @Benchmark
    public void Micronaut_Java_LoggerOff12345(StateMicronaut_Resilient4j state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doWorkLoggerOff12345("1", blackhole::consume));
    }

    // Micronaut
    @Benchmark
    public void Micronaut_Java_Nothing1(StateMicronaut_Resilient4j state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing1("1", blackhole::consume));
    }

    @Benchmark
    public void Micronaut_Java_Nothing12345(StateMicronaut_Resilient4j state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing12345("1", blackhole::consume));
    }

    @Benchmark
    public void Micronaut_Java_Small1(StateMicronaut_Resilient4j state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doWorkSmall1("1", blackhole::consume));
    }

    @Benchmark
    public void Micronaut_Java_Small12345(StateMicronaut_Resilient4j state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doWorkSmall12345("1", blackhole::consume));
    }
}
