package com.migro.jobcenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * 类描述
 * </p>
 *
 * @author migro
 * @since 2020/4/3 17:30
 */
@SpringBootApplication(scanBasePackages = {"com.migro","top.doublewin"})
@MapperScan("com.migro.jobcenter.mapper")
public class JobCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(JobCenterApplication.class, args);
    }
}
