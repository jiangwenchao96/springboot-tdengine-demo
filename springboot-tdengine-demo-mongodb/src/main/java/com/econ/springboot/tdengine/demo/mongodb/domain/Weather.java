package com.econ.springboot.tdengine.demo.mongodb.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("weather")
public class Weather {
    //@MongoId
    private Timestamp ts;
    private Float temperature;
    private Float humidity;
    private String location;
    private int groupId;

}
