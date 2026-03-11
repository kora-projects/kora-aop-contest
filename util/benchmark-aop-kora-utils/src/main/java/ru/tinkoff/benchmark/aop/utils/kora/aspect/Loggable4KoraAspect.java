package ru.tinkoff.benchmark.aop.utils.kora.aspect;

import com.squareup.javapoet.ClassName;
import javax.annotation.processing.ProcessingEnvironment;

public final class Loggable4KoraAspect extends AbstractLoggableKoraAspect {

    private static final ClassName ANNOTATION = ClassName.get("ru.tinkoff.benchmark.aop.utils.kora", "Loggable4");

    public Loggable4KoraAspect(ProcessingEnvironment env) {
        super(env.getElementUtils());
    }

    @Override
    protected ClassName annotation() {
        return ANNOTATION;
    }
}
