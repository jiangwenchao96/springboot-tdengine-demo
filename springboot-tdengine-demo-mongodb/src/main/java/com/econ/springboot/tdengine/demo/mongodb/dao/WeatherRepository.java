package com.econ.springboot.tdengine.demo.mongodb.dao;

import com.econ.springboot.tdengine.demo.mongodb.domain.Weather;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WeatherRepository extends MongoRepository<Weather, String> {
}
