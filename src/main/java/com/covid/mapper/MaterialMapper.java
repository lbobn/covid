package com.covid.mapper;

import com.covid.pojo.Material;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MaterialMapper {
    @Select("select count(*) from material_manage")
    long count();

    /*@Select("select * from material_manage limit #{start},#{pageSize};")
    List<Material> findAll(Integer start, Integer pageSize);*/

    @Insert("INSERT INTO material_manage (id , name , count , type , isImp , charge , cnum , updateTime) VALUES (#{id} , #{name} , #{count} , #{type} , #{isImp} , #{charge} , #{cnum} , #{updateTime} )")
    void insert(Material emp);

    @Select("select * from material_manage where id = #{id}")
    Material selectById(Integer id);

    @Update("UPDATE material_manage  SET name = #{name} , count= #{count} , type= #{type} ,isImp= #{isImp} , charge= #{charge} , cnum= #{cnum} , updateTime = #{updateTime} " +
            "WHERE id = #{id}")
    void updateById(Material emp);

    @Delete("DELETE from material_manage WHERE id = #{id} ")
    void deleteById(long id);

    @Select("select * from material_manage where ${searchkey} like CONCAT('%',#{stext},'%')")
    List<Material> search(String searchkey, String stext);

    @Select("select * from material_manage")
    List<Material> list();
}
