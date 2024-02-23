/**
 * <p>SpringBoot最强大的功能就是把我们常用的场景抽取成了一个个starter（场景启动器），
 * 通过SpringBoot为我们提供的这些场景启动器，我们再进行少量的配置就能使用相应的功能。
 * 如果我们想要使用传统意义上的 Spring 应用，那么需要配置大量的 xml 文件才可以启动，而且随着项目的越来越庞大，
 * 配置文件也会越来越繁琐，这在一定程度上也给开发者带来了困扰，于是 SpringBoot 就应运而生了。
 * SpringBoot 的诞生就是为了简化 Spring 中繁琐的 XML 配置，其本质依然是 Spring 框架，
 * 使用 SpringBoot 之后可以不使用任何 XML 配置来启动一个服务，使得我们在使用微服务架构时可以更加快速地建立一个应用。
 *
 * <p>SpringBoot 具有以下特点：
 *   1.创建独立的 Spring 应用。
 *   2.直接嵌入了 Tomcat、Jetty 或 Undertow（不需要部署 WAR 文件）。
 *   3.提供了固定的配置来简化配置。
 *   4.尽可能地自动配置 Spring 和第三方库。
 *   5.提供可用于生产的特性，如度量、运行状况检查和外部化配置。
 *   6.完全不需要生成代码，也不需要 XML 配置。
 * SpringBoot 这些特点中最重要的两条就是约定优于配置和自动装配。
 *
 * <p>约定优于配置
 * SpringBoot 的约定优于配置主要体现在以下方面：
 *   maven 项目的配置文件存放在 resources 资源目录下。
 *   maven 项目默认编译后的文件放于 target 目录。
 *   maven 项目默认打包成 jar 格式。
 *   配置文件默认为 application.yml 或者 application.yaml 或者 application.properties。
 *   默认通过配置文件 spring.profiles.active 来激活配置。
 *
 * <p>自动装配则是 SpringBoot 的核心，自动装配实际上就是为了从spring.factories文件中获取到对应的需要进行自动装配的类，
 * 并生成相应的Bean对象，然后将它们交给spring容器来帮我们进行管理，
 * 相比较于传统的 Spring 应用，搭建一个 SpringBoot 应用， 我们只需要引入一个注解 @SpringBootApplication，就可以成功运行。
 *
 * <p>@SpringBootApplication 注解是一个组合注解，它整合了 @SpringBootConfiguration，@EnableAutoConfiguration，@ComponentScan 注解。
 * 也就是说我们如果不用 @SpringBootApplication 这个复合注解，而是直接使用最上面三个注解，也能启动一个 SpringBoot 应用。
 *
 * <p>@SpringBootConfiguration:它实际上就是一个 @Configuration 注解，这个注解大家应该很熟悉了，
 * 加上这个注解就是为了让当前类作为一个配置类交由 Spring 的 IOC 容器进行管理，因为前面我们说了，SpringBoot 本质上还是 Spring，
 * 所以原属于 Spring 的注解 @Configuration 在 SpringBoot 中也可以直接应用。
 *
 * <p>@ComponentScan：用于定义 Spring 的扫描路径，等价于在 xml 文件中配置 context:component-scan，假如不配置扫描路径，
 * 那么 Spring 就会默认扫描当前类所在的包及其子包中的所有标注了 @Component，@Service，@Controller 等注解的类。
 * @EnableAutoConfiguration：这个注解才是实现自动装配的关键，它是一个由 @AutoConfigurationPackage 和 @Import 注解组成的复合注解。
 * AutoConfigurationPackage注解的作用是将添加该注解的类所在的package作为自动配置package进行管理
 * @Import 注解其实就是为了去导入一个类AutoConfigurationImportSelector
 *
 * 参考：https://blog.csdn.net/qq_31960623/article/details/118183099
 *
 * <p>@EnableDiscoveryClient 用于在Spring Boot应用中启用服务发现的功能,它是Spring Cloud框架中的一个注解，
 * 用于将应用注册到服务发现组件（如Eureka、Consul等）。当应用启动时，它会自动注册到服务发现组件，并提供给其他应用使用。
 */
package com.solo.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 网关启动入口
 * @author 十一
 * @date 2023/08/30 17:39
 * 人生若只如初见，何事秋风悲画扇
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class SoloGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoloGatewayApplication.class, args);
        System.out.println("""
            (੭♥□♥)☯☯☯˚  网关模块启动成功  ......
               _____   ___   .       ___
              (      .'   `. /     .'   `.
               `--.  |     | |     |     |
                  |  |     | |     |     |
             \\___.'   `.__.' /---/  `.__.'
            """);
    }

}
