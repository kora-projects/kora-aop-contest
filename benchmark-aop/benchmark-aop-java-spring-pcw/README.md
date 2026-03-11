# AspectJ PCW - Post Compile Weaving

Post-compile Weaving (PCW) in AspectJ is a technique used to weave aspects into already 
compiled bytecode ( .class  files or JARs), without requiring access to the original source code. 
This approach is especially useful when applying cross-cutting concerns to third-party libraries or when weaving needs to be performed separately from the main build process.

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
Benchmark                                                                                         Mode  Cnt          Score         Error  Units
Bench.Spring_Java_LoggerOff12345_CGLIB_AspectJ_PCW_Around                                        thrpt   12    2284701,424 ±  202442,311  ops/s
Bench.Spring_Java_LoggerOff1_CGLIB_AspectJ_PCW_Around                                            thrpt   12   14588070,826 ±  450605,864  ops/s
Bench.Spring_Java_Nothing12345_CGLIB_AspectJ_PCW_After                                           thrpt   12    7215170,049 ±  818723,650  ops/s
Bench.Spring_Java_Nothing12345_CGLIB_AspectJ_PCW_AfterReturning                                  thrpt   12    7415032,775 ± 1069504,074  ops/s
Bench.Spring_Java_Nothing12345_CGLIB_AspectJ_PCW_AfterReturningNoJoinPoint                       thrpt   12   34974758,000 ±  274302,522  ops/s
Bench.Spring_Java_Nothing12345_CGLIB_AspectJ_PCW_Around                                          thrpt   12    2797133,846 ±  202239,732  ops/s
Bench.Spring_Java_Nothing12345_CGLIB_AspectJ_PCW_Before                                          thrpt   12    7157657,501 ±  582054,274  ops/s
Bench.Spring_Java_Nothing12345_CGLIB_AspectJ_PCW_BeforeAfterPointcut                             thrpt   12    4385208,594 ±  410457,474  ops/s
Bench.Spring_Java_Nothing12345_CGLIB_AspectJ_PCW_BeforeAfterReturningPointcut                    thrpt   12    4436664,067 ±  392879,882  ops/s
Bench.Spring_Java_Nothing12345_CGLIB_AspectJ_PCW_BeforeNoJoinPoint                               thrpt   12   34962545,077 ±  348250,381  ops/s
Bench.Spring_Java_Nothing12345_CGLIB_AspectJ_PCW_BeforeNoJoinPointThenAfterNoJoinPoint           thrpt   12   18514285,745 ±  129990,227  ops/s
Bench.Spring_Java_Nothing12345_CGLIB_AspectJ_PCW_BeforeNoJoinPointThenAfterReturningNoJoinPoint  thrpt   12   18494343,668 ±  145860,143  ops/s
Bench.Spring_Java_Nothing12345_CGLIB_AspectJ_PCW_BeforeThenAfter                                 thrpt   12    4512994,726 ±  362424,093  ops/s
Bench.Spring_Java_Nothing12345_CGLIB_AspectJ_PCW_BeforeThenAfterReturning                        thrpt   12    4466649,520 ±  319731,369  ops/s
Bench.Spring_Java_Nothing12345_CGLIB_AspectJ_PCW_BeforeThenAfterReturningNoJoinPoint             thrpt   12    4970930,338 ±  305342,671  ops/s
Bench.Spring_Java_Nothing1_CGLIB_AspectJ_PCW_After                                               thrpt   12   54404617,814 ±  439095,711  ops/s
Bench.Spring_Java_Nothing1_CGLIB_AspectJ_PCW_AfterNoJoinPoint                                    thrpt   12  156895056,317 ± 2344033,737  ops/s
Bench.Spring_Java_Nothing1_CGLIB_AspectJ_PCW_AfterReturning                                      thrpt   12   55566789,542 ±  506882,616  ops/s
Bench.Spring_Java_Nothing1_CGLIB_AspectJ_PCW_AfterReturningNoJoinPoint                           thrpt   12  157218029,841 ± 1223711,206  ops/s
Bench.Spring_Java_Nothing1_CGLIB_AspectJ_PCW_Around                                              thrpt   12   46032299,449 ±  742030,793  ops/s
Bench.Spring_Java_Nothing1_CGLIB_AspectJ_PCW_Before                                              thrpt   12   52663015,657 ± 3319274,109  ops/s
Bench.Spring_Java_Nothing1_CGLIB_AspectJ_PCW_BeforeAfterPointcut                                 thrpt   12   19718630,754 ±  455042,739  ops/s
Bench.Spring_Java_Nothing1_CGLIB_AspectJ_PCW_BeforeAfterReturningPointcut                        thrpt   12   20019074,326 ±  307084,163  ops/s
Bench.Spring_Java_Nothing1_CGLIB_AspectJ_PCW_BeforeNoJoinPoint                                   thrpt   12  158890515,191 ± 1331964,791  ops/s
Bench.Spring_Java_Nothing1_CGLIB_AspectJ_PCW_BeforeNoJoinPointThenAfterNoJoinPoint               thrpt   12   74783159,073 ± 1168639,955  ops/s
Bench.Spring_Java_Nothing1_CGLIB_AspectJ_PCW_BeforeNoJoinPointThenAfterReturningNoJoinPoint      thrpt   12   74498398,492 ± 1417132,455  ops/s
Bench.Spring_Java_Nothing1_CGLIB_AspectJ_PCW_BeforeThenAfter                                     thrpt   12   18872919,434 ±  664878,861  ops/s
Bench.Spring_Java_Nothing1_CGLIB_AspectJ_PCW_BeforeThenAfterReturning                            thrpt   12   18179502,218 ±  704719,681  ops/s
Bench.Spring_Java_Nothing1_CGLIB_AspectJ_PCW_BeforeThenAfterReturningNoJoinPoint                 thrpt   12   42965950,206 ±  561435,926  ops/s
```

## Полезные материалы:

Ссылки:
- [Medium Spring AOP](https://medium.com/@ankithahjpgowda/what-is--oriented-programming-aop-in-spring-e7a845d904e)
- [Spring Proxy](https://docs.spring.io/spring-framework/reference/core/aop/proxying.html)
- [JdkDynamic](https://medium.com/@spac.valentin/java-dynamic-proxy-mechanism-and-how-spring-is-using-it-93756fc707d5)
- [CGLIB](https://www.baeldung.com/cglib)
- [Freefair AspectJ Gradle Plugin](https://docs.freefair.io/gradle-plugins/current/reference/#_post_compile_weaving)
- [AJC Compile Options](https://eclipse.dev/aspectj/doc/latest/devguide/ajc.html#ajc_options:~:text=%2DxmlConfigured%20%3Cfiles%3E)
- [GitHub example](https://github.com/AkaZver/spring-aop-with-aspectj-pcw)
