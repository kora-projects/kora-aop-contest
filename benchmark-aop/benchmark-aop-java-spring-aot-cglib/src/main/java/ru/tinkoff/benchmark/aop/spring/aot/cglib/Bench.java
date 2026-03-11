package ru.tinkoff.benchmark.aop.spring.aot.cglib;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.tinkoff.benchmark.aop.spring.aot.cglib.emulator.SpringAspectEmulator;
import ru.tinkoff.benchmark.aop.utils.AspectEmulator;
import ru.tinkoff.benchmark.common.BenchOptions;

@State(Scope.Benchmark)
public class Bench {

    @State(Scope.Benchmark)
    public static class StateSpring_CGLIB {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            // https://github.com/spring-projects/spring-boot/issues/38258
            var springApplication = new SpringApplication(SpringApplication_CGLIB.class);
            springApplication.setMainApplicationClass(SpringApplication_CGLIB.class);
            springContext = springApplication.run();
            aspectEmulator = springContext.getBean(SpringAspectEmulator.class);

            System.out.println(
                    "\nState - " + StateSpring_CGLIB.class.getSimpleName() + ", AspectEmulator - " + aspectEmulator.getClass());
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
    public void Spring_Java_LoggerOff12345_CGLIB_AOT_Around(StateSpring_CGLIB state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doWorkLoggerOff12345("1", blackhole::consume));
    }

    @Benchmark
    public void Spring_Java_LoggerOff1_CGLIB_AOT_Around(StateSpring_CGLIB state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doWorkLoggerOff1("1", blackhole::consume));
    }

    @Benchmark
    public void Spring_Java_Nothing12345_CGLIB_AOT_Around(StateSpring_CGLIB state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing12345("1", blackhole::consume));
    }

    // Spring CGLIB
    @Benchmark
    public void Spring_Java_Nothing1_CGLIB_AOT_Around(StateSpring_CGLIB state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing1("1", blackhole::consume));
    }

    @Benchmark
    public void Spring_Java_Small12345_CGLIB_AOT_Around(StateSpring_CGLIB state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doWorkSmall12345("1", blackhole::consume));
    }

    @Benchmark
    public void Spring_Java_Small1_CGLIB_AOT_Around(StateSpring_CGLIB state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doWorkSmall1("1", blackhole::consume));
    }
}
