/**
 * Copyright (C), 2020-2022, XDU
 * FileName: UserController
 * Author: Dingq
 * Date: 2022/5/18 19:28
 * Description:
 */
package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    /*
     * /user-->get 查询所有
     * /user/1-->get 按id查询
     * /user-->post 添加
     * /user/1-->delete 按id删除
     * /user-->put 修改
     */

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getAllUser(){
        System.out.println("查询所有用户信息");
        return "success";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String getUserById(@PathVariable String id){
        System.out.println("根据id查询用户信息");
        System.out.println("id = " + id);
        return "success";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String insertUser(String username, String password){
        System.out.println("添加用户信息");
        System.out.println("username = " + username + ", password = " + password);
        return "success";
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String updateUser(String username, String password){
        System.out.println("修改用户信息");
        System.out.println("username = " + username + ", password = " + password);
        return "success";
    }

}