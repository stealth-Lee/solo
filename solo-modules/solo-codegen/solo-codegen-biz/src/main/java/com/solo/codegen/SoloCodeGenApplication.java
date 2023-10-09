package com.solo.codegen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 代码生成模块启动类
 * @author 十一
 * @since 2023/10/08 14:06
 * 人生若只如初见，何事秋风悲画扇
 **/
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.solo.*.mapper")
public class SoloCodeGenApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoloCodeGenApplication.class, args);
        System.out.println("""
            (੭♥□♥)☯☯☯˚  代码生成模块启动成功  ......
               _____   ___   .       ___
              (      .'   `. /     .'   `.
               `--.  |     | |     |     |
                  |  |     | |     |     |
             \\___.'   `.__.' /---/  `.__.'
             :: solo ::                (v2023.9.1)
            """);
    }

}
