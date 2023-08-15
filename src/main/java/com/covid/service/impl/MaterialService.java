package com.covid.service.impl;

import com.covid.pojo.Material;
import com.covid.pojo.PageBean;

import java.util.List;

public interface MaterialService {

    PageBean findAll(Integer page, Integer size);

    int insert(Material emp);

    Material selectById(Integer id);

    int updateById(Material emp);

    void deleteById(Long id);

    List<Material> search(String searchkey, String stext);
}
