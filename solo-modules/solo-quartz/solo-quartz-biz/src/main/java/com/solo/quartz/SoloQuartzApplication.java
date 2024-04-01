package com.solo.quartz;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 定时任务启动入口
 * @author 十一
 * @since 2024/03/27 13:50
 * 人生若只如初见，何事秋风悲画扇
 **/
@EnableDubbo
@EnableDiscoveryClient
@SpringBootApplication
public class SoloQuartzApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoloQuartzApplication.class, args);
        System.out.println("""
            (੭♥□♥)☯☯☯˚  定时任务启动成功  ......
               _____   ___   .       ___
              (      .'   `. /     .'   `.
               `--.  |     | |     |     |
                  |  |     | |     |     |
             \\___.'   `.__.' /---/  `.__.'
            """);
    }
}