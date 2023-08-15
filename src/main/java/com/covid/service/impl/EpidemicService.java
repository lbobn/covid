package com.covid.service.impl;

import com.covid.pojo.Epidemic;
import com.covid.pojo.LineVO;
import com.covid.pojo.PageBean;
import com.covid.pojo.PieVo;

import java.util.*;

public interface EpidemicService {
    PageBean findAll(Integer page, Integer size);

    int insert(Epidemic empIden);

    LineVO lineVOList();

    Epidemic selectById(Integer id);

    int updateById(Epidemic empIden);

    void deleteById(Long id);

    List<Epidemic> search(String searchkey, String stext);

    List<PieVo> pieVOMap();
}
