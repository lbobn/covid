package com.covid.controller;

import com.covid.pojo.Material;
import com.covid.pojo.PageBean;
import com.covid.pojo.Result;
import com.covid.service.impl.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Material")
public class MaterialController {

    @Autowired
    MaterialService materialService;

    @GetMapping("/findAll/{page}/{size}")
    public Result findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        PageBean pageBean = materialService.findAll(page, size);
        return Result.success(pageBean);
    }


    @PostMapping("/save")
    public String save(@RequestBody Material emp) {
        int result = materialService.insert(emp);
        if (result == 1) {
            return "success";
        } else {
            return "error";
        }
    }

    @GetMapping("/findById/{id}")
    public Result findById(@PathVariable("id") Integer id) {
        Material material = materialService.selectById(id);
        return Result.success(material);
//        return materialService.selectById(id);
    }

    @PutMapping("/update")
    public String update(@RequestBody Material emp) {
        int result = materialService.updateById(emp);
        if (result == 1) {
            return "success";
        } else {
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        materialService.deleteById(id);
    }

    @GetMapping("/search/{searchkey}/{stext}")
    public Result search(@PathVariable("searchkey") String searchkey, @PathVariable("stext") String stext) {
        List<Material> empList = materialService.search(searchkey, stext);
        return Result.success(empList);
    }
}
