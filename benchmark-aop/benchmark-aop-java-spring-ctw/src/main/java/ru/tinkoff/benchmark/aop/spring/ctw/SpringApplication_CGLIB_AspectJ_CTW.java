package ru.tinkoff.benchmark.aop.spring.ctw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value = "classpath:application-CGLIB.yaml", factory = SpringYamlPropertySourceFactory.class)
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableCaching(proxyTargetClass = true, mode = AdviceMode.ASPECTJ)
@SpringBootApplication(
        scanBasePackages = {
                "ru.tinkoff.benchmark.aop.spring.ctw.emulator",
                "ru.tinkoff.benchmark.aop.utils.pcw_spring",
                "ru.tinkoff.benchmark.aop.utils.pcw_spring.aspect",
                "ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj",
                "ru.tinkoff.benchmark.aop.utils.pcw_spring_aspectj.aspect",
        },
        exclude = { AopAutoConfiguration.class, TransactionAutoConfiguration.class })
public class SpringApplication_CGLIB_AspectJ_CTW {

    public static void main(String[] args) {
        SpringApplication.run(SpringApplication_CGLIB_AspectJ_CTW.class, args);
    }
}
