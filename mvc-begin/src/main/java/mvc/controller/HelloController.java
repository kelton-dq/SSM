/**
 * Copyright (C), 2020-2022, XDU
 * FileName: HelloController
 * Author: Dingq
 * Date: 2022/5/15 15:34
 * Description:
 */
package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping(value = "/")
    public String index() {
        //设置视图名称，即页面名称
        return "index";
    }

    @RequestMapping("/target")
    public String toTarget(){
        return "target";
    }
}