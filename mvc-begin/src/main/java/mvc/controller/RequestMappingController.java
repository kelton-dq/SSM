/**
 * Copyright (C), 2020-2022, XDU
 * FileName: RequestMappingController
 * Author: Dingq
 * Date: 2022/5/16 15:13
 * Description:
 */
package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/request")
public class RequestMappingController {

    @RequestMapping(value = "/test", method = {RequestMethod.GET, RequestMethod.POST})
    public String test(){
        return "test";
    }

    @RequestMapping(value = "/params", params = "username")
    public String testparams(){
        return "test";
    }

    @RequestMapping(value = "/testPath/{id}/{name}")
    public String testPath(@PathVariable("id") String id, @PathVariable("name") String name){
        System.out.println("id = " + id + "," + "name = " + name);
        return "test";
    }
}