package ru.tinkoff.benchmark.aop.utils.kora.aspect;

import com.squareup.javapoet.ClassName;
import javax.annotation.processing.ProcessingEnvironment;

public final class Loggable5KoraAspect extends AbstractLoggableKoraAspect {

    private static final ClassName ANNOTATION = ClassName.get("ru.tinkoff.benchmark.aop.utils.kora", "Loggable5");

    public Loggable5KoraAspect(ProcessingEnvironment env) {
        super(env.getElementUtils());
    }

    @Override
    protected ClassName annotation() {
        return ANNOTATION;
    }
}
