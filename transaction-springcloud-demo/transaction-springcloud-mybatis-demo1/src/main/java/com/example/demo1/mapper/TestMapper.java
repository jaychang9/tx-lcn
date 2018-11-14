package com.example.demo1.mapper;

import com.example.demo1.pojo.Test;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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


    @Update("UPDATE t_test set balance = #{balance},version = #{version}+1 WHERE id = #{id} AND version = #{version}")
    int updateBalanceById(Test test);

    @Select("SELECT * FROM t_test WHERE id = #{id}")
    Test selectById(@Param("id") Long accountId);
}
