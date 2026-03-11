package ru.tinkoff.benchmark.aop.spring.pcw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableCaching(proxyTargetClass = true, mode = AdviceMode.ASPECTJ)
@SpringBootApplication(
        scanBasePackages = {
                "ru.tinkoff.benchmark.aop.spring.pcw",
                "ru.tinkoff.benchmark.aop.utils.pcw_spring",
                "ru.tinkoff.benchmark.aop.utils.pcw_spring.aspect",
                "ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj",
                "ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.aspect",
        },
        exclude = { AopAutoConfiguration.class })
public class SpringApplication_CGLIB_AspectJ_PCW {

    public static void main(String[] args) {
        SpringApplication.run(SpringApplication_CGLIB_AspectJ_PCW.class, args);
    }
}
