package com.covid.controller;

import com.covid.mapper.UserMapper;
import com.covid.pojo.Result;
import com.covid.pojo.User;
import com.covid.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.covid.utils.MD5Util;

import java.util.List;

@RestController
@RequestMapping("/userlogin")
public class LoginController {
    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @PostMapping("/user")
    public User login(@RequestBody User loginform) {
//        System.err.println("-------------------------------------------------------------");
        String message = userService.login(loginform);
//        System.out.println(message);

        if ("success".equals(message)) {
//            Map<String,Object> map = new HashMap<>();
//            map.put("username",loginform.getUsername());
            List<User> users = userMapper.selectUser(loginform.getUsername());
            return users.get(0);
        } else {
            return new User();
        }
    }

    @GetMapping("/list")
    public Result findAll() {
        /*Page<User> page1= new Page<>(1,100);
        Page<User> result0=mapper.selectPage(page1,null*//*,wrapper*//*);*/
        List<User> users = userMapper.selectList();
        for (int i = 0; i < users.size(); i++) {
            users.get(i).setPassword(MD5Util.convertMD5(users.get(i).getPassword()));
        }
//        Page<User> result = new Page<User>();
//        result.setRecords(users);

        return Result.success(users);
    }

    @PostMapping("/register")
    public String register(@RequestBody User reUser) {
        String message = userService.register(reUser);
        return message;
    }

    @GetMapping("/selectById/{id}")
    public Result findById(@PathVariable("id") Integer id) {
        User user = userService.selectById(id);
//        user.setPassword(DigestUtils.digestAsHexString(user.getPassword()));
        user.setPassword(MD5Util.convertMD5(user.getPassword()));
        return Result.success(user);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }

    @PostMapping("/update")
    public String update(@RequestBody User user) {
        //密码加密存储
//        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        user.setPassword(MD5Util.convertMD5(user.getPassword()));
        int result = userService.updateById(user);
        //密码加密
//        String password= DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        if (result == 1) {
            return "success";
        } else {
            return "error";
        }
    }

    @PostMapping("/save")
    public String save(@RequestBody User user) {
//        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        String result = userService.register(user);
        return result;
    }
}
