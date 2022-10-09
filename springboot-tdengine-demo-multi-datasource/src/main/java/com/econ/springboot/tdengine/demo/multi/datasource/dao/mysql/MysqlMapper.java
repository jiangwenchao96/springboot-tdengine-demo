package com.econ.springboot.tdengine.demo.multi.datasource.dao.mysql;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author tanglin
 * @date 2020/8/18 14:59
 */
@Repository
public interface MysqlMapper {
    Map selectOne();
}
