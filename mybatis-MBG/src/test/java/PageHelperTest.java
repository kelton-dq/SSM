import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import mybatis.mapper.EmpMapper;
import mybatis.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Copyright (C), 2020-2022, XDU
 * FileName: PageHelperTest
 * Author: Dingq
 * Date: 2022/5/25 21:39
 * Description:
 */

public class PageHelperTest {

    @Test
    public void testPageHelper() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //index = (pageNum - 1) * pageSize
        //访问第一页，每页两条数据，在查询之前开启分页功能
        Page<Object> page = PageHelper.startPage(1, 2);
        System.out.println(page);
        List<Emp> emps = mapper.selectByExample(null);
        emps.forEach(System.out::println);
    }
}