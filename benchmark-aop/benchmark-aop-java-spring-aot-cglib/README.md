# Spring AOT + CGLIB

Spring AOT (Ahead-of-Time) Compilation is a feature introduced in Spring Framework 6 and Spring Boot 3,
aimed at improving application startup performance by pre-processing and generating code at build time rather than at runtime.

With the introduction of GraalVM Native Image support in Spring, AOT compilation plays a key role in preparing
Spring applications for native compilation, where Java code is compiled into a standalone executable binary.

Spring AOT generates CGLIB-style proxies at compile time as a startup optimization, 
replacing the runtime proxy generation normally done by Spring using CGLIB.

## Measurements

```text
REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.

NOTE: Current JVM experimentally supports Compiler Blackholes, and they are in use. Please exercise
extra caution when trusting the results, look into the generated code to check the benchmark still
works, and factor in a small probability of new VM bugs. Additionally, while comparisons between
different JVMs are already problematic, the performance difference caused by different Blackhole
modes can be very significant. Please make sure you use the consistent Blackhole mode for comparisons.

# JMH version: 1.37
# VM version: JDK 25, OpenJDK 64-Bit Server VM, 25+36-LTS
# VM invoker: /Users/ak/Library/Java/JavaVirtualMachines/temurin-25/Contents/Home/bin/java
# VM options: -Dbenchmark.type=measurement -XX:+AlwaysPreTouch -XX:InitialCodeCacheSize=256M -XX:ReservedCodeCacheSize=1024M -XX:+UseCodeCacheFlushing -XX:MaxInlineSize=1024 -XX:FreqInlineSize=1024 -XX:CompileThreshold=15000 -XX:CICompilerCount=4 -XX:-TieredCompilation -XX:+UseG1GC -Xms3048M -Xmx3048M -Dfile.encoding=UTF-8 -Duser.country=RU -Duser.language=ru -Duser.variant
# Blackhole mode: compiler (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 3 iterations, 20 s each
# Measurement: 6 iterations, 5 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Forks: 2
```

```text
Benchmark                                           Mode  Cnt        Score       Error  Units
Bench.Spring_Java_Nothing12345_CGLIB_AOT_Around    thrpt   12   234538,714 ±  3890,431  ops/s
Bench.Spring_Java_Nothing1_CGLIB_AOT_Around        thrpt   12  1143212,225 ± 17274,311  ops/s
```

## Полезные материалы:

Ссылки:
- [Medium Spring AOP](https://medium.com/@ankithahjpgowda/what-is--oriented-programming-aop-in-spring-e7a845d904e)
- [Spring Proxy](https://docs.spring.io/spring-framework/reference/core/aop/proxying.html)
- [CGLIB](https://www.baeldung.com/cglib)
- [Spring AOT](https://docs.spring.io/spring-framework/reference/core/aot.html)
- https://github.com/spring-projects/spring-framework/issues/28943
- https://github.com/spring-projects/spring-framework/issues/28954
- https://github.com/spring-projects/spring-framework/commit/9a1b7c5e47c8ea56ad9b91c5f3ba87eda9d9d7c9
- https://github.com/spring-projects/spring-framework/issues/31238
- https://github.com/spring-projects/spring-framework/blob/801035bea7a1af21c12c3bf993085a2f373e3bfe/spring-core/src/main/java/org/springframework/cglib/reflect/FastClassEmitter.java
- https://github.com/spring-projects/spring-framework/blob/a08a4d60685a7a8b6fd4a086c2ef64a3cf4a69ed/spring-core/src/main/java/org/springframework/cglib/reflect/FastClass.java#L85
- https://github.com/search?q=repo%3Aspring-projects%2Fspring-framework%20FastClass&type=code
- https://github.com/spring-projects/spring-framework/blob/a08a4d60685a7a8b6fd4a086c2ef64a3cf4a69ed/spring-context/src/test/java/org/springframework/context/aot/ApplicationContextAotGeneratorTests.java#L513
- https://github.com/search?q=repo%3Aspring-projects%2Fspring-framework%20%24%24FastClass&type=code
- https://github.com/spring-projects/spring-framework/blob/a08a4d60685a7a8b6fd4a086c2ef64a3cf4a69ed/spring-context/src/main/java/org/springframework/context/annotation/ConfigurationClassEnhancer.java#L78
- https://github.com/spring-projects/spring-framework/blob/a08a4d60685a7a8b6fd4a086c2ef64a3cf4a69ed/spring-context/src/main/java/org/springframework/context/annotation/ConfigurationClassUtils.java#L93
- https://github.com/spring-projects/spring-framework/blob/a08a4d60685a7a8b6fd4a086c2ef64a3cf4a69ed/spring-context/src/main/java/org/springframework/context/annotation/ConfigurationClassPostProcessor.java#L338