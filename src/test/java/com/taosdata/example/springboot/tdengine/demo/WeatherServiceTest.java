package com.taosdata.example.springboot.tdengine.demo;

import com.taosdata.example.springboot.tdengine.demo.dao.WeatherMapper;
import com.taosdata.example.springboot.tdengine.demo.domain.Weather;
import com.taosdata.example.springboot.tdengine.demo.service.WeatherService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author jwc
 * @date 2022/09/20
 */
@SpringBootTest
public class WeatherServiceTest {

    @Resource
    WeatherService weatherService;
    @Resource
    WeatherMapper weatherMapper;
    @Resource(name = "taskExecutor")
    ThreadPoolTaskExecutor threadPoolTaskExecutor;

    private Random random = new Random(System.currentTimeMillis());
    private String[] locations = {"北京", "上海", "广州", "深圳", "天津"};

    @Test
    void test1() {
        weatherService.init();
    }

    @Test
    void test2() {
        List<Weather> select = weatherMapper.select(10L, 1L);
        select.forEach(t -> System.out.println(t.toString()));
    }

    @Test
    void test3() {
        long ts = System.currentTimeMillis();
        long thirtySec = 1000 * 30;
        int count = 0;
        List<Weather> list = new LinkedList();
        Weather weather = null;
        for (int i = 0; i < 10000; i++) {
            weather = new Weather(new Timestamp(ts + (thirtySec * i)), 30 * random.nextFloat(), random.nextInt(100));
            weather.setLocation(locations[random.nextInt(locations.length)]);
            weather.setGroupId(i % locations.length);
            list.add(weather);
        }
        long start = System.currentTimeMillis();
        count = weatherMapper.insertBatch(list);
        long end = System.currentTimeMillis();
        System.out.println("count: " + count);
        System.out.println("插入数据用时: " + (end-start));
    }
}
