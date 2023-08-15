package com.covid.service.impl.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.covid.mapper.MaterialMapper;
import com.covid.pojo.Material;
import com.covid.pojo.PageBean;
import com.covid.service.impl.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service

public class MaterialServiceImpl implements MaterialService {
    @Autowired
    MaterialMapper materialMapper;

    @Override
    public PageBean findAll(Integer page, Integer size) {

        //设置分页参数
        PageHelper.startPage(page, size);

        //查询
        List<Material> empList = materialMapper.list();
        for (Material material : empList) {
            if ("1".equals(material.getIsImp())) {
                material.setIsImp("是");
            } else {
                material.setIsImp("否");
            }
        }
        Page<Material> p = (Page<Material>) empList;
        //封装到PageBean
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    @Override
    public int insert(Material emp) {
        emp.setUpdateTime(new Date());
        try {
            if ("是".equals(emp.getIsImp())) {
                emp.setIsImp("1");
            } else {
                emp.setIsImp("0");
            }
            materialMapper.insert(emp);

        } catch (Exception exception) {
            return 0;
        }
        return 1;
    }

    @Override
    public Material selectById(Integer id) {
        Material emp = materialMapper.selectById(id);
        if ("1".equals(emp.getIsImp())) {
            emp.setIsImp("是");
        } else {
            emp.setIsImp("否");
        }
        return emp;
    }

    @Override
    public int updateById(Material emp) {
        emp.setUpdateTime(new Date());
        try {
            if ("是".equals(emp.getIsImp())) {
                emp.setIsImp("1");
            } else {
                emp.setIsImp("0");
            }
            materialMapper.updateById(emp);
        } catch (Exception exception) {
            return 0;
        }
        return 1;
    }

    @Override
    public void deleteById(Long id) {
        materialMapper.deleteById(id);
    }

    @Override
    public List<Material> search(String searchkey, String stext) {
        List<Material> list = materialMapper.search(searchkey, stext);
        for (Material material : list) {
            if ("1".equals(material.getIsImp())) {
                material.setIsImp("是");
            } else {
                material.setIsImp("否");
            }
        }
        return list;
    }

}
