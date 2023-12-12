/**
 * Configuration和AutoConfiguration注解的区别
 *
 * <p>相同点：都是用来标识一个类是配置类，都可以被Spring容器扫描到并加载到Spring容器中。
 *
 * <p>不同点：1.Configuration注解是Spring原生的注解，AutoConfiguration是SpringBoot的注解。
 * 2.@Configuration加载是由@ComponentScan指定的package，未指定 以ApplicationClass 所属package开始。
 * AutoConfiguration 是通过classpath*:META-INF/spring.factories来被发现。
 * 通过 key org.springframework.boot.autoconfigure.EnableAutoConfiguration.AutoConfiguration 是由 import selector 的方式加载的
 * 3.@Configuration 先于AutoConfiguration加载
 *
 * <p>AutoConfiguration可以使用@AutoConfigureOrder或者 @AutoConfigureBefore、@AutoConfigureAfter 作为注解
 * AutoConfiguration的class 所属包 在 @ComponentScan ，被认为既是Configuration，又是AutoConfiguration。所以会被加载两次。
 * 先以Configuration身份时先 加载。 因此 @AutoConfigureBefore、@AutoConfigureAfter 不起作用。
 *
 * <p>Spring Boot 2.7中不推荐使用/META-INF/spring.factories文件，并且在Spring Boot 3将移除对/META-INF/spring.factories的支持。
 * 原因可能是因为写法不够优雅，比如：org.springframework.boot.autoconfigure.EnableAutoConfiguration=\com.spring4all.swagger.SwaggerAutoConfiguration
 * 新的写法是创建一个新的文件：/META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports
 * 内容直接放配置类即可（注意有spring目录），比如这样：com.example.swagger.SwaggerAutoConfiguration
 */
package com.solo.common.core.config;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Jackson配置类
 * @author 十一
 * @since 2023/09/04 09:40
 * 人生若只如初见，何事秋风悲画扇
 **/
@AutoConfiguration
public class JacksonConfig {

    /**
     * 自定义全局配置 JDK8 时间序列化格式
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer customizer() {
        return builder -> {
            // 序列化
            builder.serializerByType(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern("HH:mm:ss")));
            builder.serializerByType(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            builder.serializerByType(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            // 反序列化
            builder.deserializerByType(LocalTime.class, new LocalTimeDeserializer(DateTimeFormatter.ofPattern("HH:mm:ss")));
            builder.deserializerByType(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            builder.deserializerByType(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        };
    }

}
