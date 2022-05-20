/**
 * Copyright (C), 2020-2022, XDU
 * FileName: TestParamController
 * Author: Dingq
 * Date: 2022/5/16 21:19
 * Description:
 */
package mvc.controller;

import mvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Controller
@RequestMapping("/param")
public class ParamController {
    @RequestMapping("/index")
    public String param(){
        return "param";
    }

    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request){
        String username = request.getParameter("username");
        HttpSession session = request.getSession();
        System.out.println(username);
        return "success";
    }

    @RequestMapping("/testParam")
    public String testParam(String username, String password, String[] hobby){
        System.out.println("username:"+username+",password:" + password + ",hobby:" + Arrays.toString(hobby));
        return "success";
    }

    @RequestMapping("/testpojo")
    public String testpojo(User user){
        System.out.println(user);
        return "success";
    }
}