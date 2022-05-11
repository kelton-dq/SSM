/**
 * Copyright (C), 2020-2022, XDU
 * FileName: UserServiceImpl
 * Author: Dingq
 * Date: 2022/5/9 16:06
 * Description:
 */
package service.impl;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import service.UserService;

import javax.annotation.Resource;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

//    @Autowired
//    @Qualifier(value = "userDAO")
    @Resource(name = "userDAO")
    UserDAO userDAO;
    @Value(value = "dd")
    private String name;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void add(){
        System.out.println("service add……");
        System.out.println(name);
//        传统方式
//        UserDAO userDAO = new UserDAOImpl();
        userDAO.update();
    }
}