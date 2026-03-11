package ru.tinkoff.benchmark.aop.spring.aot.cglib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableCaching(proxyTargetClass = true)
@SpringBootApplication(
        scanBasePackages = {
                "ru.tinkoff.benchmark.aop.spring.aot.cglib.emulator",
                "ru.tinkoff.benchmark.aop.utils.aot.spring",
                "ru.tinkoff.benchmark.aop.utils.aot.pcw_spring",
        },
        exclude = { AopAutoConfiguration.class })
public class SpringApplication_CGLIB {

    public static void main(String[] args) {
        SpringApplication.run(SpringApplication_CGLIB.class, args);
    }
}
