package ru.tinkoff.benchmark.aop.utils;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public interface AspectProductionValidateOnly {

    @Valid
    @NotNull
    User doWorkValidateOnly(@NotBlank String id,
                            @NotNull AspectConsumer consumer);
}
