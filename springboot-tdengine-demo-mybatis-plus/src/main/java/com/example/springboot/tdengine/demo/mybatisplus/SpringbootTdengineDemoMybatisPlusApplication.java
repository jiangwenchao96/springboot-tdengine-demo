package com.example.springboot.tdengine.demo.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.springboot.tdengine.demo.mybatisplus.mapper")
public class SpringbootTdengineDemoMybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTdengineDemoMybatisPlusApplication.class, args);
    }

}
