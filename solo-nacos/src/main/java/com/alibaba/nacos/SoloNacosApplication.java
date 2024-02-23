/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Nacos starter.
 *
 * @author nacos
 */
@SpringBootApplication(scanBasePackages = "com.alibaba.nacos")
@ServletComponentScan
@EnableScheduling
public class SoloNacosApplication {

    public static void main(String[] args) {
        if (initEnv()) {
            SpringApplication.run(SoloNacosApplication.class, args);
            System.out.println("""
                (੭♥□♥)☯☯☯˚  Nacos启动成功  ......
                   _____   ___   .       ___
                  (      .'   `. /     .'   `.
                   `--.  |     | |     |     |
                      |  |     | |     |     |
                 \\___.'   `.__.' /---/  `.__.'
                """);
        }
    }

    /**
     * 初始化运行环境
     */
    private static boolean initEnv() {
        // 单例模式运行
        System.setProperty("nacos.standalone", "true");
        return true;
    }

}

