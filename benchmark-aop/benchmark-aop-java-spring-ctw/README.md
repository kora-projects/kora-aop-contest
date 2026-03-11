# AspectJ CTW - Compile Time Weaving

Compile Time Weaving requires to separate code and bench due to errors
when annotation processing JMH and compiling separately AspectJ,
this may come an issue at any codebase with some complex compiling or annotation processing.

## Полезные материалы:

Ссылки:
- [Medium Spring AOP](https://medium.com/@ankithahjpgowda/what-is--oriented-programming-aop-in-spring-e7a845d904e)
- [Spring Proxy](https://docs.spring.io/spring-framework/reference/core/aop/proxying.html)
- [JdkDynamic](https://medium.com/@spac.valentin/java-dynamic-proxy-mechanism-and-how-spring-is-using-it-93756fc707d5)
- [CGLIB](https://www.baeldung.com/cglib)
- [Freefair AspectJ Gradle Plugin](https://docs.freefair.io/gradle-plugins/current/reference/#_compile_time_weaving)
- [AJC Compile Options](https://eclipse.dev/aspectj/doc/latest/devguide/ajc.html#ajc_options:~:text=%2DxmlConfigured%20%3Cfiles%3E)
- [GitHub example](https://github.com/AkaZver/spring-aop-with-aspectj-pcw)
