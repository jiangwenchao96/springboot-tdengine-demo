package com.econ.springboot.tdengine.demo.mongodb.service;

import com.econ.springboot.tdengine.demo.mongodb.domain.Weather;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jwc
 * @date 2022/09/26
 */
@Service
@RequiredArgsConstructor
public class WeatherService {
    private final MongoTemplate mongoTemplate;

    /**
     * 将数据存入MongoDB
     * @param weathers
     */
    public void insertAll(List<Weather> weathers) {
        // insert(): 若新增数据的主键已经存在，则会抛异常提示主键重复，不保存当前数据。可批处理
        // save(): 若新增数据的主键已经存在，则会对当前已经存在的数据进行修改操作。
        mongoTemplate.insertAll(weathers);
    }

    public void insert(List<Weather> weathers) {
        // insert(): 若新增数据的主键已经存在，则会抛异常提示主键重复，不保存当前数据。可批处理
        // save(): 若新增数据的主键已经存在，则会对当前已经存在的数据进行修改操作。
        mongoTemplate.insert(weathers, "weather");
    }

    /**
     * 查找Story集合的所有文档
     * @return
     */
    public List<Weather> findAllWeather(){
        return mongoTemplate.findAll(Weather.class);
    }
}
