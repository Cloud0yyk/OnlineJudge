package com.cloud.cloud_backend_user_service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 主类（项目启动入口）
 *
 */
// todo 如需开启 Redis，须移除 exclude 中的内容
@SpringBootApplication(exclude = {RedisAutoConfiguration.class},
        scanBasePackages = {
                "com.cloud.cloud_backend_user_service",
                "com.cloud.cloud_backend_common"
        })
@MapperScan("com.cloud.cloud_backend_user_service.mapper")
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@EnableFeignClients
public class CloudBackendUserService {

    public static void main(String[] args) {
        SpringApplication.run(CloudBackendUserService.class, args);
    }

}
