package com.solo.auth;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 认证中心启动类
 * @author 十一
 * @since 2023/11/24 11:16
 * 人生若只如初见，何事秋风悲画扇
 **/
@EnableDubbo
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.solo.*.api.feign"})
public class SoloAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoloAuthApplication.class, args);
        System.out.println("""
            (੭♥□♥)☯☯☯˚  认证中心启动成功  ......
               _____   ___   .       ___
              (      .'   `. /     .'   `.
               `--.  |     | |     |     |
                  |  |     | |     |     |
             \\___.'   `.__.' /---/  `.__.'
             :: solo ::                (v2023.9.1)
            """);
    }

}
