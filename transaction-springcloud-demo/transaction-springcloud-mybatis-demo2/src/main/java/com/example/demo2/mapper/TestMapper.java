package com.example.demo2.mapper;

import com.example.demo2.pojo.Test;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author xuezhijian
 * @date 2018/10/21 下午8:59
 * @description
 */
public interface TestMapper {


    @Select("SELECT * FROM t_test")
    List<Test> findAll();

    @Insert("INSERT INTO t_test(NAME) VALUES(#{name})")
    int save(@Param("name") String name);

}
