package com.covid.mapper;

import com.covid.pojo.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DepartMapper {

    @Select("select * from department")
    List<Department> selectList();

    @Insert("INSERT INTO department (id,name,charge) VALUES (#{id},#{name},#{charge})")
    void insert(Department emp);

    @Select("select * from department where id = #{id}")
    Department selectById(Integer id);

    @Update("UPDATE department  SET name = #{name}, charge = #{charge} WHERE id = #{id}")
    void updateById(Department emp);

    @Delete("DELETE from department WHERE id = #{id} ")
    void deleteById(long id);

}
