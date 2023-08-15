package com.covid.controller;

import com.covid.pojo.EmpIs;
import com.covid.pojo.PageBean;
import com.covid.pojo.Result;
import com.covid.service.impl.EmpIsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/empis")
public class EmpIsController {
    @Autowired
    EmpIsService empIsService;

    //分页查询
    @GetMapping("/findAll/{page}/{size}")
    public Result findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        PageBean pageBean = empIsService.findAll(page, size);
        return Result.success(pageBean);
    }


    @PostMapping("/save")
    public String save(@RequestBody EmpIs empis) {
        Format f = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(empis.getBegin());
        c.add(Calendar.DAY_OF_MONTH, 14);
        Date end = c.getTime();
        empis.setEnd(end);
        int result = empIsService.insert(empis);
        if (result == 1) {
            return "success";
        } else {
            return "error";
        }
    }

    @GetMapping("/findById/{id}")
    public Result findById(@PathVariable("id") Integer id) {
        return Result.success(empIsService.selectById(id));
    }

    @PutMapping("/update")
    public String update(@RequestBody EmpIs emp) {
        int result = empIsService.updateById(emp);
        if (result == 1) {
            return "success";
        } else {
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        empIsService.deleteById(id);
    }

    @GetMapping("/search/{searchkey}/{stext}")
    public Result search(@PathVariable("searchkey") String searchkey, @PathVariable("stext") String stext) {
        List<EmpIs> empList = empIsService.search(searchkey, stext);
        return Result.success(empList);
    }
}
