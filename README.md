# Kora AOP Contest

[![CI Master](https://github.com/kora-projects/kora-aop-contest/actions/workflows/master.yml/badge.svg)](https://github.com/kora-projects/kora-aop-contest/actions/workflows/master.yml)

[English version](#english-version)

---

## Обзор Проекта

**Kora AOP Contest** — это бенчмарк-проект для сравнительного анализа производительности различных реализаций AOP (Aspect-Oriented Programming / Аспектно-Ориентированное Программирование) в Java-экосистеме.

## Цель Проекта

Проект предназначен для **замера и сравнения производительности** AOP-фреймворков и подходов к реализации аспектов в Java:

- Определение накладных расходов различных AOP-реализаций
- Сравнение runtime vs compile-time weaving подходов
- Анализ производительности прокси-механизмов (CGLIB, JDK Dynamic, Kora AOP)
- Профилирование и выявление узких мест в реализации аспектов

## Структура Проекта

```
kora-contest-opensource/
├── benchmark-aop/                      # Основной модуль бенчмарков
│   ├── benchmark-aop-common/           # Общие интерфейсы и утилиты
│   ├── benchmark-aop-java/             # Baseline — чистая Java без AOP
│   ├── benchmark-aop-java-kora/        # Kora Framework AOP
│   ├── benchmark-aop-java-micronaut/   # Micronaut AOP
│   ├── benchmark-aop-java-spring/      # Spring AOP (CGLIB + JDK Dynamic)
│   ├── benchmark-aop-java-spring-aot-cglib/      # Spring AOT CGLIB
│   ├── benchmark-aop-java-spring-aot-jdk-dynamic/ # Spring AOT JDK Dynamic
│   ├── benchmark-aop-java-spring-ctw/  # Spring + AspectJ Compile-Time Weaving
│   ├── benchmark-aop-java-spring-ltw/  # Spring + AspectJ Load-Time Weaving
│   ├── benchmark-aop-java-spring-pcw/  # Spring + AspectJ Post-Compile Weaving
│   └── benchmark-aop-service-java-spring/         # Сервисные бенчмарки Spring
│
├── benchmark-aop-load-testing/          # Нагрузочное тестирование (k6)
│
└── util/                                # Утилиты для бенчмарков
    ├── benchmark-common-utils/          # Общие утилиты (BenchOptions)
    ├── benchmark-aop-kora-utils/        # Kora-specific утилиты
    ├── benchmark-aop-spring-utils/      # Spring-specific утилиты
    ├── benchmark-aop-micronaut-utils/   # Micronaut-specific утилиты
    └── ...
```

## Что Тестируется

### Базовые Сценарии (Workloads)

| Сценарий | Описание |
|----------|----------|
| **Nothing** | Пустой метод без полезной нагрузки (измерение чистых накладных расходов AOP) |
| **LoggerOff** | Метод с отключенным логгированием |
| **Small** | Метод с небольшой полезной нагрузкой |
| **Medium** | Метод со средней полезной нагрузкой |
| **Big** | Метод с большой полезной нагрузкой |

### Типы Аспектов (Advice Types)

| Тип Аспекта | Описание |
|-------------|----------|
| **@Around** | Обёртывание метода (полный контроль над выполнением) |
| **@Before** | Выполнение перед методом |
| **@After** | Выполнение после метода (независимо от результата) |
| **@AfterReturning** | Выполнение после успешного завершения метода |
| **Combinations** | Комбинации нескольких типов аспектов |

### Сравниваемые Фреймворки

| Фреймворк | Тип Прокси | Weaving |
|-----------|------------|---------|
| **Plain Java** | N/A | N/A (baseline) |
| **Kora** | Compile-time генерация | Compile-time |
| **Spring CGLIB** | Runtime (subclass) | Runtime |
| **Spring JDK Dynamic** | Runtime (interface) | Runtime |
| **Spring AOT** | Compile-time генерация | Compile-time |
| **Micronaut** | Compile-time генерация | Compile-time |
| **AspectJ CTW** | Compile-time модификация байткода | Compile-time |
| **AspectJ LTW** | Load-time модификация байткода | Load-time |
| **AspectJ PCW** | Post-compile модификация байткода | Post-compile |

## Что Замеряется

### Метрики Производительности

| Метрика | Единица | Описание |
|---------|---------|----------|
| **Throughput** | ops/s | Количество операций в секунду (чем больше, тем лучше) |
| **Latency** | ms/op | Время выполнения одной операции (чем меньше, тем лучше) |

### Параметры Бенчмарка (JMH)

```
# JMH version: 1.37
# VM version: JDK 25, OpenJDK 64-Bit Server VM
# Warmup: 3 итерации по 20 секунд каждая
# Measurement: 6 итераций по 5 секунд каждая
# Threads: 1 поток
# Forks: 2
# Mode: Throughput (ops/s)
```

## Результаты Бенчмарков

### Сводная Таблица Производительности

#### Nothing1 (один вызов метода)

| Бенчмарк | Throughput (ops/s) | Относительная Производительность |
|----------|-------------------|----------------------------------|
| **Java_Nothing1** (baseline) | ~1,540,833,549 | 100% |
| **Kora_Java_Nothing1** | ~1,258,938,304 | ~82% |
| **Micronaut_Java_Nothing1** | ~24,120,757 | ~1.6% |
| **Spring CGLIB Around** | ~1,187,153 | ~0.08% |
| **Spring JDK Dynamic Around** | ~1,086,495 | ~0.07% |
| **Spring AOT CGLIB Around** | ~1,143,212 | ~0.07% |
| **AspectJ PCW Around** | ~46,032,299 | ~3% |

#### Nothing12345 (пять вызовов метода)

| Бенчмарк | Throughput (ops/s) | Относительная Производительность |
|----------|-------------------|----------------------------------|
| **Java_Nothing12345** (baseline) | ~1,543,657,655 | 100% |
| **Kora_Java_Nothing12345** | ~1,348,038,261 | ~87% |
| **Micronaut_Java_Nothing12345** | ~5,766,033 | ~0.4% |
| **Spring CGLIB Around** | ~238,980 | ~0.02% |
| **Spring JDK Dynamic Around** | ~230,198 | ~0.01% |
| **Spring AOT CGLIB Around** | ~234,538 | ~0.02% |
| **AspectJ PCW Around** | ~2,797,133 | ~0.2% |

> **Вывод**: Plain Java показывает наилучшую производительность. Kora демонстрирует лучшие результаты среди фреймворков. AspectJ PCW показывает хорошие результаты для Spring фреймворка.

## Нагрузочное Тестирование (k6)

### Сценарии Нагрузочного Тестирования

| Сценарий | Длительность | VUs (Virtual Users) | Описание |
|----------|--------------|---------------------|----------|
| **SetupDatabase** | 1s | 10 | Инициализация БД |
| **Warmup** | 40s | 1 → 20 | Прогрев приложения |
| **Pause** | 10s | 1 | Пауза между этапами |
| **Loading** | 70s | 1 → 90 → 90 | Основная нагрузка |

### Пороговые Значения (Thresholds)

| Метрика | Порог | Действие при превышении |
|---------|-------|------------------------|
| **http_req_failed** | rate < 0.1 (10%) | Предупреждение |
| **http_req_duration p(95)** | < 1000ms | Предупреждение |

## Запуск Бенчмарков

```bash
# Запуск всех бенчмарков
./gradlew benchmark

# Запуск конкретного бенчмарка
./gradlew :benchmark-aop:benchmark-aop-java-kora:run

# Запуск нагрузочного тестирования
cd benchmark-aop-load-testing
./k6 run -e TARGET_HOST=localhost:8080 k6-spring-aop.js
```

## Артефакты Проекта

| Тип | Файл | Описание |
|-----|------|----------|
| **JMH Результаты** | `jmh-result.csv` | CSV файлы с результатами бенчмарков |
| **Flamegraph** | `flamegraph_*.html` | Визуализация профилирования |
| **k6 Отчёты** | `*-report-page.html` | HTML отчёты нагрузочного тестирования |

## Рекомендации

### Для Высокой Производительности в Spring

1. Используйте **compile-time weaving** AspectJ PCW
2. Избегайте JoinPoint когда возможно в рамках AspectJ PCW
3. Используйте **@Before/@After** вместо **@Around** где применимо в AspectJ PCW
4. Используйте другие фреймворки как Kora/Micronaut

---

## English Version

## Project Overview

**Kora AOP Contest** is a benchmark project for comparative analysis of different AOP (Aspect-Oriented Programming) implementations in the Java ecosystem.

## Project Purpose

The project is designed to **measure and compare performance** of AOP frameworks and approaches to aspect implementation in Java:

- Determining overhead of various AOP implementations
- Comparing runtime vs compile-time weaving approaches
- Analyzing proxy mechanism performance (CGLIB, JDK Dynamic, Kora AOP)
- Profiling and identifying bottlenecks in aspect implementations

## Project Structure

```
kora-contest-opensource/
├── benchmark-aop/                      # Main benchmark module
│   ├── benchmark-aop-common/           # Common interfaces and utilities
│   ├── benchmark-aop-java/             # Baseline — plain Java without AOP
│   ├── benchmark-aop-java-kora/        # Kora Framework AOP
│   ├── benchmark-aop-java-micronaut/   # Micronaut AOP
│   ├── benchmark-aop-java-spring/      # Spring AOP (CGLIB + JDK Dynamic)
│   ├── benchmark-aop-java-spring-aot-cglib/      # Spring AOT CGLIB
│   ├── benchmark-aop-java-spring-aot-jdk-dynamic/ # Spring AOT JDK Dynamic
│   ├── benchmark-aop-java-spring-ctw/  # Spring + AspectJ Compile-Time Weaving
│   ├── benchmark-aop-java-spring-ltw/  # Spring + AspectJ Load-Time Weaving
│   ├── benchmark-aop-java-spring-pcw/  # Spring + AspectJ Post-Compile Weaving
│   └── benchmark-aop-service-java-spring/         # Spring service benchmarks
│
├── benchmark-aop-load-testing/          # Load testing (k6)
│
└── util/                                # Benchmark utilities
    ├── benchmark-common-utils/          # Common utilities (BenchOptions)
    ├── benchmark-aop-kora-utils/        # Kora-specific utilities
    ├── benchmark-aop-spring-utils/      # Spring-specific utilities
    ├── benchmark-aop-micronaut-utils/   # Micronaut-specific utilities
    └── ...
```

## What Is Tested

### Base Scenarios (Workloads)

| Scenario | Description |
|----------|-------------|
| **Nothing** | Empty method without payload (measuring pure AOP overhead) |
| **LoggerOff** | Method with disabled logging |
| **Small** | Method with small payload |
| **Medium** | Method with medium payload |
| **Big** | Method with large payload |

### Advice Types

| Advice Type | Description |
|-------------|-------------|
| **@Around** | Method wrapping (full control over execution) |
| **@Before** | Execution before method |
| **@After** | Execution after method (regardless of result) |
| **@AfterReturning** | Execution after successful method completion |
| **Combinations** | Combinations of multiple advice types |

### Compared Frameworks

| Framework | Proxy Type | Weaving |
|-----------|------------|---------|
| **Plain Java** | N/A | N/A (baseline) |
| **Kora** | Compile-time generation | Compile-time |
| **Spring CGLIB** | Runtime (subclass) | Runtime |
| **Spring JDK Dynamic** | Runtime (interface) | Runtime |
| **Spring AOT** | Compile-time generation | Compile-time |
| **Micronaut** | Compile-time generation | Compile-time |
| **AspectJ CTW** | Compile-time bytecode modification | Compile-time |
| **AspectJ LTW** | Load-time bytecode modification | Load-time |
| **AspectJ PCW** | Post-compile bytecode modification | Post-compile |

## What Is Measured

### Performance Metrics

| Metric | Unit | Description |
|--------|------|-------------|
| **Throughput** | ops/s | Operations per second (higher is better) |
| **Latency** | ms/op | Time per operation (lower is better) |

### Benchmark Parameters (JMH)

```
# JMH version: 1.37
# VM version: JDK 25, OpenJDK 64-Bit Server VM
# Warmup: 3 iterations, 20s each
# Measurement: 6 iterations, 5s each
# Threads: 1 thread
# Forks: 2
# Mode: Throughput (ops/s)
```

## Benchmark Results

### Performance Summary Table

#### Nothing1 (single method call)

| Benchmark | Throughput (ops/s) | Relative Performance |
|-----------|-------------------|---------------------|
| **Java_Nothing1** (baseline) | ~1,540,833,549 | 100% |
| **Kora_Java_Nothing1** | ~1,258,938,304 | ~82% |
| **Micronaut_Java_Nothing1** | ~24,120,757 | ~1.6% |
| **Spring CGLIB Around** | ~1,187,153 | ~0.08% |
| **Spring JDK Dynamic Around** | ~1,086,495 | ~0.07% |
| **Spring AOT CGLIB Around** | ~1,143,212 | ~0.07% |
| **AspectJ PCW Around** | ~46,032,299 | ~3% |

#### Nothing12345 (five method calls)

| Benchmark | Throughput (ops/s) | Relative Performance |
|-----------|-------------------|---------------------|
| **Java_Nothing12345** (baseline) | ~1,543,657,655 | 100% |
| **Kora_Java_Nothing12345** | ~1,348,038,261 | ~87% |
| **Micronaut_Java_Nothing12345** | ~5,766,033 | ~0.4% |
| **Spring CGLIB Around** | ~238,980 | ~0.02% |
| **Spring JDK Dynamic Around** | ~230,198 | ~0.01% |
| **Spring AOT CGLIB Around** | ~234,538 | ~0.02% |
| **AspectJ PCW Around** | ~2,797,133 | ~0.2% |

> **Conclusion**: Plain Java shows the best performance. Kora demonstrates the best results among frameworks. AspectJ PCW shows good results for Spring framework.

## Load Testing (k6)

### Load Testing Scenarios

| Scenario | Duration | VUs (Virtual Users) | Description |
|----------|----------|---------------------|-------------|
| **SetupDatabase** | 1s | 10 | Database initialization |
| **Warmup** | 40s | 1 → 20 | Application warmup |
| **Pause** | 10s | 1 | Pause between stages |
| **Loading** | 70s | 1 → 90 → 90 | Main load |

### Thresholds

| Metric | Threshold | Action on Exceed |
|--------|-----------|------------------|
| **http_req_failed** | rate < 0.1 (10%) | Warning |
| **http_req_duration p(95)** | < 1000ms | Warning |

## Running Benchmarks

```bash
# Run all benchmarks
./gradlew benchmark

# Run specific benchmark
./gradlew :benchmark-aop:benchmark-aop-java-kora:run

# Run load testing
cd benchmark-aop-load-testing
./k6 run -e TARGET_HOST=localhost:8080 k6-spring-aop.js
```

## Project Artifacts

| Type | File | Description |
|------|------|-------------|
| **JMH Results** | `jmh-result.csv` | CSV files with benchmark results |
| **Flamegraph** | `flamegraph_*.html` | Profiling visualization |
| **k6 Reports** | `*-report-page.html` | HTML load testing reports |

## Recommendations

### For High Performance in Spring

1. Use **compile-time weaving** like AspectJ PCW
2. Avoid JoinPoint when possible in AspectJ PCW
3. Use **@Before/@After** instead of **@Around** where applicable in AspectJ PCW
4. Use other frameworks like Kora/Micronaut
