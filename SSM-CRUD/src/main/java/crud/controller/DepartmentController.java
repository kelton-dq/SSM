/**
 * Copyright (C), 2020-2022, XDU
 * FileName: DepartmentController
 * Author: Dingq
 * Date: 2022/5/28 15:10
 * Description:
 */
package crud.controller;

import crud.bean.Department;
import crud.bean.Msg;
import crud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;
    
    @RequestMapping("/depts")
    @ResponseBody
    public Msg getDepts() {
        List<Department> departments = departmentService.getDepts();
        return Msg.success().add("depts", departments);
    }
}