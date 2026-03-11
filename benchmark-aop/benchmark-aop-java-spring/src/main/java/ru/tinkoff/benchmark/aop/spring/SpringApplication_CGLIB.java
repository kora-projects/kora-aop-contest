package ru.tinkoff.benchmark.aop.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value = "classpath:application-CGLIB.yaml", factory = SpringYamlPropertySourceFactory.class)
@EnableAspectJAutoProxy(proxyTargetClass = true)
@SpringBootApplication(
        scanBasePackages = {
                "ru.tinkoff.benchmark.aop.spring.emulator",
                "ru.tinkoff.benchmark.aop.utils.spring",
                "ru.tinkoff.benchmark.aop.utils.spring_aspectj",
        },
        exclude = { AopAutoConfiguration.class, TransactionAutoConfiguration.class })
public class SpringApplication_CGLIB {

    public static void main(String[] args) {
        SpringApplication.run(SpringApplication_CGLIB.class, args);
    }
}
