package com.solo.in;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * In模块启动类
 * @author 十一
 * @since 2023/11/02 17:03
 * 人生若只如初见，何事秋风悲画扇
 **/
@EnableDubbo
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.solo.*.api.feign"})
public class SoloAccessInApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoloAccessInApplication.class, args);
        System.out.println("""
            (੭♥□♥)☯☯☯˚  通道服务启动成功  ......
               _____   ___   .       ___
              (      .'   `. /     .'   `.
               `--.  |     | |     |     |
                  |  |     | |     |     |
             \\___.'   `.__.' /---/  `.__.'
            """);
    }

}
