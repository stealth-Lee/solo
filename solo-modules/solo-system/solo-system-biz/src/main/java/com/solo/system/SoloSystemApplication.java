package com.solo.system;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 系统模块启动入口
 * @author 十一
 * @since 2023/08/30 17:38
 * 人生若只如初见，何事秋风悲画扇
 **/
@EnableDubbo
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.solo.*.api.feign"})
public class SoloSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoloSystemApplication.class, args);
        System.out.println("""
            (੭♥□♥)☯☯☯˚  系统模块启动成功  ......
               _____   ___   .       ___
              (      .'   `. /     .'   `.
               `--.  |     | |     |     |
                  |  |     | |     |     |
             \\___.'   `.__.' /---/  `.__.'
            """);
    }

}
