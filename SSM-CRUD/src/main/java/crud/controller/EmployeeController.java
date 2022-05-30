/**
 * Copyright (C), 2020-2022, XDU
 * FileName: EmployeeController
 * Author: Dingq
 * Date: 2022/5/27 11:10
 * Description:
 */
package crud.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import crud.bean.Employee;
import crud.bean.Msg;
import crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    //@RequestMapping("/emps")
    public String getEmps(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        //分页、查询、分页信息
        PageHelper.startPage(pn, 5);
        List<Employee> employees = employeeService.getAll();
        PageInfo page = new PageInfo(employees, 5);
        model.addAttribute("pageInfo", page);
        return "list";
    }
    
    //返回json字符串的形式
    @RequestMapping("/emps")
    @ResponseBody
    public Msg getEmpsWithJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        //分页、查询、分页信息
        PageHelper.startPage(pn, 5);
        List<Employee> employees = employeeService.getAll();
        PageInfo page = new PageInfo(employees, 5);
        return Msg.success().add("pageInfo", page);
    }

    //添加
    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    @ResponseBody
    public Msg saveEmp(@Valid Employee employee, BindingResult result) {
        if(result.hasErrors()){
            return Msg.fail();
        }else {
            employeeService.saveEmp(employee);
            return Msg.success();
        }
    }
    
    //校验用户名
    @RequestMapping("/check")
    @ResponseBody
    public Msg checkName(String empName) {
        String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\\u2E80-\\u9FFF]{2,5})";
        if(!empName.matches(regx)){
            return Msg.fail().add("va_msg", "用户名可以是2-5位中文或者6-16位英文和数字的组合");
        }
        boolean b = employeeService.check(empName);
        if(b){
            return Msg.success();
        }
        return Msg.fail();
    }

    //按id查询
    @RequestMapping(value = "/emp/{empId}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getEmp(@PathVariable("empId") Integer empId) {
        Employee employee = employeeService.getEmp(empId);
        return Msg.success().add("employee", employee);
    }

    @RequestMapping(value = "/emp/{empId}", method = RequestMethod.PUT)
    @ResponseBody
    public Msg saveEmp(Employee employee) {
        employeeService.updateEmp(employee);
        return Msg.success();
    }

    @RequestMapping(value = "/emp/{empIds}",  method = RequestMethod.DELETE)
    @ResponseBody
    public Msg deleteEmpById(@PathVariable("empIds")String empIds) {
        if(empIds.contains("-")){
            String[] str_ids = empIds.split("-");
            List<Integer> list = new ArrayList<>();
            for(String s : str_ids){
                list.add(Integer.parseInt(s));
            }
            employeeService.deleteBatch(list);
        }else {
            employeeService.deleteEmp(Integer.parseInt(empIds));
        }
        return Msg.success();
    }
}