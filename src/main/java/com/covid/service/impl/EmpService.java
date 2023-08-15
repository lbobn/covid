package com.covid.service.impl;

import com.covid.pojo.HealthCheckIn;
import com.covid.pojo.PageBean;

import java.util.List;

public interface EmpService {
    PageBean findAll(Integer page, Integer size);

    int insert(HealthCheckIn emp);

    HealthCheckIn selectById(Integer id);

    int updateById(HealthCheckIn emp);

    void deleteById(long id);

    List<HealthCheckIn> search(String searchkey, String stext);
}
