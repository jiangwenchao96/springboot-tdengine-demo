package com.econ.springboot.tdengine.demo.multi.datasource.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class Weather {
    private Timestamp ts;
    private Float temperature;
    private Float humidity;
    private String location;
    private int groupId;

    public Weather(Timestamp ts, float temperature, float humidity) {
        this.ts = ts;
        this.temperature = temperature;
        this.humidity = humidity;
    }



}
