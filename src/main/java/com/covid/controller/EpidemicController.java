package com.covid.controller;


import com.covid.pojo.*;
import com.covid.service.impl.EpidemicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empiden")
public class EpidemicController {

    @Autowired
    EpidemicService epidemicService;

    //    分页查询
    @GetMapping("/findAll/{page}/{size}")
    public Result findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        PageBean pageBean = epidemicService.findAll(page, size);
        return Result.success(pageBean);
    }


    @PostMapping("/save")
    public String save(@RequestBody Epidemic empIden) {
        int result = epidemicService.insert(empIden);
        if (result == 1) {
            return "success";
        } else {
            return "error";
        }
    }

    @GetMapping("/LineVO")
    public Result getLineVO() {
        return Result.success(epidemicService.lineVOList());
    }

    @GetMapping("/PieVO")
    public Result getPieVO() {
        return Result.success(epidemicService.pieVOMap());
    }

    @GetMapping("/findById/{id}")
    public Result findById(@PathVariable("id") Integer id) {
        return Result.success(epidemicService.selectById(id));
    }

    @PutMapping("/update")
    public String update(@RequestBody Epidemic empIden) {

        int result = epidemicService.updateById(empIden);
        if (result == 1) {
            return "success";
        } else {
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        epidemicService.deleteById(id);
    }

    @GetMapping("/search/{searchkey}/{stext}")
    public Result search(@PathVariable("searchkey") String searchkey, @PathVariable("stext") String stext) {
        return Result.success(epidemicService.search(searchkey, stext));
    }
}

