package com.sailheader.testng;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan("com.sailheader.testng.mapper") // 扫描Mapper接口
@Slf4j
public class TestngApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(TestngApplication.class, args);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            //log.info("BeanDefinitionName: {}", beanDefinitionName);
            System.out.println("BeanDefinitionName: " + beanDefinitionName);
        }
    }

}
