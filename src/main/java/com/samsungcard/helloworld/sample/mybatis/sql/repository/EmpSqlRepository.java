package com.samsungcard.helloworld.sample.mybatis.sql.repository;

import com.samsungcard.helloworld.sample.mybatis.sql.entity.Emp;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmpSqlRepository {
    @Delete({
        "delete from EMP",
        "where EMP_ID = #{empId}"
    })
    int deleteByPrimaryKey(Integer empId);

    @Insert({
        "insert into EMP (EMP_ID, FIRST_NAME, ",
        "LAST_NAME, EMAIL)",
        "values (#{empId}, #{firstName}, ",
        "#{lastName}, #{email})"
    })
    int insert(Emp record);

    @Select({
        "select",
        "EMP_ID, FIRST_NAME, LAST_NAME, EMAIL",
        "from EMP",
        "where EMP_ID = #{empId}"
    })
    Emp selectByPrimaryKey(Integer empId);

    @Select({
        "select",
        "EMP_ID, FIRST_NAME, LAST_NAME, EMAIL",
        "from EMP"
    })
    List<Emp> selectAll();

    @Update({
        "update EMP",
        "set FIRST_NAME = #{firstName},",
          "LAST_NAME = #{lastName},",
          "EMAIL = #{email}",
        "where EMP_ID = #{empId}"
    })
    int updateByPrimaryKey(Emp record);
}
