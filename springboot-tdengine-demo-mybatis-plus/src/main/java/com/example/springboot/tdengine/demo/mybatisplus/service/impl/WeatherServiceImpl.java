package com.example.springboot.tdengine.demo.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.tdengine.demo.mybatisplus.domain.Weather;
import com.example.springboot.tdengine.demo.mybatisplus.mapper.WeatherMapper;
import com.example.springboot.tdengine.demo.mybatisplus.service.WeatherService;
import org.springframework.stereotype.Service;

/**
 * @author jwc
 * @date 2022/09/21
 */
@Service
public class WeatherServiceImpl extends ServiceImpl<WeatherMapper, Weather> implements WeatherService {
}
