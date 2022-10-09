package com.econ.springboot.tdengine.demo.multi.datasource.dao.tdengine;
import com.econ.springboot.tdengine.demo.multi.datasource.domain.Weather;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeatherMapper {

    void dropDB();

    void createDB();

    void createSuperTable();

    void createTable(Weather weather);

    List<Weather> select(@Param("limit") Long limit, @Param("offset") Long offset);

    List<Weather> selectAll();

    int insert(Weather weather);

    int insertBatch(List<Weather> weatherList);

    int count();

    List<String> getSubTables();

    List<Weather> avg();

}