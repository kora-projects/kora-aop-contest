package ru.tinkoff.benchmark.aop.spring.aot.jdkdynamic;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.tinkoff.benchmark.aop.utils.AspectEmulator;
import ru.tinkoff.benchmark.common.BenchOptions;

@State(Scope.Benchmark)
public class Bench {

    @State(Scope.Benchmark)
    public static class StateSpring_JdkDynamic {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            // https://github.com/spring-projects/spring-boot/issues/38258
            var springApplication = new SpringApplication(SpringApplication_JdkDynamic.class);
            springApplication.setMainApplicationClass(SpringApplication_JdkDynamic.class);
            springContext = springApplication.run();
            aspectEmulator = springContext.getBean(AspectEmulator.class);

            System.out.println(
                    "\nState - " + StateSpring_JdkDynamic.class.getSimpleName() + ", AspectEmulator - "
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
    public void Spring_Java_LoggerOff12345_JdkDynamic_AOT_Around(StateSpring_JdkDynamic state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doWorkLoggerOff12345("1", blackhole::consume));
    }

    @Benchmark
    public void Spring_Java_LoggerOff1_JdkDynamic_AOT_Around(StateSpring_JdkDynamic state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doWorkLoggerOff1("1", blackhole::consume));
    }

    @Benchmark
    public void Spring_Java_Nothing12345_JdkDynamic_AOT_Around(StateSpring_JdkDynamic state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing12345("1", blackhole::consume));
    }

    // Spring JdkDynamic
    @Benchmark
    public void Spring_Java_Nothing1_JdkDynamic_AOT_Around(StateSpring_JdkDynamic state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing1("1", blackhole::consume));
    }

    @Benchmark
    public void Spring_Java_Small12345_JdkDynamic_AOT_Around(StateSpring_JdkDynamic state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doWorkSmall12345("1", blackhole::consume));
    }

    @Benchmark
    public void Spring_Java_Small1_JdkDynamic_AOT_Around(StateSpring_JdkDynamic state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doWorkSmall1("1", blackhole::consume));
    }
}
