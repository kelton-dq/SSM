/**
 * Copyright (C), 2020-2022, XDU
 * FileName: EmployeeService
 * Author: Dingq
 * Date: 2022/5/27 11:15
 * Description:
 */
package crud.service;

import crud.bean.Employee;
import crud.bean.EmployeeExample;
import crud.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * @param
     * @return java.util.List<crud.bean.Employee>
     * @description 查询所有员工
     * @author Dingq
     * @date 2022/5/27 11:20
     */
    public List<Employee> getAll() {
        EmployeeExample example = new EmployeeExample();
        example.setOrderByClause("emp_id");
        return employeeMapper.selectByExampleWithDept(example);
//        return employeeMapper.selectByExampleWithDept(null);
    }

    public void saveEmp(Employee employee) {
        employeeMapper.insertSelective(employee);
    }

    public boolean check(String empName) {
        EmployeeExample example = new EmployeeExample();
        example.createCriteria().andEmpNameEqualTo(empName);
        long count = employeeMapper.countByExample(example);
        return count == 0;
    }

    public Employee getEmp(Integer empId) {
        Employee employee = employeeMapper.selectByPrimaryKey(empId);
        return employee;
    }

    public void updateEmp(Employee employee) {
        employeeMapper.updateByPrimaryKeySelective(employee);
    }

    public void deleteEmp(Integer empId) {
        employeeMapper.deleteByPrimaryKey(empId);
    }

    public void deleteBatch(List<Integer> ids){
        EmployeeExample example = new EmployeeExample();
        example.createCriteria().andEmpIdIn(ids);
        employeeMapper.deleteByExample(example);
    }
}