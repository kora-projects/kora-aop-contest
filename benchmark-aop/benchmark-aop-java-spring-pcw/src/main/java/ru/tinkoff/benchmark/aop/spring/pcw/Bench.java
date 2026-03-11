package ru.tinkoff.benchmark.aop.spring.pcw;

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
    public static class StateSpring_CGLIB_AspectJ_PCW {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            springContext = SpringApplication.run(SpringApplication_CGLIB_AspectJ_PCW.class);
            aspectEmulator = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    springContext.getAutowireCapableBeanFactory(), AspectEmulator.class, "Around");

            System.out.println(
                    "\nState - " + StateSpring_CGLIB_AspectJ_PCW.class.getSimpleName() + ", AspectEmulator - "
                            + aspectEmulator.getClass());
            System.out.println("\n\nWARMUP");
            System.out.print("# Warmup Iteration   1: "); // Otherwise output is broken and parse script won't parse this mess
        }
    }

    @State(Scope.Benchmark)
    public static class StateSpring_CGLIB_AspectJ_PCW_After {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            springContext = SpringApplication.run(SpringApplication_CGLIB_AspectJ_PCW.class);
            aspectEmulator = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    springContext.getAutowireCapableBeanFactory(), AspectEmulator.class, "After");

            System.out.println(
                    "\nState - " + StateSpring_CGLIB_AspectJ_PCW.class.getSimpleName() + ", AspectEmulator - "
                            + aspectEmulator.getClass());
            System.out.println("\n\nWARMUP");
            System.out.print("# Warmup Iteration   1: "); // Otherwise output is broken and parse script won't parse this mess
        }
    }

    @State(Scope.Benchmark)
    public static class StateSpring_CGLIB_AspectJ_PCW_AfterNoJoinPoint {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            springContext = SpringApplication.run(SpringApplication_CGLIB_AspectJ_PCW.class);
            aspectEmulator = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    springContext.getAutowireCapableBeanFactory(), AspectEmulator.class, "AfterNoJoinPoint");

            System.out.println(
                    "\nState - " + StateSpring_CGLIB_AspectJ_PCW.class.getSimpleName() + ", AspectEmulator - "
                            + aspectEmulator.getClass());
            System.out.println("\n\nWARMUP");
            System.out.print("# Warmup Iteration   1: "); // Otherwise output is broken and parse script won't parse this mess
        }
    }

    @State(Scope.Benchmark)
    public static class StateSpring_CGLIB_AspectJ_PCW_AfterReturning {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            springContext = SpringApplication.run(SpringApplication_CGLIB_AspectJ_PCW.class);
            aspectEmulator = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    springContext.getAutowireCapableBeanFactory(), AspectEmulator.class, "AfterReturning");

            System.out.println(
                    "\nState - " + StateSpring_CGLIB_AspectJ_PCW.class.getSimpleName() + ", AspectEmulator - "
                            + aspectEmulator.getClass());
            System.out.println("\n\nWARMUP");
            System.out.print("# Warmup Iteration   1: "); // Otherwise output is broken and parse script won't parse this mess
        }
    }

    @State(Scope.Benchmark)
    public static class StateSpring_CGLIB_AspectJ_PCW_AfterReturningNoJoinPoint {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            springContext = SpringApplication.run(SpringApplication_CGLIB_AspectJ_PCW.class);
            aspectEmulator = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    springContext.getAutowireCapableBeanFactory(), AspectEmulator.class, "AfterReturningNoJoinPoint");

            System.out.println(
                    "\nState - " + StateSpring_CGLIB_AspectJ_PCW.class.getSimpleName() + ", AspectEmulator - "
                            + aspectEmulator.getClass());
            System.out.println("\n\nWARMUP");
            System.out.print("# Warmup Iteration   1: "); // Otherwise output is broken and parse script won't parse this mess
        }
    }

    @State(Scope.Benchmark)
    public static class StateSpring_CGLIB_AspectJ_PCW_Before {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            springContext = SpringApplication.run(SpringApplication_CGLIB_AspectJ_PCW.class);
            aspectEmulator = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    springContext.getAutowireCapableBeanFactory(), AspectEmulator.class, "Before");

            System.out.println(
                    "\nState - " + StateSpring_CGLIB_AspectJ_PCW.class.getSimpleName() + ", AspectEmulator - "
                            + aspectEmulator.getClass());
            System.out.println("\n\nWARMUP");
            System.out.print("# Warmup Iteration   1: "); // Otherwise output is broken and parse script won't parse this mess
        }
    }

    @State(Scope.Benchmark)
    public static class StateSpring_CGLIB_AspectJ_PCW_BeforeAfterPointcut {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            springContext = SpringApplication.run(SpringApplication_CGLIB_AspectJ_PCW.class);
            aspectEmulator = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    springContext.getAutowireCapableBeanFactory(), AspectEmulator.class, "BeforeAfterPointcut");

            System.out.println(
                    "\nState - " + StateSpring_CGLIB_AspectJ_PCW.class.getSimpleName() + ", AspectEmulator - "
                            + aspectEmulator.getClass());
            System.out.println("\n\nWARMUP");
            System.out.print("# Warmup Iteration   1: "); // Otherwise output is broken and parse script won't parse this mess
        }
    }

    @State(Scope.Benchmark)
    public static class StateSpring_CGLIB_AspectJ_PCW_BeforeAfterReturningPointcut {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            springContext = SpringApplication.run(SpringApplication_CGLIB_AspectJ_PCW.class);
            aspectEmulator = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    springContext.getAutowireCapableBeanFactory(), AspectEmulator.class, "BeforeAfterReturningPointcut");

            System.out.println(
                    "\nState - " + StateSpring_CGLIB_AspectJ_PCW.class.getSimpleName() + ", AspectEmulator - "
                            + aspectEmulator.getClass());
            System.out.println("\n\nWARMUP");
            System.out.print("# Warmup Iteration   1: "); // Otherwise output is broken and parse script won't parse this mess
        }
    }

    @State(Scope.Benchmark)
    public static class StateSpring_CGLIB_AspectJ_PCW_BeforeNoJoinPoint {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            springContext = SpringApplication.run(SpringApplication_CGLIB_AspectJ_PCW.class);
            aspectEmulator = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    springContext.getAutowireCapableBeanFactory(), AspectEmulator.class, "BeforeNoJoinPoint");

            System.out.println(
                    "\nState - " + StateSpring_CGLIB_AspectJ_PCW.class.getSimpleName() + ", AspectEmulator - "
                            + aspectEmulator.getClass());
            System.out.println("\n\nWARMUP");
            System.out.print("# Warmup Iteration   1: "); // Otherwise output is broken and parse script won't parse this mess
        }
    }

    @State(Scope.Benchmark)
    public static class StateSpring_CGLIB_AspectJ_PCW_BeforeNoJoinPointThenAfterNoJoinPoint {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            springContext = SpringApplication.run(SpringApplication_CGLIB_AspectJ_PCW.class);
            aspectEmulator = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    springContext.getAutowireCapableBeanFactory(), AspectEmulator.class, "BeforeNoJoinPointThenAfterNoJoinPoint");

            System.out.println(
                    "\nState - " + StateSpring_CGLIB_AspectJ_PCW.class.getSimpleName() + ", AspectEmulator - "
                            + aspectEmulator.getClass());
            System.out.println("\n\nWARMUP");
            System.out.print("# Warmup Iteration   1: "); // Otherwise output is broken and parse script won't parse this mess
        }
    }

    @State(Scope.Benchmark)
    public static class StateSpring_CGLIB_AspectJ_PCW_BeforeNoJoinPointThenAfterReturningNoJoinPoint {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            springContext = SpringApplication.run(SpringApplication_CGLIB_AspectJ_PCW.class);
            aspectEmulator = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    springContext.getAutowireCapableBeanFactory(), AspectEmulator.class,
                    "BeforeNoJoinPointThenAfterReturningNoJoinPoint");

            System.out.println(
                    "\nState - " + StateSpring_CGLIB_AspectJ_PCW.class.getSimpleName() + ", AspectEmulator - "
                            + aspectEmulator.getClass());
            System.out.println("\n\nWARMUP");
            System.out.print("# Warmup Iteration   1: "); // Otherwise output is broken and parse script won't parse this mess
        }
    }

    @State(Scope.Benchmark)
    public static class StateSpring_CGLIB_AspectJ_PCW_BeforeThenAfter {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            springContext = SpringApplication.run(SpringApplication_CGLIB_AspectJ_PCW.class);
            aspectEmulator = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    springContext.getAutowireCapableBeanFactory(), AspectEmulator.class, "BeforeThenAfter");

            System.out.println(
                    "\nState - " + StateSpring_CGLIB_AspectJ_PCW.class.getSimpleName() + ", AspectEmulator - "
                            + aspectEmulator.getClass());
            System.out.println("\n\nWARMUP");
            System.out.print("# Warmup Iteration   1: "); // Otherwise output is broken and parse script won't parse this mess
        }
    }

    @State(Scope.Benchmark)
    public static class StateSpring_CGLIB_AspectJ_PCW_BeforeThenAfterReturning {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            springContext = SpringApplication.run(SpringApplication_CGLIB_AspectJ_PCW.class);
            aspectEmulator = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    springContext.getAutowireCapableBeanFactory(), AspectEmulator.class, "BeforeThenAfterReturning");

            System.out.println(
                    "\nState - " + StateSpring_CGLIB_AspectJ_PCW.class.getSimpleName() + ", AspectEmulator - "
                            + aspectEmulator.getClass());
            System.out.println("\n\nWARMUP");
            System.out.print("# Warmup Iteration   1: "); // Otherwise output is broken and parse script won't parse this mess
        }
    }

    @State(Scope.Benchmark)
    public static class StateSpring_CGLIB_AspectJ_PCW_BeforeThenAfterReturningNoJoinPoint {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            springContext = SpringApplication.run(SpringApplication_CGLIB_AspectJ_PCW.class);
            aspectEmulator = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    springContext.getAutowireCapableBeanFactory(), AspectEmulator.class, "BeforeThenAfterReturningNoJoinPoint");

            System.out.println(
                    "\nState - " + StateSpring_CGLIB_AspectJ_PCW.class.getSimpleName() + ", AspectEmulator - "
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
    public void
            Spring_Java_LoggerOff12345_CGLIB_AspectJ_PCW_Around(StateSpring_CGLIB_AspectJ_PCW state,
                                                                Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doWorkLoggerOff12345("1", blackhole::consume));
    }

    @Benchmark
    public void Spring_Java_LoggerOff1_CGLIB_AspectJ_PCW_Around(StateSpring_CGLIB_AspectJ_PCW state,
                                                                Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doWorkLoggerOff1("1", blackhole::consume));
    }

    @Benchmark
    public void
            Spring_Java_Nothing12345_CGLIB_AspectJ_PCW_After(StateSpring_CGLIB_AspectJ_PCW_After state,
                                                             Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing12345("1", blackhole::consume));
    }

    @Benchmark
    public void
            Spring_Java_Nothing12345_CGLIB_AspectJ_PCW_AfterReturning(StateSpring_CGLIB_AspectJ_PCW_AfterReturning state,
                                                                      Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing12345("1", blackhole::consume));
    }

    @Benchmark
    public void
            Spring_Java_Nothing12345_CGLIB_AspectJ_PCW_AfterReturningNoJoinPoint(StateSpring_CGLIB_AspectJ_PCW_AfterReturningNoJoinPoint state,
                                                                                 Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing12345("1", blackhole::consume));
    }

    @Benchmark
    public void
            Spring_Java_Nothing12345_CGLIB_AspectJ_PCW_Around(StateSpring_CGLIB_AspectJ_PCW state,
                                                              Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing12345("1", blackhole::consume));
    }

    @Benchmark
    public void
            Spring_Java_Nothing12345_CGLIB_AspectJ_PCW_Before(StateSpring_CGLIB_AspectJ_PCW_Before state,
                                                              Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing12345("1", blackhole::consume));
    }

    @Benchmark
    public void
            Spring_Java_Nothing12345_CGLIB_AspectJ_PCW_BeforeAfterPointcut(StateSpring_CGLIB_AspectJ_PCW_BeforeAfterPointcut state,
                                                                           Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing12345("1", blackhole::consume));
    }

    @Benchmark
    public void
            Spring_Java_Nothing12345_CGLIB_AspectJ_PCW_BeforeAfterReturningPointcut(StateSpring_CGLIB_AspectJ_PCW_BeforeAfterReturningPointcut state,
                                                                                    Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing12345("1", blackhole::consume));
    }

    @Benchmark
    public void
            Spring_Java_Nothing12345_CGLIB_AspectJ_PCW_BeforeNoJoinPoint(StateSpring_CGLIB_AspectJ_PCW_BeforeNoJoinPoint state,
                                                                         Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing12345("1", blackhole::consume));
    }

    @Benchmark
    public void
            Spring_Java_Nothing12345_CGLIB_AspectJ_PCW_BeforeNoJoinPointThenAfterNoJoinPoint(StateSpring_CGLIB_AspectJ_PCW_BeforeNoJoinPointThenAfterNoJoinPoint state,
                                                                                             Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing12345("1", blackhole::consume));
    }

    @Benchmark
    public void
            Spring_Java_Nothing12345_CGLIB_AspectJ_PCW_BeforeNoJoinPointThenAfterReturningNoJoinPoint(StateSpring_CGLIB_AspectJ_PCW_BeforeNoJoinPointThenAfterReturningNoJoinPoint state,
                                                                                                      Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing12345("1", blackhole::consume));
    }

    @Benchmark
    public void
            Spring_Java_Nothing12345_CGLIB_AspectJ_PCW_BeforeThenAfter(StateSpring_CGLIB_AspectJ_PCW_BeforeThenAfter state,
                                                                       Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing12345("1", blackhole::consume));
    }

    @Benchmark
    public void
            Spring_Java_Nothing12345_CGLIB_AspectJ_PCW_BeforeThenAfterReturning(StateSpring_CGLIB_AspectJ_PCW_BeforeThenAfterReturning state,
                                                                                Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing12345("1", blackhole::consume));
    }

    @Benchmark
    public void
            Spring_Java_Nothing12345_CGLIB_AspectJ_PCW_BeforeThenAfterReturningNoJoinPoint(StateSpring_CGLIB_AspectJ_PCW_BeforeThenAfterReturningNoJoinPoint state,
                                                                                           Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing12345("1", blackhole::consume));
    }

    // Spring AspectJ_CGLIB_PCW After
    @Benchmark
    public void
            Spring_Java_Nothing1_CGLIB_AspectJ_PCW_After(StateSpring_CGLIB_AspectJ_PCW_After state,
                                                         Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing1("1", blackhole::consume));
    }

    // Spring AspectJ_CGLIB_PCW AfterNoJoinPoint
    @Benchmark
    public void
            Spring_Java_Nothing1_CGLIB_AspectJ_PCW_AfterNoJoinPoint(StateSpring_CGLIB_AspectJ_PCW_AfterNoJoinPoint state,
                                                                    Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing1("1", blackhole::consume));
    }

    // Spring AspectJ_CGLIB_PCW AfterReturning
    @Benchmark
    public void
            Spring_Java_Nothing1_CGLIB_AspectJ_PCW_AfterReturning(StateSpring_CGLIB_AspectJ_PCW_AfterReturning state,
                                                                  Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing1("1", blackhole::consume));
    }

    // Spring AspectJ_CGLIB_PCW AfterReturningNoJoinPoint
    @Benchmark
    public void
            Spring_Java_Nothing1_CGLIB_AspectJ_PCW_AfterReturningNoJoinPoint(StateSpring_CGLIB_AspectJ_PCW_AfterReturningNoJoinPoint state,
                                                                             Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing1("1", blackhole::consume));
    }

    // Spring AspectJ_CGLIB_PCW Around
    @Benchmark
    public void Spring_Java_Nothing1_CGLIB_AspectJ_PCW_Around(StateSpring_CGLIB_AspectJ_PCW state,
                                                              Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing1("1", blackhole::consume));
    }

    // Spring AspectJ_CGLIB_PCW Before
    @Benchmark
    public void
            Spring_Java_Nothing1_CGLIB_AspectJ_PCW_Before(StateSpring_CGLIB_AspectJ_PCW_Before state,
                                                          Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing1("1", blackhole::consume));
    }

    // Spring AspectJ_CGLIB_PCW BeforeAfterPointcut
    @Benchmark
    public void
            Spring_Java_Nothing1_CGLIB_AspectJ_PCW_BeforeAfterPointcut(StateSpring_CGLIB_AspectJ_PCW_BeforeAfterPointcut state,
                                                                       Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing1("1", blackhole::consume));
    }

    // Spring AspectJ_CGLIB_PCW BeforeAfterReturningPointcut
    @Benchmark
    public void
            Spring_Java_Nothing1_CGLIB_AspectJ_PCW_BeforeAfterReturningPointcut(StateSpring_CGLIB_AspectJ_PCW_BeforeAfterReturningPointcut state,
                                                                                Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing1("1", blackhole::consume));
    }

    // Spring AspectJ_CGLIB_PCW BeforeNoJoinPoint
    @Benchmark
    public void
            Spring_Java_Nothing1_CGLIB_AspectJ_PCW_BeforeNoJoinPoint(StateSpring_CGLIB_AspectJ_PCW_BeforeNoJoinPoint state,
                                                                     Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing1("1", blackhole::consume));
    }

    // Spring AspectJ_CGLIB_PCW BeforeNoJoinPointThenAfterNoJoinPoint
    @Benchmark
    public void
            Spring_Java_Nothing1_CGLIB_AspectJ_PCW_BeforeNoJoinPointThenAfterNoJoinPoint(StateSpring_CGLIB_AspectJ_PCW_BeforeNoJoinPointThenAfterNoJoinPoint state,
                                                                                         Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing1("1", blackhole::consume));
    }

    // Spring AspectJ_CGLIB_PCW BeforeNoJoinPointThenAfterReturningNoJoinPoint
    @Benchmark
    public void
            Spring_Java_Nothing1_CGLIB_AspectJ_PCW_BeforeNoJoinPointThenAfterReturningNoJoinPoint(StateSpring_CGLIB_AspectJ_PCW_BeforeNoJoinPointThenAfterReturningNoJoinPoint state,
                                                                                                  Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing1("1", blackhole::consume));
    }

    // Spring AspectJ_CGLIB_PCW BeforeThenAfter
    @Benchmark
    public void
            Spring_Java_Nothing1_CGLIB_AspectJ_PCW_BeforeThenAfter(StateSpring_CGLIB_AspectJ_PCW_BeforeThenAfter state,
                                                                   Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing1("1", blackhole::consume));
    }

    // Spring AspectJ_CGLIB_PCW BeforeThenAfterReturning
    @Benchmark
    public void
            Spring_Java_Nothing1_CGLIB_AspectJ_PCW_BeforeThenAfterReturning(StateSpring_CGLIB_AspectJ_PCW_BeforeThenAfterReturning state,
                                                                            Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing1("1", blackhole::consume));
    }

    // Spring AspectJ_CGLIB_PCW BeforeThenAfterReturningNoJoinPoint
    @Benchmark
    public void
            Spring_Java_Nothing1_CGLIB_AspectJ_PCW_BeforeThenAfterReturningNoJoinPoint(StateSpring_CGLIB_AspectJ_PCW_BeforeThenAfterReturningNoJoinPoint state,
                                                                                       Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing1("1", blackhole::consume));
    }
}
