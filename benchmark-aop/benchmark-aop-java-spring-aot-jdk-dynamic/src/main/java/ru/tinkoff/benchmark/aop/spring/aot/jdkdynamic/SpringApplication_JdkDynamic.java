package ru.tinkoff.benchmark.aop.spring.aot.jdkdynamic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(proxyTargetClass = false)
@EnableCaching(proxyTargetClass = false)
@SpringBootApplication(
        scanBasePackages = {
                "ru.tinkoff.benchmark.aop.spring.aot.jdkdynamic.emulator",
                "ru.tinkoff.benchmark.aop.utils.aot.spring",
                "ru.tinkoff.benchmark.aop.utils.aot.pcw_spring",
        },
        exclude = { AopAutoConfiguration.class })
public class SpringApplication_JdkDynamic {

    public static void main(String[] args) {
        SpringApplication.run(SpringApplication_JdkDynamic.class, args);
    }
}
