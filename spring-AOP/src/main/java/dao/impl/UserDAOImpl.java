/**
 * Copyright (C), 2020-2022, XDU
 * FileName: UserDAOImpl
 * Author: Dingq
 * Date: 2022/5/10 16:23
 * Description:
 */
package dao.impl;

import dao.UserDAO;

public class UserDAOImpl implements UserDAO {

    @Override
    public int add(int a, int b) {
        System.out.println("add执行");
        return a + b;
    }

    @Override
    public String update(String id) {
        System.out.println("update执行");
        return id;
    }
}