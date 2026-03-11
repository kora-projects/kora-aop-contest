package ru.tinkoff.benchmark.aop.utils.kora.aspect;

import com.squareup.javapoet.ClassName;
import javax.annotation.processing.ProcessingEnvironment;

public final class Loggable3KoraAspect extends AbstractLoggableKoraAspect {

    private static final ClassName ANNOTATION = ClassName.get("ru.tinkoff.benchmark.aop.utils.kora", "Loggable3");

    public Loggable3KoraAspect(ProcessingEnvironment env) {
        super(env.getElementUtils());
    }

    @Override
    protected ClassName annotation() {
        return ANNOTATION;
    }
}
