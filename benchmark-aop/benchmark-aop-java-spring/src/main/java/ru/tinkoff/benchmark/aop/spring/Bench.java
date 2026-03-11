package ru.tinkoff.benchmark.aop.spring;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.springframework.beans.factory.annotation.BeanFactoryAnnotationUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
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
            springContext = SpringApplication.run(SpringApplication_CGLIB.class);
            aspectEmulator = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    springContext.getAutowireCapableBeanFactory(), AspectEmulator.class, "Around");

            System.out.println(
                    "\nState - " + StateSpring_CGLIB.class.getSimpleName() + ", AspectEmulator - " + aspectEmulator.getClass());
            System.out.println("\n\nWARMUP");
            System.out.print("# Warmup Iteration   1: "); // Otherwise output is broken and parse script won't parse this mess
        }
    }

    @State(Scope.Benchmark)
    public static class StateSpring_CGLIB_After {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            springContext = SpringApplication.run(SpringApplication_CGLIB.class);
            aspectEmulator = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    springContext.getAutowireCapableBeanFactory(), AspectEmulator.class, "After");

            System.out.println(
                    "\nState - " + StateSpring_CGLIB.class.getSimpleName() + ", AspectEmulator - " + aspectEmulator.getClass());
            System.out.println("\n\nWARMUP");
            System.out.print("# Warmup Iteration   1: "); // Otherwise output is broken and parse script won't parse this mess
        }
    }

    @State(Scope.Benchmark)
    public static class StateSpring_CGLIB_AfterNoJoinPoint {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            springContext = SpringApplication.run(SpringApplication_CGLIB.class);
            aspectEmulator = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    springContext.getAutowireCapableBeanFactory(), AspectEmulator.class, "AfterNoJoinPoint");

            System.out.println(
                    "\nState - " + StateSpring_CGLIB.class.getSimpleName() + ", AspectEmulator - " + aspectEmulator.getClass());
            System.out.println("\n\nWARMUP");
            System.out.print("# Warmup Iteration   1: "); // Otherwise output is broken and parse script won't parse this mess
        }
    }

    @State(Scope.Benchmark)
    public static class StateSpring_CGLIB_AfterReturning {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            springContext = SpringApplication.run(SpringApplication_CGLIB.class);
            aspectEmulator = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    springContext.getAutowireCapableBeanFactory(), AspectEmulator.class, "AfterReturning");

            System.out.println(
                    "\nState - " + StateSpring_CGLIB.class.getSimpleName() + ", AspectEmulator - " + aspectEmulator.getClass());
            System.out.println("\n\nWARMUP");
            System.out.print("# Warmup Iteration   1: "); // Otherwise output is broken and parse script won't parse this mess
        }
    }

    @State(Scope.Benchmark)
    public static class StateSpring_CGLIB_AfterReturningNoJoinPoint {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            springContext = SpringApplication.run(SpringApplication_CGLIB.class);
            aspectEmulator = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    springContext.getAutowireCapableBeanFactory(), AspectEmulator.class, "AfterReturningNoJoinPoint");

            System.out.println(
                    "\nState - " + StateSpring_CGLIB.class.getSimpleName() + ", AspectEmulator - " + aspectEmulator.getClass());
            System.out.println("\n\nWARMUP");
            System.out.print("# Warmup Iteration   1: "); // Otherwise output is broken and parse script won't parse this mess
        }
    }

    @State(Scope.Benchmark)
    public static class StateSpring_CGLIB_Before {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            springContext = SpringApplication.run(SpringApplication_CGLIB.class);
            aspectEmulator = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    springContext.getAutowireCapableBeanFactory(), AspectEmulator.class, "Before");

            System.out.println(
                    "\nState - " + StateSpring_CGLIB.class.getSimpleName() + ", AspectEmulator - " + aspectEmulator.getClass());
            System.out.println("\n\nWARMUP");
            System.out.print("# Warmup Iteration   1: "); // Otherwise output is broken and parse script won't parse this mess
        }
    }

    @State(Scope.Benchmark)
    public static class StateSpring_CGLIB_BeforeAfterPointcut {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            springContext = SpringApplication.run(SpringApplication_CGLIB.class);
            aspectEmulator = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    springContext.getAutowireCapableBeanFactory(), AspectEmulator.class, "BeforeAfterPointcut");

            System.out.println(
                    "\nState - " + StateSpring_CGLIB.class.getSimpleName() + ", AspectEmulator - " + aspectEmulator.getClass());
            System.out.println("\n\nWARMUP");
            System.out.print("# Warmup Iteration   1: "); // Otherwise output is broken and parse script won't parse this mess
        }
    }

    @State(Scope.Benchmark)
    public static class StateSpring_CGLIB_BeforeAfterReturningPointcut {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            springContext = SpringApplication.run(SpringApplication_CGLIB.class);
            aspectEmulator = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    springContext.getAutowireCapableBeanFactory(), AspectEmulator.class, "BeforeAfterReturningPointcut");

            System.out.println(
                    "\nState - " + StateSpring_CGLIB.class.getSimpleName() + ", AspectEmulator - " + aspectEmulator.getClass());
            System.out.println("\n\nWARMUP");
            System.out.print("# Warmup Iteration   1: "); // Otherwise output is broken and parse script won't parse this mess
        }
    }

    @State(Scope.Benchmark)
    public static class StateSpring_CGLIB_BeforeNoJoinPoint {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            springContext = SpringApplication.run(SpringApplication_CGLIB.class);
            aspectEmulator = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    springContext.getAutowireCapableBeanFactory(), AspectEmulator.class, "BeforeNoJoinPoint");

            System.out.println(
                    "\nState - " + StateSpring_CGLIB.class.getSimpleName() + ", AspectEmulator - " + aspectEmulator.getClass());
            System.out.println("\n\nWARMUP");
            System.out.print("# Warmup Iteration   1: "); // Otherwise output is broken and parse script won't parse this mess
        }
    }

    @State(Scope.Benchmark)
    public static class StateSpring_CGLIB_BeforeNoJoinPointThenAfterReturningNoJoinPoint {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            springContext = SpringApplication.run(SpringApplication_CGLIB.class);
            aspectEmulator = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    springContext.getAutowireCapableBeanFactory(), AspectEmulator.class, "BeforeThenAfterReturningNoJoinPoint");

            System.out.println(
                    "\nState - " + StateSpring_CGLIB.class.getSimpleName() + ", AspectEmulator - " + aspectEmulator.getClass());
            System.out.println("\n\nWARMUP");
            System.out.print("# Warmup Iteration   1: "); // Otherwise output is broken and parse script won't parse this mess
        }
    }

    @State(Scope.Benchmark)
    public static class StateSpring_CGLIB_BeforeThenAfter {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            springContext = SpringApplication.run(SpringApplication_CGLIB.class);
            aspectEmulator = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    springContext.getAutowireCapableBeanFactory(), AspectEmulator.class, "BeforeThenAfter");

            System.out.println(
                    "\nState - " + StateSpring_CGLIB.class.getSimpleName() + ", AspectEmulator - " + aspectEmulator.getClass());
            System.out.println("\n\nWARMUP");
            System.out.print("# Warmup Iteration   1: "); // Otherwise output is broken and parse script won't parse this mess
        }
    }

    @State(Scope.Benchmark)
    public static class StateSpring_CGLIB_BeforeThenAfterNoJoinPoint {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            springContext = SpringApplication.run(SpringApplication_CGLIB.class);
            aspectEmulator = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    springContext.getAutowireCapableBeanFactory(), AspectEmulator.class, "BeforeThenAfterNoJoinPoint");

            System.out.println(
                    "\nState - " + StateSpring_CGLIB.class.getSimpleName() + ", AspectEmulator - " + aspectEmulator.getClass());
            System.out.println("\n\nWARMUP");
            System.out.print("# Warmup Iteration   1: "); // Otherwise output is broken and parse script won't parse this mess
        }
    }

    @State(Scope.Benchmark)
    public static class StateSpring_CGLIB_BeforeThenAfterReturning {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            springContext = SpringApplication.run(SpringApplication_CGLIB.class);
            aspectEmulator = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    springContext.getAutowireCapableBeanFactory(), AspectEmulator.class, "BeforeThenAfterReturning");

            System.out.println(
                    "\nState - " + StateSpring_CGLIB.class.getSimpleName() + ", AspectEmulator - " + aspectEmulator.getClass());
            System.out.println("\n\nWARMUP");
            System.out.print("# Warmup Iteration   1: "); // Otherwise output is broken and parse script won't parse this mess
        }
    }

    @State(Scope.Benchmark)
    public static class StateSpring_CGLIB_BeforeThenAfterReturningNoJoinPoint {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            springContext = SpringApplication.run(SpringApplication_CGLIB.class);
            aspectEmulator = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    springContext.getAutowireCapableBeanFactory(), AspectEmulator.class, "BeforeThenAfterReturningNoJoinPoint");

            System.out.println(
                    "\nState - " + StateSpring_CGLIB.class.getSimpleName() + ", AspectEmulator - " + aspectEmulator.getClass());
            System.out.println("\n\nWARMUP");
            System.out.print("# Warmup Iteration   1: "); // Otherwise output is broken and parse script won't parse this mess
        }
    }

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
            springContext = SpringApplication.run(SpringApplication_JdkDynamic.class);
            aspectEmulator = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    springContext.getAutowireCapableBeanFactory(), AspectEmulator.class, "Around");

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
    public void Spring_Java_LoggerOff12345_CGLIB_Around(StateSpring_CGLIB state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doWorkLoggerOff12345("1", blackhole::consume));
    }

    @Benchmark
    public void Spring_Java_LoggerOff12345_JdkDynamic_Around(StateSpring_JdkDynamic state,
                                                             Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doWorkLoggerOff12345("1", blackhole::consume));
    }

    @Benchmark
    public void Spring_Java_LoggerOff1_CGLIB_Around(StateSpring_CGLIB state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doWorkLoggerOff1("1", blackhole::consume));
    }

    @Benchmark
    public void Spring_Java_LoggerOff1_JdkDynamic_Around(StateSpring_JdkDynamic state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doWorkLoggerOff1("1", blackhole::consume));
    }

    @Benchmark
    public void Spring_Java_Nothing12345_CGLIB_After(StateSpring_CGLIB_After state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing12345("1", blackhole::consume));
    }

    @Benchmark
    public void Spring_Java_Nothing12345_CGLIB_AfterNoJoinPoint(StateSpring_CGLIB_AfterNoJoinPoint state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing12345("1", blackhole::consume));
    }

    @Benchmark
    public void Spring_Java_Nothing12345_CGLIB_AfterReturning(StateSpring_CGLIB_AfterReturning state,
                                                              Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing12345("1", blackhole::consume));
    }

    @Benchmark
    public void
            Spring_Java_Nothing12345_CGLIB_AfterReturningNoJoinPoint(StateSpring_CGLIB_AfterReturningNoJoinPoint state,
                                                                     Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing12345("1", blackhole::consume));
    }

    @Benchmark
    public void Spring_Java_Nothing12345_CGLIB_Around(StateSpring_CGLIB state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing12345("1", blackhole::consume));
    }

    @Benchmark
    public void Spring_Java_Nothing12345_CGLIB_Before(StateSpring_CGLIB_Before state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing12345("1", blackhole::consume));
    }

    @Benchmark
    public void
            Spring_Java_Nothing12345_CGLIB_BeforeAfterPointcut(StateSpring_CGLIB_BeforeAfterPointcut state,
                                                               Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing12345("1", blackhole::consume));
    }

    @Benchmark
    public void
            Spring_Java_Nothing12345_CGLIB_BeforeAfterReturningPointcut(StateSpring_CGLIB_BeforeAfterReturningPointcut state,
                                                                        Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing12345("1", blackhole::consume));
    }

    @Benchmark
    public void Spring_Java_Nothing12345_CGLIB_BeforeNoJoinPoint(StateSpring_CGLIB_BeforeNoJoinPoint state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing12345("1", blackhole::consume));
    }

    @Benchmark
    public void Spring_Java_Nothing12345_CGLIB_BeforeThenAfter(StateSpring_CGLIB_BeforeThenAfter state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing12345("1", blackhole::consume));
    }

    @Benchmark
    public void
            Spring_Java_Nothing12345_CGLIB_BeforeThenAfterNoJoinPoint(StateSpring_CGLIB_BeforeThenAfterNoJoinPoint state,
                                                                      Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing12345("1", blackhole::consume));
    }

    @Benchmark
    public void
            Spring_Java_Nothing12345_CGLIB_BeforeThenAfterReturning(StateSpring_CGLIB_BeforeThenAfterReturning state,
                                                                    Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing12345("1", blackhole::consume));
    }

    @Benchmark
    public void
            Spring_Java_Nothing12345_CGLIB_BeforeThenAfterReturningNoJoinPoint(StateSpring_CGLIB_BeforeThenAfterReturningNoJoinPoint state,
                                                                               Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing12345("1", blackhole::consume));
    }

    @Benchmark
    public void Spring_Java_Nothing12345_JdkDynamic_Around(StateSpring_JdkDynamic state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing12345("1", blackhole::consume));
    }

    // Spring CGLIB After
    @Benchmark
    public void Spring_Java_Nothing1_CGLIB_After(StateSpring_CGLIB_After state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing1("1", blackhole::consume));
    }

    // Spring CGLIB AfterNoJoinPoint
    @Benchmark
    public void Spring_Java_Nothing1_CGLIB_AfterNoJoinPoint(StateSpring_CGLIB_AfterNoJoinPoint state,
                                                            Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing1("1", blackhole::consume));
    }

    // Spring CGLIB AfterReturning
    @Benchmark
    public void Spring_Java_Nothing1_CGLIB_AfterReturning(StateSpring_CGLIB_AfterReturning state,
                                                          Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing1("1", blackhole::consume));
    }

    // Spring CGLIB AfterReturningNoJoinPoint
    @Benchmark
    public void
            Spring_Java_Nothing1_CGLIB_AfterReturningNoJoinPoint(StateSpring_CGLIB_AfterReturningNoJoinPoint state,
                                                                 Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing1("1", blackhole::consume));
    }

    // Spring CGLIB Around
    @Benchmark
    public void Spring_Java_Nothing1_CGLIB_Around(StateSpring_CGLIB state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing1("1", blackhole::consume));
    }

    // Spring CGLIB Before
    @Benchmark
    public void Spring_Java_Nothing1_CGLIB_Before(StateSpring_CGLIB_Before state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing1("1", blackhole::consume));
    }

    // Spring CGLIB BeforeAfterPointcut
    @Benchmark
    public void Spring_Java_Nothing1_CGLIB_BeforeAfterPointcut(StateSpring_CGLIB_BeforeAfterPointcut state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing1("1", blackhole::consume));
    }

    // Spring CGLIB BeforeAfterReturningPointcut
    @Benchmark
    public void
            Spring_Java_Nothing1_CGLIB_BeforeAfterReturningPointcut(StateSpring_CGLIB_BeforeAfterReturningPointcut state,
                                                                    Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing1("1", blackhole::consume));
    }

    // Spring CGLIB BeforeNoJoinPoint
    @Benchmark
    public void Spring_Java_Nothing1_CGLIB_BeforeNoJoinPoint(StateSpring_CGLIB_BeforeNoJoinPoint state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing1("1", blackhole::consume));
    }

    // Spring CGLIB BeforeThenAfter
    @Benchmark
    public void Spring_Java_Nothing1_CGLIB_BeforeThenAfter(StateSpring_CGLIB_BeforeThenAfter state,
                                                           Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing1("1", blackhole::consume));
    }

    // Spring CGLIB BeforeThenAfterNoJoinPoint
    @Benchmark
    public void
            Spring_Java_Nothing1_CGLIB_BeforeThenAfterNoJoinPoint(StateSpring_CGLIB_BeforeThenAfterNoJoinPoint state,
                                                                  Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing1("1", blackhole::consume));
    }

    // Spring CGLIB BeforeThenAfterReturning
    @Benchmark
    public void
            Spring_Java_Nothing1_CGLIB_BeforeThenAfterReturning(StateSpring_CGLIB_BeforeThenAfterReturning state,
                                                                Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing1("1", blackhole::consume));
    }

    // Spring CGLIB BeforeThenAfterReturningNoJoinPoint
    @Benchmark
    public void
            Spring_Java_Nothing1_CGLIB_BeforeThenAfterReturningNoJoinPoint(StateSpring_CGLIB_BeforeThenAfterReturningNoJoinPoint state,
                                                                           Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing1("1", blackhole::consume));
    }

    // Spring JdkDynamic Around
    @Benchmark
    public void Spring_Java_Nothing1_JdkDynamic_Around(StateSpring_JdkDynamic state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing1("1", blackhole::consume));
    }

    @Benchmark
    public void Spring_Java_Small12345_CGLIB_Around(StateSpring_CGLIB state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doWorkSmall12345("1", blackhole::consume));
    }

    @Benchmark
    public void Spring_Java_Small1_CGLIB_Around(StateSpring_CGLIB state, Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doWorkSmall1("1", blackhole::consume));
    }
}
