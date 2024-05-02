package com.sailheader.testng.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.sailheader.testng.mapper")
public class MybatisPlusConfig {

}
