import mybatis.mapper.ParameterMapper;
import mybatis.mapper.SelectMapper;
import mybatis.mapper.SpecialMapper;
import mybatis.mapper.UserMapper;
import mybatis.pojo.User;
import mybatis.util.SqlSessionUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2020-2022, XDU
 * FileName: MyBatisTest
 * Author: Dingq
 * Date: 2022/5/22 17:59
 * Description:
 */

public class MyBatisTest {

    @Test
    public void testMyBatis() throws IOException {
        //读取MyBatis的核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //通过核心配置文件所对应的字节输入流创建工厂类SqlSessionFactory，生产SqlSession对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取sqlSession，此时通过SqlSession对象所操作的sql都必须手动提交或回滚事务
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建SqlSession对象，此时通过SqlSession对象所操作的sql都会自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，
        // 通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句
        int result = userMapper.insertUser();
        //提交事务
        //sqlSession.commit();
        System.out.println("result:" + result);
    }
    
    @Test
    public void testCRUD() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        userMapper.updateUser();
//        userMapper.deleteUser();
//        User user = userMapper.getUserById();
        List<User> users = userMapper.getAllUser();
        users.forEach(System.out::println);
    }
    
    @Test
    public void testParameter() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        ParameterMapper parameterMapper = sqlSession.getMapper(ParameterMapper.class);
//        List<User> userList = parameterMapper.getAllUser();
//        userList.forEach(System.out::println);
//        User user = parameterMapper.getUserByUsername("admin");
        User user = parameterMapper.CheckLoginByParam("admin", "123");
        System.out.println(user);
        parameterMapper.insertUser(new User(null,"Tom","123456","男",22,"tom@321.com"));
    }
    
    @Test
    public void testSelect() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user = mapper.getUserById(1);
        Map<String, Object> user1 = mapper.getUserToMap(1);
        Map<String, Object> map = mapper.getAllUserToMap();
        System.out.println(user);
        System.out.println(user1);
        System.out.println(map);
    }

    @Test
    public void testSpecialSQL() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialMapper mapper = sqlSession.getMapper(SpecialMapper.class);
        int res = mapper.deleteMore("2,4");
        System.out.println(res);
        List<User> userList = mapper.getUserByLike("a");
        System.out.println(userList);
        List<User> table = mapper.getUserByTable("t_user");
        System.out.println(table);
    }

    @Test
    public void insertUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialMapper mapper = sqlSession.getMapper(SpecialMapper.class);
        User user = new User(null, "ton", "123","男", 23,  "123@321.com");
        mapper.insertUser(user);
        System.out.println(user);//id属性被赋值
    }
}