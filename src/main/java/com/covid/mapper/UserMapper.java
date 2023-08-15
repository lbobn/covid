package com.covid.mapper;


import com.covid.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user where username=#{username}")
    List<User> selectUser(String username);

    @Select("select count(*) from user where username=#{username}")
    Integer findUsername(String username);

    @Insert("INSERT into user values (null,#{username},#{password},#{depart},#{isAdministrator})")
    void insert(User reUser);

    @Select("select * from user where id = #{id}")
    User selectById(Integer id);

    @Update("UPDATE user  SET username = #{username} , password = #{password} , depart = #{depart} , is_administrator = #{isAdministrator} WHERE id = #{id}")
    void updateById(User emp);

    @Delete("DELETE from user WHERE id = #{id} ")
    void deleteById(long id);

    @Select("SELECT * from user")
    List<User> selectList();
}
