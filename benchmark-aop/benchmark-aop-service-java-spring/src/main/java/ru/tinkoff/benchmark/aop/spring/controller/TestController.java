package ru.tinkoff.benchmark.aop.spring.controller;

import org.openjdk.jmh.infra.Blackhole;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tinkoff.benchmark.aop.spring.emulator.SpringAspectEmulator;
import ru.tinkoff.benchmark.aop.utils.AspectConsumer;

@RestController
@RequestMapping("/tests")
public class TestController {

    private final Blackhole BLACKHOLE = new Blackhole(
            "Today's password is swordfish. I understand instantiating Blackholes directly is dangerous.");
    private final AspectConsumer BLACKHOLE_CONSUMER = BLACKHOLE::consume;

    private final SpringAspectEmulator aspectEmulator;

    public TestController(SpringAspectEmulator aspectEmulator) {
        this.aspectEmulator = aspectEmulator;
    }

    @GetMapping(value = "/{id}/emulatorLoggerOff1", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PetTO> getEmulatorLoggerOff1(@PathVariable("id") String id) {
        return ResponseEntity.ok(aspectEmulator.doWorkLoggerOff1(id, BLACKHOLE_CONSUMER));
    }

    @GetMapping(value = "/{id}/emulatorLoggerOff5", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PetTO> getEmulatorLoggerOff5(@PathVariable("id") String id) {
        return ResponseEntity.ok(aspectEmulator.doWorkLoggerOff5(id, BLACKHOLE_CONSUMER));
    }

    @GetMapping(value = "/{id}/emulatorLoggerOff50", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PetTO> getEmulatorLoggerOff50(@PathVariable("id") String id) {
        String petId = id;
        for (int i = 0; i < 10; i++) {
            petId = aspectEmulator.doWorkLoggerOffWithId5(id, BLACKHOLE_CONSUMER);
        }
        var result = PetTO.create(petId);
        BLACKHOLE_CONSUMER.consume(result);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/{id}/emulatorNothing1", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PetTO> getEmulatorNothing1(@PathVariable("id") String id) {
        return ResponseEntity.ok(aspectEmulator.doNothing1(id, BLACKHOLE_CONSUMER));
    }

    @GetMapping(value = "/{id}/emulatorNothing5", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PetTO> getEmulatorNothing5(@PathVariable("id") String id) {
        return ResponseEntity.ok(aspectEmulator.doNothing5(id, BLACKHOLE_CONSUMER));
    }

    @GetMapping(value = "/{id}/emulatorNothing50", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PetTO> getEmulatorNothing50(@PathVariable("id") String id) {
        String petId = id;
        for (int i = 0; i < 10; i++) {
            petId = aspectEmulator.doNothingWithId5(id, BLACKHOLE_CONSUMER);
        }
        var result = PetTO.create(petId);
        BLACKHOLE_CONSUMER.consume(result);
        return ResponseEntity.ok(result);
    }
}
