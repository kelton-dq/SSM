/**
 * Copyright (C), 2020-2022, XDU
 * FileName: InterceptorController
 * Author: Dingq
 * Date: 2022/5/21 11:09
 * Description:
 */
package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InterceptorController {

    @RequestMapping("/testInterceptor")
    public String testInterceptor() {
        return "success";
    }

}