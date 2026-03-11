package ru.tinkoff.benchmark.aop.utils;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.concurrent.CompletableFuture;
import org.springframework.validation.annotation.Validated;

// Need separate interface cause stupid Spring hibernate validation can't handle @Validated diff on
// interface and in class
// A method overriding another method must not redefine the parameter constraint configuration, but
// method SpringAspectProduction#doWork(String, AspectConsumer) redefines the configuration of
// AspectProduction#doWork(String, AspectConsumer)
@Validated
public interface AspectProductionSpring {

    // Without @Timeout cause Resilient4j can't support Spring SYNC signature
    // Even when Resilient4j Timer supports SYNC signature
    @Valid
    @NotNull
    User doWork(@NotBlank String id,
                @NotNull AspectConsumer consumer);

    // Without @Timeout to match doWork
    @Valid
    CompletableFuture<User> doWorkCompleted(@NotBlank String id,
                                            @NotNull AspectConsumer consumer);

    // Cause Resilient4j @Timeout can't handle Spring SYNC signature
    @Valid
    CompletableFuture<User> doWorkTimeoutAsync(@NotBlank String id,
                                               @NotNull AspectConsumer consumer);

    // Cause Resilient4j @Timeout can't handle Spring SYNC signature
    @Valid
    CompletableFuture<User> doWorkTimeoutCompleted(@NotBlank String id,
                                                   @NotNull AspectConsumer consumer);
}
