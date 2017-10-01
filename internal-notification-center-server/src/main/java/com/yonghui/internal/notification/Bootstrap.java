package com.yonghui.internal.notification;

import com.yonghui.consul.YhConsulConfig;
import com.yonghui.feign.FeignConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@Import({YhConsulConfig.class, FeignConfiguration.class})
@EnableFeignClients(basePackages = "com.yonghui.internal.notification.feign")
@SpringCloudApplication
@MapperScan("com.yonghui.internal.notification.mapper")
public class Bootstrap {

    private static final Logger log = LoggerFactory.getLogger(Bootstrap.class);

    public static void main(String[] args) {
        SpringApplication.run(Bootstrap.class, args);
        log.info("Bootstrap started successfully");
    }

}