package com.covid.service.impl.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.covid.mapper.EpidemicMapper;
import com.covid.pojo.*;
import com.covid.service.impl.EpidemicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class EpidemicServiceImol implements EpidemicService {

    @Autowired
    EpidemicMapper epidemicMapper;

    @Override
    public PageBean findAll(Integer page, Integer size) {

        //设置分页参数
        PageHelper.startPage(page, size);

        //查询
        List<Epidemic> empList = epidemicMapper.list();
        for (Epidemic i : empList) {
            if ("1".equals(i.getSex())) {
                i.setSex("男");
            } else i.setSex("女");
        }
        Page<Epidemic> p = (Page<Epidemic>) empList;
        //封装到PageBean
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    @Override
    public int insert(Epidemic emp) {
        emp.setRegister(new Date());
        try {
            if (emp.getSex().equals("男")) {
                emp.setSex("1");
            } else emp.setSex("0");
            epidemicMapper.insert(emp);
        } catch (Exception exception) {
            return 0;
        }
        return 1;
    }

    @Override
    public LineVO lineVOList() {
        LineVO lineVOList = new LineVO();
        List<VO> voList = epidemicMapper.lineVOList();
        Map<String, List> map = new HashMap<>();
        String[] strings = {"确诊", "治愈", "疑似", "隔离", "死亡"};
        for (int i = 0; i < 5; i++) {
            map.put(strings[i], new ArrayList<>());
            for (int j = 0; j < 7; j++) {
                map.get(strings[i]).add(0);
            }
        }
//        1.把月份求出放到集合；
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        List list = new ArrayList();
        Date d1;
        Calendar rightNow = Calendar.getInstance();
        for (int i = 7; i > 0; i--) {
            d1 = rightNow.getTime();
            list.add(0, simpleDateFormat.format(d1));
            rightNow.add(Calendar.MONTH, -1);
        }
//        2.把健康状态放到集合；
        for (VO vo : voList) {
            String s = simpleDateFormat.format(vo.getIdate());
            for (int i = 0; i < 7; i++) {
                if (s.equals(list.get(i))) {
                    for (int j = 0; j < 5; j++) {
                        if (vo.getStatus().equals(strings[j])) {
                            int temp = (int) map.get(strings[j]).get(i);
                            map.get(strings[j]).set(i, temp + 1);
                            break;
                        }
                    }
                    break;
                }
            }
        }
//        3.封装
        lineVOList.setMonth(list);
        lineVOList.setStatus(map);
        return lineVOList;
    }

    @Override
    public Epidemic selectById(Integer id) {
        Epidemic e = epidemicMapper.selectById(id);
        if ("1".equals(e.getSex())) {
            e.setSex("男");
        } else e.setSex("女");

        return e;
    }

    @Override
    public int updateById(Epidemic empIden) {
        try {
            if (empIden.getSex().equals("男")) {
                empIden.setSex("1");
            } else empIden.setSex("0");
            epidemicMapper.updateById(empIden);
        } catch (Exception exception) {
            return 0;
        }
        return 1;
    }

    @Override
    public void deleteById(Long id) {
        epidemicMapper.deleteById(id);
    }

    @Override
    public List<Epidemic> search(String searchkey, String stext) {
        List<Epidemic> epidemics = epidemicMapper.search(searchkey, stext);
        for (Epidemic i : epidemics) {
            if ("1".equals(i.getSex())) {
                i.setSex("男");
            } else i.setSex("女");
        }
        return epidemics;
    }

    @Override
    public List<PieVo> pieVOMap() {
        List<PieVo> pielist = new ArrayList<>();
        List<Material> list = epidemicMapper.selectList();
        for (Material mat : list) {
            PieVo pieVo = new PieVo();
            pieVo.setName(mat.getName());
            pieVo.setValue(mat.getCount());
            pielist.add(pieVo);
        }
        return pielist;
    }
}
