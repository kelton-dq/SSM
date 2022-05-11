/**
 * Copyright (C), 2020-2022, XDU
 * FileName: UserDAOImpl
 * Author: Dingq
 * Date: 2022/5/9 16:07
 * Description:
 */
package dao.impl;

import dao.UserDAO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository(value = "userDAO")
public class UserDAOImpl implements UserDAO {

    @Override
    public void update() {
        System.out.println("dao update……");
    }
}