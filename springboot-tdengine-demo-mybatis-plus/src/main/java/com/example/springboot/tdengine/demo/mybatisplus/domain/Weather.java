package com.example.springboot.tdengine.demo.mybatisplus.domain;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Weather {
    private Timestamp ts;
    private Float temperature;
    private Float humidity;
    private String location;
    private int groupId;

}
