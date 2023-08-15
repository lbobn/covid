package com.covid.mapper;

import com.covid.pojo.HealthCheckIn;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmpMapper {
    @Select("select count(*) from health_check_in")
    long count();

    @Insert("INSERT INTO health_check_in (name, sex, phonenum, temp, risk, health, content, depart,createTime) VALUES (#{name}, #{sex}, #{phonenum}, #{temp}, #{risk}, #{health}, #{content}, #{depart},#{createTime})")
    void insert(HealthCheckIn emp);

    @Select("select * from health_check_in where id = #{id}")
    HealthCheckIn selectById(Integer id);

    @Update("UPDATE health_check_in  SET name = #{name}, sex = #{sex}, phonenum = #{phonenum}, temp = #{temp}, risk = #{risk}, health = #{health}, content = #{content}, depart = #{depart},createTime = #{createTime} WHERE id = #{id}")
    void updateById(HealthCheckIn emp);

    @Delete("DELETE from health_check_in WHERE id = #{id} ")
    void deleteById(long id);

    @Select("select * from health_check_in where ${searchkey} like CONCAT('%',#{stext},'%')")
    List<HealthCheckIn> search(String searchkey, String stext);

    @Select("select * from health_check_in")
    List<HealthCheckIn> list();
}
