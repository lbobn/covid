package com.covid.service.impl.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.covid.mapper.EmpIsMapper;
import com.covid.pojo.EmpIs;
import com.covid.pojo.PageBean;
import com.covid.service.impl.EmpIsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpIsServiceImpl implements EmpIsService {

    @Autowired
    EmpIsMapper empIsMapper;

    @Override
    public PageBean findAll(Integer page, Integer size) {
        //设置分页参数
        PageHelper.startPage(page, size);

        //查询
        List<EmpIs> empList = empIsMapper.list();
        for (EmpIs i : empList) {
            if ("1".equals(i.getSex())) {
                i.setSex("男");
            } else i.setSex("女");
        }
        Page<EmpIs> p = (Page<EmpIs>) empList;
        //封装到PageBean
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    @Override
    public int insert(EmpIs empis) {
        try {
            if (empis.getSex().equals("男")) {
                empis.setSex("1");
            } else empis.setSex("0");
            empIsMapper.insert(empis);
        } catch (Exception exception) {
            return 0;
        }
        return 1;
    }

    @Override
    public EmpIs selectById(Integer id) {
        EmpIs empIs = empIsMapper.selectById(id);
        if ("1".equals(empIs.getSex())) {
            empIs.setSex("男");
        } else {
            empIs.setSex("女");
        }

        return empIs;
    }

    @Override
    public int updateById(EmpIs empIs) {
        try {
            if ("男".equals(empIs.getSex())) {
                empIs.setSex("1");
            } else {
                empIs.setSex("0");
            }
            empIsMapper.updateById(empIs);
        } catch (Exception exception) {
            return 0;
        }
        return 1;
    }

    @Override
    public void deleteById(Long id) {
        empIsMapper.deleteById(id);
    }

    @Override
    public List<EmpIs> search(String searchkey, String stext) {
        List<EmpIs> search = empIsMapper.search(searchkey, stext);
        for (EmpIs i : search) {
            if ("1".equals(i.getSex())) {
                i.setSex("男");
            } else i.setSex("女");
        }
        return search;
    }
}
