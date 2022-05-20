/**
 * Copyright (C), 2020-2022, XDU
 * FileName: ViewController
 * Author: Dingq
 * Date: 2022/5/18 13:36
 * Description:
 */
package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ViewController {

//    @RequestMapping("/testView")
//    public String testView(){
//        return "test_view";
//    }

    @RequestMapping("/testThymeleafView")
    public String testThymeleafView(){
        return "success";
    }

    @RequestMapping("/testForward")
    public String testForward(){
        return "forward:/view/testThymeleafView";
    }

    @RequestMapping("/testRedirect")
    public String testRedirect(){
        return "redirect:/view/testThymeleafView";
    }
}