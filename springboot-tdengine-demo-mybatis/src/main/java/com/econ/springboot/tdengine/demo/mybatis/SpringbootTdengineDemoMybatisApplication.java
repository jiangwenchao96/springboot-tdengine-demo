package com.econ.springboot.tdengine.demo.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"com.econ.springboot.tdengine.demo.mybatis.dao"})
@SpringBootApplication
public class SpringbootTdengineDemoMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTdengineDemoMybatisApplication.class, args);
    }

}
