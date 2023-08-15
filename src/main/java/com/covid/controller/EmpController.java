package com.covid.controller;


import com.covid.pojo.HealthCheckIn;
import com.covid.pojo.PageBean;
import com.covid.pojo.Result;
import com.covid.service.impl.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmpService empService;

    //分页查询
    @GetMapping("/findAll/{page}/{size}")
    public Result findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        PageBean pageBean = empService.findAll(page, size);
        return Result.success(pageBean);
    }


    @PostMapping("/save")
    public String save(@RequestBody HealthCheckIn emp) {
        int result = empService.insert(emp);
        if (result == 1) {
            return "success";
        } else {
            return "error";
        }
    }

    @GetMapping("/findById/{id}")
    public Result findById(@PathVariable("id") Integer id) {
        return Result.success(empService.selectById(id));
    }

    @PutMapping("/update")
    public String update(@RequestBody HealthCheckIn emp) {
        int result = empService.updateById(emp);
        if (result == 1) {
            return "success";
        } else {
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        empService.deleteById(id);
    }

    @GetMapping("/search/{searchkey}/{stext}")
    public Result search(@PathVariable("searchkey") String searchkey, @PathVariable("stext") String stext) {
        List<HealthCheckIn> empList = empService.search(searchkey, stext);
        return Result.success(empList);
    }
}
