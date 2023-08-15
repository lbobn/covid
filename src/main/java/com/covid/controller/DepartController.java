package com.covid.controller;

import com.covid.pojo.Department;
import com.covid.pojo.Result;
import com.covid.service.impl.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/depart")
public class DepartController {

    @Autowired
    DepartService service;

    @GetMapping("/findAll")
    private Result findAll() {
        return Result.success(service.getAll());
    }

    @GetMapping("/list")
    public Result list() {
        List<Department> pageBean = service.list();
        return Result.success(pageBean);
    }

    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable("id") Integer id) {

        return Result.success(service.selectById(id));
    }

    @PostMapping("/update")
    public String update(@RequestBody Department department) {
        int result = service.updateById(department);
        if (result == 1) {
            return "success";
        } else {
            return "error";
        }
    }

    @PostMapping("/save")
    public String save(@RequestBody Department department) {
        System.err.println(department.getId());
        department.setId(0);
        int result = service.insert(department);
        if (result == 1) {
            return "success";
        } else {
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
    }
}
