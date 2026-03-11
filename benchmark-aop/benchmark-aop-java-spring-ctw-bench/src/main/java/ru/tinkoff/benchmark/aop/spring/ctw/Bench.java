package ru.tinkoff.benchmark.aop.spring.ctw;

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
    public static class StateSpring_CGLIB_AspectJ_CTW {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            springContext = SpringApplication.run(SpringApplication_CGLIB_AspectJ_CTW.class);
            aspectEmulator = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    springContext.getAutowireCapableBeanFactory(), AspectEmulator.class, "Around");

            System.out.println(
                    "\nState - " + StateSpring_CGLIB_AspectJ_CTW.class.getSimpleName() + ", AspectEmulator - "
                            + aspectEmulator.getClass());
            System.out.println("\n\nWARMUP");
            System.out.print("# Warmup Iteration   1: "); // Otherwise output is broken and parse script won't parse this mess
        }
    }

    @State(Scope.Benchmark)
    public static class StateSpring_CGLIB_AspectJ_CTW_After {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            springContext = SpringApplication.run(SpringApplication_CGLIB_AspectJ_CTW.class);
            aspectEmulator = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    springContext.getAutowireCapableBeanFactory(), AspectEmulator.class, "After");

            System.out.println(
                    "\nState - " + StateSpring_CGLIB_AspectJ_CTW.class.getSimpleName() + ", AspectEmulator - "
                            + aspectEmulator.getClass());
            System.out.println("\n\nWARMUP");
            System.out.print("# Warmup Iteration   1: "); // Otherwise output is broken and parse script won't parse this mess
        }
    }

    @State(Scope.Benchmark)
    public static class StateSpring_CGLIB_AspectJ_CTW_AfterNoJoinPoint {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            springContext = SpringApplication.run(SpringApplication_CGLIB_AspectJ_CTW.class);
            aspectEmulator = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    springContext.getAutowireCapableBeanFactory(), AspectEmulator.class, "AfterNoJoinPoint");

            System.out.println(
                    "\nState - " + StateSpring_CGLIB_AspectJ_CTW.class.getSimpleName() + ", AspectEmulator - "
                            + aspectEmulator.getClass());
            System.out.println("\n\nWARMUP");
            System.out.print("# Warmup Iteration   1: "); // Otherwise output is broken and parse script won't parse this mess
        }
    }

    @State(Scope.Benchmark)
    public static class StateSpring_CGLIB_AspectJ_CTW_AfterReturning {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            springContext = SpringApplication.run(SpringApplication_CGLIB_AspectJ_CTW.class);
            aspectEmulator = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    springContext.getAutowireCapableBeanFactory(), AspectEmulator.class, "AfterReturning");

            System.out.println(
                    "\nState - " + StateSpring_CGLIB_AspectJ_CTW.class.getSimpleName() + ", AspectEmulator - "
                            + aspectEmulator.getClass());
            System.out.println("\n\nWARMUP");
            System.out.print("# Warmup Iteration   1: "); // Otherwise output is broken and parse script won't parse this mess
        }
    }

    @State(Scope.Benchmark)
    public static class StateSpring_CGLIB_AspectJ_CTW_AfterReturningNoJoinPoint {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            springContext = SpringApplication.run(SpringApplication_CGLIB_AspectJ_CTW.class);
            aspectEmulator = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    springContext.getAutowireCapableBeanFactory(), AspectEmulator.class, "AfterReturningNoJoinPoint");

            System.out.println(
                    "\nState - " + StateSpring_CGLIB_AspectJ_CTW.class.getSimpleName() + ", AspectEmulator - "
                            + aspectEmulator.getClass());
            System.out.println("\n\nWARMUP");
            System.out.print("# Warmup Iteration   1: "); // Otherwise output is broken and parse script won't parse this mess
        }
    }

    @State(Scope.Benchmark)
    public static class StateSpring_CGLIB_AspectJ_CTW_Before {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            springContext = SpringApplication.run(SpringApplication_CGLIB_AspectJ_CTW.class);
            aspectEmulator = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    springContext.getAutowireCapableBeanFactory(), AspectEmulator.class, "Before");

            System.out.println(
                    "\nState - " + StateSpring_CGLIB_AspectJ_CTW.class.getSimpleName() + ", AspectEmulator - "
                            + aspectEmulator.getClass());
            System.out.println("\n\nWARMUP");
            System.out.print("# Warmup Iteration   1: "); // Otherwise output is broken and parse script won't parse this mess
        }
    }

    @State(Scope.Benchmark)
    public static class StateSpring_CGLIB_AspectJ_CTW_BeforeAfterPointcut {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            springContext = SpringApplication.run(SpringApplication_CGLIB_AspectJ_CTW.class);
            aspectEmulator = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    springContext.getAutowireCapableBeanFactory(), AspectEmulator.class, "BeforeAfterPointcut");

            System.out.println(
                    "\nState - " + StateSpring_CGLIB_AspectJ_CTW.class.getSimpleName() + ", AspectEmulator - "
                            + aspectEmulator.getClass());
            System.out.println("\n\nWARMUP");
            System.out.print("# Warmup Iteration   1: "); // Otherwise output is broken and parse script won't parse this mess
        }
    }

    @State(Scope.Benchmark)
    public static class StateSpring_CGLIB_AspectJ_CTW_BeforeAfterReturningPointcut {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            springContext = SpringApplication.run(SpringApplication_CGLIB_AspectJ_CTW.class);
            aspectEmulator = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    springContext.getAutowireCapableBeanFactory(), AspectEmulator.class, "BeforeAfterReturningPointcut");

            System.out.println(
                    "\nState - " + StateSpring_CGLIB_AspectJ_CTW.class.getSimpleName() + ", AspectEmulator - "
                            + aspectEmulator.getClass());
            System.out.println("\n\nWARMUP");
            System.out.print("# Warmup Iteration   1: "); // Otherwise output is broken and parse script won't parse this mess
        }
    }

    @State(Scope.Benchmark)
    public static class StateSpring_CGLIB_AspectJ_CTW_BeforeNoJoinPoint {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            springContext = SpringApplication.run(SpringApplication_CGLIB_AspectJ_CTW.class);
            aspectEmulator = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    springContext.getAutowireCapableBeanFactory(), AspectEmulator.class, "BeforeNoJoinPoint");

            System.out.println(
                    "\nState - " + StateSpring_CGLIB_AspectJ_CTW.class.getSimpleName() + ", AspectEmulator - "
                            + aspectEmulator.getClass());
            System.out.println("\n\nWARMUP");
            System.out.print("# Warmup Iteration   1: "); // Otherwise output is broken and parse script won't parse this mess
        }
    }

    @State(Scope.Benchmark)
    public static class StateSpring_CGLIB_AspectJ_CTW_BeforeThenAfter {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            springContext = SpringApplication.run(SpringApplication_CGLIB_AspectJ_CTW.class);
            aspectEmulator = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    springContext.getAutowireCapableBeanFactory(), AspectEmulator.class, "BeforeThenAfter");

            System.out.println(
                    "\nState - " + StateSpring_CGLIB_AspectJ_CTW.class.getSimpleName() + ", AspectEmulator - "
                            + aspectEmulator.getClass());
            System.out.println("\n\nWARMUP");
            System.out.print("# Warmup Iteration   1: "); // Otherwise output is broken and parse script won't parse this mess
        }
    }

    @State(Scope.Benchmark)
    public static class StateSpring_CGLIB_AspectJ_CTW_BeforeThenAfterNoJoinPoint {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            springContext = SpringApplication.run(SpringApplication_CGLIB_AspectJ_CTW.class);
            aspectEmulator = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    springContext.getAutowireCapableBeanFactory(), AspectEmulator.class, "BeforeThenAfterNoJoinPoint");

            System.out.println(
                    "\nState - " + StateSpring_CGLIB_AspectJ_CTW.class.getSimpleName() + ", AspectEmulator - "
                            + aspectEmulator.getClass());
            System.out.println("\n\nWARMUP");
            System.out.print("# Warmup Iteration   1: "); // Otherwise output is broken and parse script won't parse this mess
        }
    }

    @State(Scope.Benchmark)
    public static class StateSpring_CGLIB_AspectJ_CTW_BeforeThenAfterReturning {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            springContext = SpringApplication.run(SpringApplication_CGLIB_AspectJ_CTW.class);
            aspectEmulator = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    springContext.getAutowireCapableBeanFactory(), AspectEmulator.class, "BeforeThenAfterReturning");

            System.out.println(
                    "\nState - " + StateSpring_CGLIB_AspectJ_CTW.class.getSimpleName() + ", AspectEmulator - "
                            + aspectEmulator.getClass());
            System.out.println("\n\nWARMUP");
            System.out.print("# Warmup Iteration   1: "); // Otherwise output is broken and parse script won't parse this mess
        }
    }

    @State(Scope.Benchmark)
    public static class StateSpring_CGLIB_AspectJ_CTW_BeforeThenAfterReturningNoJoinPoint {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            springContext = SpringApplication.run(SpringApplication_CGLIB_AspectJ_CTW.class);
            aspectEmulator = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    springContext.getAutowireCapableBeanFactory(), AspectEmulator.class, "BeforeThenAfterReturningNoJoinPoint");

            System.out.println(
                    "\nState - " + StateSpring_CGLIB_AspectJ_CTW.class.getSimpleName() + ", AspectEmulator - "
                            + aspectEmulator.getClass());
            System.out.println("\n\nWARMUP");
            System.out.print("# Warmup Iteration   1: "); // Otherwise output is broken and parse script won't parse this mess
        }
    }

    @State(Scope.Benchmark)
    public static class StateSpring_JdkDynamic_AspectJ_CTW {

        AspectEmulator aspectEmulator;
        ConfigurableApplicationContext springContext;

        @TearDown
        public void cleanup() {
            springContext.close();
        }

        @Setup
        public void setup() {
            springContext = SpringApplication.run(SpringApplication_JdkDynamic_AspectJ_CTW.class);
            aspectEmulator = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    springContext.getAutowireCapableBeanFactory(), AspectEmulator.class, "Around");

            System.out.println(
                    "\nState - " + StateSpring_JdkDynamic_AspectJ_CTW.class.getSimpleName() + ", AspectEmulator - "
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
            Spring_Java_Nothing12345_CGLIB_AspectJ_CTW_Around(StateSpring_CGLIB_AspectJ_CTW state,
                                                              Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing12345("1", blackhole::consume));
    }

    @Benchmark
    public void
            Spring_Java_Nothing12345_CGLIB_AspectJ_CTW_BeforeThenAfterNoJoinPoint(StateSpring_CGLIB_AspectJ_CTW_BeforeThenAfterNoJoinPoint state,
                                                                                  Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing12345("1", blackhole::consume));
    }

    @Benchmark
    public void
            Spring_Java_Nothing12345_CGLIB_AspectJ_CTW_BeforeThenAfterReturningNoJoinPoint(StateSpring_CGLIB_AspectJ_CTW_BeforeThenAfterReturningNoJoinPoint state,
                                                                                           Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing12345("1", blackhole::consume));
    }

    @Benchmark
    public void
            Spring_Java_Nothing12345_CGLIB_CTW_Before(StateSpring_CGLIB_AspectJ_CTW_Before state,
                                                      Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing12345("1", blackhole::consume));
    }

    @Benchmark
    public void
            Spring_Java_Nothing12345_CGLIB_CTW_BeforeNoJoinPoint(StateSpring_CGLIB_AspectJ_CTW_BeforeNoJoinPoint state,
                                                                 Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing12345("1", blackhole::consume));
    }

    // Spring AspectJ_CGLIB_CTW Around
    @Benchmark
    public void Spring_Java_Nothing1_CGLIB_AspectJ_CTW_Around(StateSpring_CGLIB_AspectJ_CTW state,
                                                              Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing1("1", blackhole::consume));
    }

    // Spring AspectJ_CGLIB_CTW BeforeThenAfterNoJoinPoint
    @Benchmark
    public void
            Spring_Java_Nothing1_CGLIB_AspectJ_CTW_BeforeThenAfterNoJoinPoint(StateSpring_CGLIB_AspectJ_CTW_BeforeThenAfterNoJoinPoint state,
                                                                              Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing1("1", blackhole::consume));
    }

    // Spring AspectJ_CGLIB_CTW BeforeThenAfterReturningNoJoinPoint
    @Benchmark
    public void
            Spring_Java_Nothing1_CGLIB_AspectJ_CTW_BeforeThenAfterReturningNoJoinPoint(StateSpring_CGLIB_AspectJ_CTW_BeforeThenAfterReturningNoJoinPoint state,
                                                                                       Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing1("1", blackhole::consume));
    }

    // Spring CGLIB_CTW Before
    @Benchmark
    public void Spring_Java_Nothing1_CGLIB_CTW_Before(StateSpring_CGLIB_AspectJ_CTW_Before state,
                                                      Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing1("1", blackhole::consume));
    }

    // Spring CGLIB_CTW BeforeNoJoinPoint
    @Benchmark
    public void
            Spring_Java_Nothing1_CGLIB_CTW_BeforeNoJoinPoint(StateSpring_CGLIB_AspectJ_CTW_BeforeNoJoinPoint state,
                                                             Blackhole blackhole) {
        blackhole.consume(state.aspectEmulator.doNothing1("1", blackhole::consume));
    }
}
