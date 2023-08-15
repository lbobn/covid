package com.covid.mapper;

import com.covid.pojo.EmpIs;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmpIsMapper {
    @Select("select count(*) from quarantine")
    long count();

    /*@Select("select * from quarantine limit #{start},#{pageSize};")
    List<EmpIs> findAll(Integer start, Integer pageSize);*/

    @Insert("INSERT INTO quarantine (id ,name, sex, phone, temp, type, place, begin, end,leaved , arrived , content , depart) VALUES (#{id} ,#{name},#{sex},#{phone},#{temp},#{type},#{place},#{begin},#{end},#{leaved},#{arrived},#{content},#{depart}  )")
    void insert(EmpIs empis);

    @Select("select * from quarantine where id = #{id}")
    EmpIs selectById(Integer id);


    @Update("UPDATE quarantine  SET name = #{name}, sex = #{sex}, phone = #{phone}, temp = #{temp},  type = #{type}, place= #{place}, begin= #{begin}, end= #{end},leaved= #{leaved} , arrived= #{arrived} , content= #{content} , depart= #{depart} WHERE id = #{id}")
    void updateById(EmpIs emp);

    @Delete("DELETE from quarantine WHERE id = #{id} ")
    void deleteById(long id);

    @Select("select * from quarantine where ${searchkey} like CONCAT('%',#{stext},'%')")
    List<EmpIs> search(String searchkey, String stext);

    @Select("select * from quarantine")
    List<EmpIs> list();
}
