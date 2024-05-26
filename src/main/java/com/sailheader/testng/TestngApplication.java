package com.sailheader.testng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sailheader.testng.mapper") // 扫描Mapper接口
public class TestngApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestngApplication.class, args);
    }

}
