package ru.tinkoff.benchmark.aop.utils.kora.aspect;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.Elements;
import ru.tinkoff.benchmark.aop.utils.WorkType;
import ru.tinkoff.kora.annotation.processor.common.AnnotationUtils;
import ru.tinkoff.kora.aop.annotation.processor.KoraAspect;

public abstract class AbstractLoggableKoraAspect implements KoraAspect {

    private final Elements elements;

    protected AbstractLoggableKoraAspect(Elements elements) {
        this.elements = elements;
    }

    protected abstract ClassName annotation();

    @Override
    public ApplyResult apply(ExecutableElement method, String superCall, AspectContext aspectContext) {
        WorkType workType = Optional.ofNullable(AnnotationUtils.findAnnotation(method, annotation()))
                .map(a -> AnnotationUtils.parseAnnotationValue(elements, a, "value"))
                .map(v -> WorkType.valueOf(String.valueOf(v)))
                .orElse(WorkType.NOTHING);

        final CodeBlock.Builder builder = CodeBlock.builder();

        VariableElement argString = method.getParameters().stream()
                .filter(p -> p.asType().toString().endsWith("String"))
                .findFirst()
                .orElseThrow();

        String params = method.getParameters().stream()
                .map(p -> p.getSimpleName().toString())
                .collect(Collectors.joining(", "));

        VariableElement argConsumer = method.getParameters().stream()
                .filter(p -> p.asType().toString().equals("ru.tinkoff.benchmark.aop.utils.AspectConsumer"))
                .findFirst()
                .orElseThrow();

        builder.addStatement("$T.doWork($L, $L, $T.$L)",
                ClassName.get("ru.tinkoff.benchmark.aop.utils", "AspectEmulatorWorker"),
                argString.getSimpleName().toString(),
                argConsumer.getSimpleName().toString(),
                ClassName.get("ru.tinkoff.benchmark.aop.utils", "WorkType"),
                workType.name());
        builder.addStatement("var _value = $L($L)", superCall, params);
        builder.addStatement("$T.doWork($L, $L, $T.$L)",
                ClassName.get("ru.tinkoff.benchmark.aop.utils", "AspectEmulatorWorker"),
                argString.getSimpleName().toString(),
                argConsumer.getSimpleName().toString(),
                ClassName.get("ru.tinkoff.benchmark.aop.utils", "WorkType"),
                workType.name());
        builder.addStatement("return _value");
        return new ApplyResult.MethodBody(builder.build());
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Set.of(annotation().canonicalName());
    }
}
