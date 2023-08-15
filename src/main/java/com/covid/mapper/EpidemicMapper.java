package com.covid.mapper;

import com.covid.pojo.Epidemic;
import com.covid.pojo.Material;
import com.covid.pojo.VO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EpidemicMapper {
    @Select("select count(*) from epidemic")
    long count();

    /*@Select("select * from epidemic limit #{start},#{pageSize};")
    List<Epidemic> findAll(Integer start , Integer pageSize);*/

    @Insert("INSERT INTO epidemic (id ,name, sex, idcard,idate, place, phonenum,status , depart , register) VALUES (#{id},#{name}, #{sex}, #{idcard}, #{idate}, #{place}, #{phonenum}, #{status},#{depart}, #{register})")
    void insert(Epidemic emp);

    @Select("select idate , status from epidemic;")
    List<VO> lineVOList();

    @Select("select * from epidemic where id = #{id}")
    Epidemic selectById(Integer id);

    @Update("UPDATE epidemic  SET name = #{name}, sex = #{sex}, idcard = #{idcard},idate= #{idate}, place= #{place}, phonenum= #{phonenum},status= #{status} , depart= #{depart} , register= #{register} WHERE id = #{id}")
    void updateById(Epidemic empIden);

    @Delete("DELETE from epidemic WHERE id = #{id} ")
    void deleteById(Long id);

    @Select("select * from epidemic where ${searchkey} like CONCAT('%',#{stext},'%')")
    List<Epidemic> search(String searchkey, String stext);

    @Select("select * from material_manage")
    List<Material> selectList();

    @Select("select * from epidemic")
    List<Epidemic> list();
}
