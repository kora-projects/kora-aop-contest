package ru.tinkoff.benchmark.aop.spring.emulator;

import org.springframework.stereotype.Component;
import ru.tinkoff.benchmark.aop.spring.controller.PetTO;
import ru.tinkoff.benchmark.aop.utils.AspectConsumer;
import ru.tinkoff.benchmark.aop.utils.WorkType;
import ru.tinkoff.benchmark.aop.utils.spring.*;

@Component
public class SpringAspectEmulator {

    @Loggable1
    public PetTO doNothing1(String id, AspectConsumer consumer) {
        var result = PetTO.create(id);
        consumer.consume(result);
        return result;
    }

    @Loggable1
    @Loggable2
    @Loggable3
    @Loggable4
    @Loggable5
    public PetTO doNothing5(String id, AspectConsumer consumer) {
        var result = PetTO.create(id);
        consumer.consume(result);
        return result;
    }

    @Loggable1
    @Loggable2
    @Loggable3
    @Loggable4
    @Loggable5
    public String doNothingWithId5(String id, AspectConsumer consumer) {
        consumer.consume(id);
        return id;
    }

    @Loggable1(WorkType.LOGGER_OFF)
    public PetTO doWorkLoggerOff1(String id, AspectConsumer consumer) {
        var result = PetTO.create(id);
        consumer.consume(result);
        return result;
    }

    @Loggable1(WorkType.LOGGER_OFF)
    @Loggable2(WorkType.LOGGER_OFF)
    @Loggable3(WorkType.LOGGER_OFF)
    @Loggable4(WorkType.LOGGER_OFF)
    @Loggable5(WorkType.LOGGER_OFF)
    public PetTO doWorkLoggerOff5(String id, AspectConsumer consumer) {
        var result = PetTO.create(id);
        consumer.consume(result);
        return result;
    }

    @Loggable1(WorkType.LOGGER_OFF)
    @Loggable2(WorkType.LOGGER_OFF)
    @Loggable3(WorkType.LOGGER_OFF)
    @Loggable4(WorkType.LOGGER_OFF)
    @Loggable5(WorkType.LOGGER_OFF)
    public String doWorkLoggerOffWithId5(String id, AspectConsumer consumer) {
        consumer.consume(id);
        return id;
    }
}
