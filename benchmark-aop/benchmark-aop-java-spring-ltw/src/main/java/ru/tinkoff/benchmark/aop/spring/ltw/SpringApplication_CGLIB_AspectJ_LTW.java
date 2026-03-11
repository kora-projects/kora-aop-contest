package ru.tinkoff.benchmark.aop.spring.ltw;

import static org.springframework.context.annotation.EnableLoadTimeWeaving.AspectJWeaving.ENABLED;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value = "classpath:application-CGLIB.yaml", factory = SpringYamlPropertySourceFactory.class)
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableCaching(proxyTargetClass = true, mode = AdviceMode.ASPECTJ)
@EnableLoadTimeWeaving(aspectjWeaving = ENABLED)
@SpringBootApplication(
        scanBasePackages = {
                "ru.tinkoff.benchmark.aop.spring.ltw.emulator",
                "ru.tinkoff.benchmark.aop.utils.spring"
        },
        exclude = { AopAutoConfiguration.class, TransactionAutoConfiguration.class })
public class SpringApplication_CGLIB_AspectJ_LTW {

    public static void main(String[] args) {
        SpringApplication.run(SpringApplication_CGLIB_AspectJ_LTW.class, args);
    }
}
