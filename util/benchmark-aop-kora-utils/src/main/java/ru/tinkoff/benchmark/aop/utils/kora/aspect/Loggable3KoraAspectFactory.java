package ru.tinkoff.benchmark.aop.utils.kora.aspect;

import java.util.Optional;
import javax.annotation.processing.ProcessingEnvironment;
import ru.tinkoff.kora.aop.annotation.processor.KoraAspect;
import ru.tinkoff.kora.aop.annotation.processor.KoraAspectFactory;

public final class Loggable3KoraAspectFactory implements KoraAspectFactory {

    @Override
    public Optional<KoraAspect> create(ProcessingEnvironment processingEnvironment) {
        return Optional.of(new Loggable3KoraAspect(processingEnvironment));
    }
}
