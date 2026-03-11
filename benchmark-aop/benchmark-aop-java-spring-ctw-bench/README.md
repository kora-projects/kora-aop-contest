# AspectJ CTW - Compile Time Weaving

Compile Time Weaving requires to separate code and bench due to errors
when annotation processing JMH and compiling separately AspectJ, 
this may come an issue at any codebase with some complex compiling or annotation processing.

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
Benchmark                                                 Mode  Cnt         Score        Error  Units
Bench.Spring_Java_Nothing12345_CGLIB_AspectJ_CTW_Around  thrpt   12   2787630,445 ± 153193,143  ops/s
Bench.Spring_Java_Nothing1_CGLIB_AspectJ_CTW_Around      thrpt   12  46467440,926 ± 428453,365  ops/s
```

## Полезные материалы:

Ссылки:
- [Medium Spring AOP](https://medium.com/@ankithahjpgowda/what-is--oriented-programming-aop-in-spring-e7a845d904e)
- [Spring Proxy](https://docs.spring.io/spring-framework/reference/core/aop/proxying.html)
- [JdkDynamic](https://medium.com/@spac.valentin/java-dynamic-proxy-mechanism-and-how-spring-is-using-it-93756fc707d5)
- [CGLIB](https://www.baeldung.com/cglib)
- [Freefair AspectJ Gradle Plugin](https://docs.freefair.io/gradle-plugins/current/reference/#_compile_time_weaving)
- [AJC Compile Options](https://eclipse.dev/aspectj/doc/latest/devguide/ajc.html#ajc_options:~:text=%2DxmlConfigured%20%3Cfiles%3E)
- [GitHub example](https://github.com/AkaZver/spring-aop-with-aspectj-pcw)
