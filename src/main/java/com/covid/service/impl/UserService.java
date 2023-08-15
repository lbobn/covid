package com.covid.service.impl;

import com.covid.pojo.User;

public interface UserService {
    String login(User loginform);

    String register(User reUser);

    User selectById(Integer id);

    int updateById(User emp);

    void deleteById(long id);
}
