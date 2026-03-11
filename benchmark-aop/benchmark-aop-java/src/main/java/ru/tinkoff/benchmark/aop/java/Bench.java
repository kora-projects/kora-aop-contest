package ru.tinkoff.benchmark.aop.java;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import ru.tinkoff.benchmark.aop.java.emulator.JavaAspectEmulator;
import ru.tinkoff.benchmark.common.BenchOptions;

@State(Scope.Benchmark)
public class Bench {

    @State(Scope.Benchmark)
    public static class StateJava {

        final JavaAspectEmulator aspectEmulator = new JavaAspectEmulator();

        @TearDown
        public void cleanup() {
            // do nothing
        }

        @Setup
        public void setup() {
            System.out
                    .println("\nState - " + StateJava.class.getSimpleName() + ", AspectEmulator - " + aspectEmulator.getClass());
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
    public String Java_LoggerOff1(StateJava state, Blackhole blackhole) {
        return state.aspectEmulator.doWorkLoggerOff1("1", blackhole::consume);
    }

    @Benchmark
    public void Java_LoggerOff12345(StateJava state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doWorkLoggerOff12345("1", blackhole::consume));
    }

    // @Benchmark
    // public void Java_Small1(StateJava state, Blackhole blackhole) {
    // blackhole.consume(state.aspectEmulator.doWorkSmall1("1", blackhole::consume));
    // }
    //
    // @Benchmark
    // public void Java_Small12345(StateJava state, Blackhole blackhole) {
    // blackhole.consume(state.aspectEmulator.doWorkSmall12345("1", blackhole::consume));
    // }
    //
    // @Benchmark
    // public void Java_Medium1(StateJava state, Blackhole blackhole) {
    // blackhole.consume(state.aspectEmulator.doWorkMedium1("1", blackhole::consume));
    // }
    //
    // @Benchmark
    // public void Java_Medium12345(StateJava state, Blackhole blackhole) {
    // blackhole.consume(state.aspectEmulator.doWorkMedium12345("1", blackhole::consume));
    // }
    //
    // @Benchmark
    // public void Java_Big1(StateJava state, Blackhole blackhole) {
    // blackhole.consume(state.aspectEmulator.doWorkBig1("1", blackhole::consume));
    // }
    //
    // @Benchmark
    // public void Java_Big12345(StateJava state, Blackhole blackhole) {
    // blackhole.consume(state.aspectEmulator.doWorkBig12345("1", blackhole::consume));
    // }

    // Java
    @Benchmark
    public void Java_Nothing1(StateJava state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing1("1", blackhole::consume));
    }

    @Benchmark
    public void Java_Nothing12345(StateJava state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing12345("1", blackhole::consume));
    }
}
