## Spring CGLIB + JdkDynamic Proxy

### CGLIB

CGLIB (Code Generation Library) is a third-party library used to generate dynamic subclasses at runtime. 
It allows you to create a subclass of a class (even if it's not implementing any interface) 
and override its methods to add custom behavior, such as logging, transactions, security, etc.

### JdkDynamic Proxy

JDK Dynamic Proxy is a built-in Java feature (from `java.lang.reflect.Proxy`) that allows 
you to create a proxy object that implements one or more interfaces at runtime.

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
Benchmark                                                                         Mode  Cnt        Score       Error  Units
Bench.Spring_Java_Nothing12345_CGLIB_After                                thrpt   12   260390,871 ±  3769,506  ops/s
Bench.Spring_Java_Nothing12345_CGLIB_AfterNoJoinPoint                     thrpt   12   223294,180 ±  5365,462  ops/s
Bench.Spring_Java_Nothing12345_CGLIB_AfterReturning                       thrpt   12   229618,485 ±  6552,140  ops/s
Bench.Spring_Java_Nothing12345_CGLIB_AfterReturningNoJoinPoint            thrpt   12   215821,787 ±  4983,731  ops/s
Bench.Spring_Java_Nothing12345_CGLIB_Around                               thrpt   12   238980,336 ±  9559,047  ops/s
Bench.Spring_Java_Nothing12345_CGLIB_Before                               thrpt   12   234271,319 ±  4589,053  ops/s
Bench.Spring_Java_Nothing12345_CGLIB_BeforeAfterPointcut                  thrpt   12   107348,867 ±  2148,073  ops/s
Bench.Spring_Java_Nothing12345_CGLIB_BeforeAfterReturningPointcut         thrpt   12   100272,236 ±  1488,355  ops/s
Bench.Spring_Java_Nothing12345_CGLIB_BeforeNoJoinPoint                    thrpt   12   221082,402 ±  3092,987  ops/s
Bench.Spring_Java_Nothing12345_CGLIB_BeforeThenAfter                      thrpt   12   121426,178 ±  1411,786  ops/s
Bench.Spring_Java_Nothing12345_CGLIB_BeforeThenAfterNoJoinPoint           thrpt   12   109943,386 ±  2431,289  ops/s
Bench.Spring_Java_Nothing12345_CGLIB_BeforeThenAfterReturning             thrpt   12   114203,394 ±  1538,020  ops/s
Bench.Spring_Java_Nothing12345_CGLIB_BeforeThenAfterReturningNoJoinPoint  thrpt   12   105778,037 ±   881,424  ops/s
Bench.Spring_Java_Nothing12345_JdkDynamic_Around                          thrpt   12   230198,949 ± 11938,516  ops/s
Bench.Spring_Java_Nothing1_CGLIB_After                                    thrpt   12  1151521,200 ± 65443,666  ops/s
Bench.Spring_Java_Nothing1_CGLIB_AfterNoJoinPoint                         thrpt   12  1055532,611 ± 58240,973  ops/s
Bench.Spring_Java_Nothing1_CGLIB_AfterReturning                           thrpt   12  1044804,749 ± 19867,328  ops/s
Bench.Spring_Java_Nothing1_CGLIB_AfterReturningNoJoinPoint                thrpt   12   980612,456 ±  8341,414  ops/s
Bench.Spring_Java_Nothing1_CGLIB_Around                                   thrpt   12  1187153,971 ± 15503,115  ops/s
Bench.Spring_Java_Nothing1_CGLIB_Before                                   thrpt   12  1199603,271 ± 14331,877  ops/s
Bench.Spring_Java_Nothing1_CGLIB_BeforeAfterPointcut                      thrpt   12   502215,038 ± 11072,925  ops/s
Bench.Spring_Java_Nothing1_CGLIB_BeforeAfterReturningPointcut             thrpt   12   484058,893 ±  3288,689  ops/s
Bench.Spring_Java_Nothing1_CGLIB_BeforeNoJoinPoint                        thrpt   12  1059003,376 ± 13170,274  ops/s
Bench.Spring_Java_Nothing1_CGLIB_BeforeThenAfter                          thrpt   12   572957,341 ± 12281,948  ops/s
Bench.Spring_Java_Nothing1_CGLIB_BeforeThenAfterNoJoinPoint               thrpt   12   507825,608 ± 10733,329  ops/s
Bench.Spring_Java_Nothing1_CGLIB_BeforeThenAfterReturning                 thrpt   12   548388,787 ± 11285,264  ops/s
Bench.Spring_Java_Nothing1_CGLIB_BeforeThenAfterReturningNoJoinPoint      thrpt   12   469482,695 ± 14526,056  ops/s
Bench.Spring_Java_Nothing1_JdkDynamic_Around                              thrpt   12  1086495,589 ± 40829,133  ops/s
```

## Полезные материалы:

Ссылки:
- [Medium Spring AOP](https://medium.com/@ankithahjpgowda/what-is--oriented-programming-aop-in-spring-e7a845d904e)
- [Spring Proxy](https://docs.spring.io/spring-framework/reference/core/aop/proxying.html)
- [JdkDynamic](https://medium.com/@spac.valentin/java-dynamic-proxy-mechanism-and-how-spring-is-using-it-93756fc707d5)
- [CGLIB](https://www.baeldung.com/cglib)
