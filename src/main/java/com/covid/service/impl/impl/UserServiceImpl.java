package com.covid.service.impl.impl;

import com.covid.mapper.UserMapper;
import com.covid.pojo.User;
import com.covid.service.impl.UserService;
import com.covid.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public String login(User loginform) {
        List<User> list = userMapper.selectUser(loginform.getUsername());
        if (list.size() != 0) {
            //密码加密
//            String password= DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
            String password = MD5Util.convertMD5(loginform.getPassword());
            if (list.get(0).getPassword().equals(password)) {
                return "success";
            } else return "error";

        } else return "error";
    }

    @Override
    public String register(User reUser) {

        if (reUser != null) {
            int result = userMapper.findUsername(reUser.getUsername());
        /*for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUsername().equals(reUser.getUsername()))
                return "error";
        }*/
            if (result == 1) {
                return "repeat";
            } else {
                String pw = MD5Util.convertMD5(reUser.getPassword());
//                String pw=DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
                reUser.setPassword(pw);
                userMapper.insert(reUser);
                return "success";
            }
        } else return "error";


    }


    @Override
    public User selectById(Integer id) {
        User emp = userMapper.selectById(id);
        return emp;
    }

    @Override
    public int updateById(User emp) {
        try {
            userMapper.updateById(emp);
        } catch (Exception exception) {
            return 0;
        }
        return 1;
    }

    @Override
    public void deleteById(long id) {
        userMapper.deleteById(id);
    }

}
