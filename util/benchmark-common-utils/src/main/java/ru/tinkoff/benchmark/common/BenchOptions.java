package ru.tinkoff.benchmark.common;

import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.options.ChainedOptionsBuilder;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

public final class BenchOptions {

    public enum BenchMeasureType {
        CONCURRENT,
        PROFILE,
        STANDARD,
        TEST,
    }

    public enum BenchWarmType {
        PRECISE,
        STANDARD
    }

    public static final int FORKS_MEASURE = 1;
    public static final int FORKS_WARMUP = 1;
    // Settings
    public static final Mode MODE = Mode.Throughput;
    public static final int THREADS_CONCURRENT = Math.max(Runtime.getRuntime().availableProcessors() / 2, 1); // cores/2 or 1
    public static final int THREADS_SINGLE = 1;

    private BenchOptions() {}

    public static ChainedOptionsBuilder getMeasureConcurrentOptions(Class<?> bench) {
        // Warmup
        final int WARMUP_ITERATIONS = 8;
        final TimeValue WARMUP_TIME = TimeValue.seconds(5);

        // Measure
        final int MEASUREMENT_ITERATIONS = 6;
        final TimeValue MEASUREMENT_TIME = TimeValue.seconds(5);

        return new OptionsBuilder()
                .include(bench.getSimpleName())
                .mode(MODE)
                .forks(FORKS_MEASURE)
                .threads(THREADS_CONCURRENT)
                .syncIterations(false)
                .shouldDoGC(true)
                .warmupIterations(WARMUP_ITERATIONS)
                .warmupTime(WARMUP_TIME)
                .measurementIterations(MEASUREMENT_ITERATIONS)
                .measurementTime(MEASUREMENT_TIME);
    }

    public static ChainedOptionsBuilder getMeasureOptions(Class<?> bench) {
        // Warmup
        final int WARMUP_ITERATIONS = 3;
        final TimeValue WARMUP_TIME = TimeValue.seconds(20);

        // Measure
        final int MEASUREMENT_ITERATIONS = 6;
        final TimeValue MEASUREMENT_TIME = TimeValue.seconds(5);

        return new OptionsBuilder()
                .include(bench.getSimpleName())
                .mode(MODE)
                .forks(FORKS_MEASURE)
                .threads(THREADS_SINGLE)
                .shouldDoGC(true)
                .resultFormat(ResultFormatType.CSV)
                .warmupIterations(WARMUP_ITERATIONS)
                .warmupTime(WARMUP_TIME)
                .measurementIterations(MEASUREMENT_ITERATIONS)
                .measurementTime(MEASUREMENT_TIME);
    }

    public static ChainedOptionsBuilder getMeasureProfileOptions(Class<?> bench) {
        // Warmup
        final int WARMUP_ITERATIONS = 8;
        final TimeValue WARMUP_TIME = TimeValue.seconds(5);

        // Measure
        final int MEASUREMENT_ITERATIONS = 8;
        final TimeValue MEASUREMENT_TIME = TimeValue.seconds(5);

        return new OptionsBuilder()
                .include(bench.getSimpleName())
                .mode(MODE)
                .forks(0)
                .threads(THREADS_SINGLE)
                .syncIterations(false)
                .shouldDoGC(true)
                .warmupIterations(WARMUP_ITERATIONS)
                .warmupTime(WARMUP_TIME)
                .measurementIterations(MEASUREMENT_ITERATIONS)
                .measurementTime(MEASUREMENT_TIME);
    }

    public static ChainedOptionsBuilder getOptions(Class<?> bench, BenchWarmType warmType, BenchMeasureType measureType) {
        String benchType = System.getProperty("benchmark.type");
        if ("warmup".equals(benchType)) {
            return switch (warmType) {
                case STANDARD -> getWarmupOptions(bench);
                case PRECISE -> getWarmupPreciseOptions(bench);
            };
        } else {
            return switch (measureType) {
                case TEST -> getTestOptions(bench);
                case STANDARD -> getMeasureOptions(bench);
                case CONCURRENT -> getMeasureConcurrentOptions(bench);
                case PROFILE -> getMeasureProfileOptions(bench);
            };
        }
    }

    public static ChainedOptionsBuilder getTestOptions(Class<?> bench) {
        // Warmup
        final int WARMUP_ITERATIONS = 1;
        final TimeValue WARMUP_TIME = TimeValue.milliseconds(50);

        // Measure
        final int MEASUREMENT_ITERATIONS = 1;
        final TimeValue MEASUREMENT_TIME = TimeValue.milliseconds(50);

        return new OptionsBuilder()
                .include(bench.getSimpleName())
                .mode(MODE)
                .forks(1)
                .threads(1)
                .shouldFailOnError(true)
                .resultFormat(ResultFormatType.CSV)
                .warmupIterations(WARMUP_ITERATIONS)
                .warmupTime(WARMUP_TIME)
                .measurementIterations(MEASUREMENT_ITERATIONS)
                .measurementTime(MEASUREMENT_TIME);
    }

    public static ChainedOptionsBuilder getWarmupOptions(Class<?> bench) {
        final int WARMUP_ITERATIONS = 200;
        final TimeValue WARMUP_TIME = TimeValue.milliseconds(15);

        final int MEASUREMENT_ITERATIONS = 2;
        final TimeValue MEASUREMENT_TIME = TimeValue.milliseconds(200);

        return new OptionsBuilder()
                .include(bench.getSimpleName())
                .mode(MODE)
                .forks(FORKS_WARMUP)
                .threads(THREADS_SINGLE)
                .shouldDoGC(true)
                .warmupIterations(WARMUP_ITERATIONS)
                .warmupTime(WARMUP_TIME)
                .measurementIterations(MEASUREMENT_ITERATIONS)
                .measurementTime(MEASUREMENT_TIME);
    }

    public static ChainedOptionsBuilder getWarmupPreciseOptions(Class<?> bench) {
        final int WARMUP_ITERATIONS = 200;
        final TimeValue WARMUP_TIME = TimeValue.milliseconds(10);

        final int MEASUREMENT_ITERATIONS = 2;
        final TimeValue MEASUREMENT_TIME = TimeValue.milliseconds(200);

        return new OptionsBuilder()
                .include(bench.getSimpleName())
                .mode(MODE)
                .forks(FORKS_WARMUP)
                .threads(THREADS_SINGLE)
                .shouldDoGC(true)
                .warmupIterations(WARMUP_ITERATIONS)
                .warmupTime(WARMUP_TIME)
                .measurementIterations(MEASUREMENT_ITERATIONS)
                .measurementTime(MEASUREMENT_TIME);
    }
}
