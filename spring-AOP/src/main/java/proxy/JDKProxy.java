/**
 * Copyright (C), 2020-2022, XDU
 * FileName: JDKProxy
 * Author: Dingq
 * Date: 2022/5/10 16:27
 * Description:
 */
package proxy;

import dao.UserDAO;
import dao.impl.UserDAOImpl;

import java.lang.reflect.Proxy;

public class JDKProxy {
    public static void main(String[] args) {
        //1.创建被代理类对象
        UserDAOImpl userDAO = new UserDAOImpl();
        //2.重写调用处理程序接口，获得其实现类
        UserDAOInvocationHandler handler = new UserDAOInvocationHandler(userDAO);
        //3.获取代理类对象，并类型转换
        Object o = Proxy.newProxyInstance(userDAO.getClass().getClassLoader(),
                                          userDAO.getClass().getInterfaces(),
                                          handler);
        UserDAO userDAOProxy = (UserDAO) o;
        //4.用代理对象执行增强的方法
        System.out.println(userDAOProxy.add(1, 1));
        System.out.println(userDAOProxy.update("dd"));
    }
}