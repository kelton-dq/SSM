import mybatis.mapper.DeptMapper;
import mybatis.mapper.EmpMapper;
import mybatis.pojo.Dept;
import mybatis.pojo.Emp;
import mybatis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Copyright (C), 2020-2022, XDU
 * FileName: ResultMapTest
 * Author: Dingq
 * Date: 2022/5/24 15:01
 * Description:
 */

public class ResultMapTest {

    @Test
    public void testGetAllEmp() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> emps = mapper.getAllEmp();
        emps.forEach(System.out::println);
    }

    //    <!--多对一映射 方式1&2 -->
    @Test
    public void testGetEmpAndDept() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpById(1);
        System.out.println(emp);
    }

    //    <!--多对一映射 方式3 -->
    @Test
    public void testEmpStep() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptByStepOne(3);
        System.out.println(emp.getEmpName());
        System.out.println(emp.getDept());
    }

    //    <!--一对多映射 方式1 -->
    @Test
    public void testGetDeptAndEmp() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmp(1);
        System.out.println(dept);
    }

    //    <!--一对多映射 方式2 -->
    @Test
    public void testDeptStep() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmpByStepOne(2);
        System.out.println(dept);
    }
}