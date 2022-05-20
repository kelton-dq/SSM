/**
 * Copyright (C), 2020-2022, XDU
 * FileName: HttpController
 * Author: Dingq
 * Date: 2022/5/20 11:40
 * Description:
 */
package mvc.controller;

import mvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HttpController {

    @RequestMapping("/testResponse")
    public void testResponse(HttpServletResponse response) throws IOException {
        response.getWriter().print("HttpServletResponse");
    }

    @RequestMapping("/testResponseBody")
    @ResponseBody
    public String testResponseBody(){
        return "ResponseBody";
    }

    @RequestMapping("/testResponseUser")
    @ResponseBody
    public User testResponseUser(){
        return new User(1001, "dd", "123456", "男", 23);
    }

    @RequestMapping("/testAjax")
    @ResponseBody
    public String testAjax(String username, String password){
        System.out.println("username:"+username+",password:"+password);
        return "hello,ajax";
    }

}