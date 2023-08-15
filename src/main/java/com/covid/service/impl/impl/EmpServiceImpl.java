package com.covid.service.impl.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.covid.mapper.EmpMapper;
import com.covid.pojo.HealthCheckIn;
import com.covid.pojo.PageBean;
import com.covid.service.impl.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpMapper empMapper;

    @Override
    public PageBean findAll(Integer page, Integer size) {

        //设置分页参数
        PageHelper.startPage(page, size);

        //查询
        List<HealthCheckIn> empList = empMapper.list();
        for (HealthCheckIn h : empList) {
            if ("1".equals(h.getSex())) {
                h.setSex("男");
            } else {
                h.setSex("女");
            }
        }
        Page<HealthCheckIn> p = (Page<HealthCheckIn>) empList;
        //封装到PageBean
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    @Override
    public int insert(HealthCheckIn emp) {
        emp.setCreateTime(new Date());
        try {
            if (emp.getSex().equals("男")) {
                emp.setSex("1");
            } else emp.setSex("0");
            empMapper.insert(emp);
        } catch (Exception exception) {
            return 0;
        }
        return 1;
    }

    @Override
    public HealthCheckIn selectById(Integer id) {
        HealthCheckIn emp = empMapper.selectById(id);
        if ("1".equals(emp.getSex())) {
            emp.setSex("男");
        } else {
            emp.setSex("女");
        }
        return emp;
    }

    @Override
    public int updateById(HealthCheckIn emp) {

        try {
            if (emp.getSex().equals("男")) {
                emp.setSex("1");
            } else emp.setSex("0");
            empMapper.updateById(emp);
        } catch (Exception exception) {
            return 0;
        }
        return 1;
    }

    @Override
    public void deleteById(long id) {
        empMapper.deleteById(id);
    }

    @Override
    public List<HealthCheckIn> search(String searchkey, String stext) {
        List<HealthCheckIn> empList = empMapper.search(searchkey, stext);
        for (HealthCheckIn h : empList) {
            if ("1".equals(h.getSex())) {
                h.setSex("男");
            } else {
                h.setSex("女");
            }
        }
        return empList;
    }
}
