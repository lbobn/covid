package com.covid.service.impl;

import com.covid.pojo.Department;

import java.util.List;

public interface DepartService {
    List<String> getAll();

    Department selectById(Integer id);

    int updateById(Department emp);

    void deleteById(long id);

    int insert(Department emp);

    List<Department> list();
}
