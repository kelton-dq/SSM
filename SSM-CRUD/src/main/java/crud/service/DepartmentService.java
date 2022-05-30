/**
 * Copyright (C), 2020-2022, XDU
 * FileName: DepartmentService
 * Author: Dingq
 * Date: 2022/5/28 15:10
 * Description:
 */
package crud.service;

import crud.bean.Department;
import crud.dao.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    public List<Department> getDepts(){
        List<Department> departments = departmentMapper.selectByExample(null);
        return departments;
    }
}