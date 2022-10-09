package com.econ.springboot.tdengine.demo.multi.datasource;

import com.econ.springboot.tdengine.demo.multi.datasource.domain.Weather;
import com.econ.springboot.tdengine.demo.multi.datasource.service.MysqlService;
import com.econ.springboot.tdengine.demo.multi.datasource.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootTest
class SpringbootTdengineDemoMultiDatasourceApplicationTests {
    
    @Autowired
    WeatherService weatherService;
    @Autowired
    MysqlService mysqlService;

    @Test
    void contextLoads() {
    }

    @Test
    void test() {
        List<Weather> weathers = weatherService.query(1L, 100L);
        log.info("count: {}", weathers.size());
    }
    
    @Test
    void test1() {
        Map map = mysqlService.selectOne();
        System.out.println(map);
    }
}
