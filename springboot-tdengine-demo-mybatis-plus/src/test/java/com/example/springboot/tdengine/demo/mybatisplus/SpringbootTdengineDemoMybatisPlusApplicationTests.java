package com.example.springboot.tdengine.demo.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.springboot.tdengine.demo.mybatisplus.domain.Weather;
import com.example.springboot.tdengine.demo.mybatisplus.mapper.WeatherMapper;
import com.example.springboot.tdengine.demo.mybatisplus.service.WeatherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@SpringBootTest
class SpringbootTdengineDemoMybatisPlusApplicationTests {
    @Autowired
    WeatherMapper weatherMapper;
    @Autowired
    WeatherService weatherService;

    private Random random = new Random(System.currentTimeMillis());
    private String[] locations = {"北京", "上海", "广州", "深圳", "天津"};

    @Test
    void test1() {
        LambdaQueryWrapper<Weather> wrapper = Wrappers.<Weather>lambdaQuery().eq(Weather::getGroupId, 0);
        List<Weather> weathers = weatherMapper.selectList(wrapper);
        weathers.forEach(System.out::println);
    }
}
