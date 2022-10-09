package com.econ.springboot.tdengine.demo.mybatis;

import com.econ.springboot.tdengine.demo.mybatis.dao.WeatherMapper;
import com.econ.springboot.tdengine.demo.mybatis.domain.Weather;
import com.econ.springboot.tdengine.demo.mybatis.service.WeatherService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

@SpringBootTest
class SpringbootTdengineDemoMybatisApplicationTests {
    @Resource
    WeatherService weatherService;
    @Resource
    WeatherMapper weatherMapper;
    @Resource(name = "taskExecutor")
    ThreadPoolTaskExecutor threadPoolTaskExecutor;

    private Random random = new Random(System.currentTimeMillis());
    private String[] locations = {"北京", "上海", "广州", "深圳", "天津"};

    @Test
    void test() {
        List<Weather> weathers = weatherMapper.selectAll();
        System.out.println(weathers.size());
    }

    @Test
    void test1() {
        weatherService.init();
    }

    @Test
    void test2() {
        List<Weather> select = weatherMapper.select(10L, 5000000L);
        select.forEach(System.out::println);
    }

    @Test
    void testGetSubTables() {
        List<String> subTables = weatherMapper.getSubTables();
        subTables.forEach(System.out::println);
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

    /**
     * 测试，使用线程池批量插入
     */
    @Test
    void testInsertByThreadPoolTask(){
        long start = System.currentTimeMillis();
        for(int i = 0;i < 10000;i++) {
            threadPoolTaskExecutor.submit(new BatchInsertTask());
        }
        long end = System.currentTimeMillis();
        System.out.println("总用时：" + (end-start));
    }

    class BatchInsertTask implements Callable<Long>{
        @Override
        public Long call() {
            long ts = System.currentTimeMillis();
            long thirtySec = 1000 * 30;
            List<Weather> list = new LinkedList();
            Weather weather = null;
            for (int i = 0; i < 10000; i++) {
                weather = new Weather(new Timestamp(ts + (thirtySec * i)), 30 * random.nextFloat(), random.nextInt(100));
                weather.setLocation(locations[random.nextInt(locations.length)]);
                weather.setGroupId(i % locations.length);
                list.add(weather);
            }
            long start = System.currentTimeMillis();
            weatherMapper.insertBatch(list);
            long end = System.currentTimeMillis();
            System.out.println("插入数据用时: " + (end-start));
            return end - start;
        }
    }

    /**
     * 单线程插入1亿条数据，
     * 循环1万次，每次批量插入10000条数据
     */
    @Test
    void testInsert(){
        long totalTime = 0;
        for(int j = 0;j < 10000;j++) {
            long ts = System.currentTimeMillis();
            long thirtySec = 1000 * 30;
            List<Weather> list = new LinkedList();
            Weather weather = null;
            for (int i = 0; i < 10; i++) {
                weather = new Weather(new Timestamp(ts + (thirtySec * i)), 30 * random.nextFloat(), random.nextInt(100));
                weather.setLocation(locations[random.nextInt(locations.length)]);
                weather.setGroupId(i % locations.length);
                list.add(weather);
            }
            long start = System.currentTimeMillis();
            weatherMapper.insertBatch(list);
            long end = System.currentTimeMillis();
            System.out.println("插入数据用时: " + (end-start));
            totalTime = totalTime + (end - start);
        }
        System.out.println("插入数据总用时：" + totalTime);
    }
}
