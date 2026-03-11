package ru.tinkoff.benchmark.aop.spring.ltw;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.tinkoff.benchmark.aop.utils.AspectEmulator;
import ru.tinkoff.benchmark.aop.utils.AspectProductionCacheOnly;
import ru.tinkoff.benchmark.aop.utils.AspectProductionSpring;
import ru.tinkoff.benchmark.aop.utils.AspectProductionValidateOnly;
import ru.tinkoff.benchmark.common.BenchOptions;

@State(Scope.Benchmark)
public class Bench {

    @State(Scope.Benchmark)
    public static class StateSpring_CGLIB_AspectJ_LTW {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            springContext = SpringApplication.run(SpringApplication_CGLIB_AspectJ_LTW.class);
            aspectEmulator = springContext.getBean(AspectEmulator.class);

            System.out.println("\nState - " + StateSpring_CGLIB_AspectJ_LTW.class.getSimpleName()
                    + ", AspectEmulator - " + aspectEmulator.getClass());
            System.out.println("\n\nWARMUP");
            System.out.print("# Warmup Iteration   1: "); // Otherwise output is broken and parse script won't parse this mess
        }
    }

    @State(Scope.Benchmark)
    public static class StateSpring_JdkDynamic_AspectJ_LTW {

        AspectEmulator aspectEmulator;
        AspectProductionSpring aspectProduction;
        AspectProductionCacheOnly aspectProductionCacheOnly;
        AspectProductionValidateOnly aspectProductionValidateOnly;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            springContext = SpringApplication.run(SpringApplication_JdkDynamic_AspectJ_LTW.class);
            aspectEmulator = springContext.getBean(AspectEmulator.class);
            aspectProduction = springContext.getBean(AspectProductionSpring.class);
            aspectProductionCacheOnly = springContext.getBean(AspectProductionCacheOnly.class);
            aspectProductionValidateOnly = springContext.getBean(AspectProductionValidateOnly.class);

            System.out.println("\nState - " + StateSpring_JdkDynamic_AspectJ_LTW.class.getSimpleName()
                    + ", AspectEmulator - " + aspectEmulator.getClass());
            System.out.println("State - " + StateSpring_JdkDynamic_AspectJ_LTW.class.getSimpleName()
                    + ", AspectProduction - " + aspectProduction.getClass());
            System.out.println(
                    "State - " + StateSpring_JdkDynamic_AspectJ_LTW.class.getSimpleName()
                            + ", AspectProductionCacheOnly - " + aspectProductionCacheOnly.getClass());
            System.out.println(
                    "State - " + StateSpring_JdkDynamic_AspectJ_LTW.class.getSimpleName()
                            + ", AspectProductionValidateOnly - " + aspectProductionValidateOnly.getClass());
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
    public void Spring_Java_Nothing12345_CGLIB_AspectJ_LTW_Around(StateSpring_CGLIB_AspectJ_LTW state,
                                                                  Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing12345("1", blackhole::consume));
    }

    // Spring CGLIB LTW
    @Benchmark
    public void Spring_Java_Nothing1_CGLIB_AspectJ_LTW_Around(StateSpring_CGLIB_AspectJ_LTW state,
                                                              Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing1("1", blackhole::consume));
    }
}
