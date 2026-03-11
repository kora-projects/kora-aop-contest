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
Benchmark                        Mode  Cnt           Score          Error  Units
Bench.Kora_Java_Nothing1        thrpt   12  1258938304,200 ± 62866627,533  ops/s
Bench.Kora_Java_Nothing12345    thrpt   12  1348038261,263 ±  6056114,476  ops/s
```

## Полезные материалы:

Ссылки:
- [Kora](https://kora-projects.github.io/kora-docs/ru/)