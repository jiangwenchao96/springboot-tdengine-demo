package com.econ.springboot.tdengine.demo.mongodb;

import com.econ.springboot.tdengine.demo.mongodb.domain.Weather;
import com.econ.springboot.tdengine.demo.mongodb.service.WeatherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@SpringBootTest
class SpringbootTdengineDemoMongodbApplicationTests {

    @Autowired
    private WeatherService weatherService;

    private Random random = new Random(System.currentTimeMillis());
    private String[] locations = {"北京", "上海", "广州", "深圳", "天津"};

    @Test
    void contextLoads() {
    }

    @Test
    void testInsert() {
        long totalTime = 0;
        for(int j = 0;j < 1;j++) {
            long ts = System.currentTimeMillis();
            long thirtySec = 1000 * 30;
            List<Weather> list = new LinkedList();
            Weather weather = null;
            for (int i = 0; i < 1; i++) {
                weather = new Weather();
                weather.setTs(new Timestamp(ts + (thirtySec * i)));
                weather.setTemperature(30 * random.nextFloat());
                weather.setHumidity((float) random.nextInt(100));
                weather.setLocation(locations[random.nextInt(locations.length)]);
                weather.setGroupId(i % locations.length);
                list.add(weather);
            }
            long start = System.currentTimeMillis();
            weatherService.insert(list);
            long end = System.currentTimeMillis();
            System.out.println("插入数据用时: " + (end-start));
            totalTime = totalTime + (end - start);
        }
        System.out.println("插入数据总用时：" + totalTime);
    }
}
