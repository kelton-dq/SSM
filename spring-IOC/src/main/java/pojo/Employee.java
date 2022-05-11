/**
 * Copyright (C), 2020-2022, XDU
 * FileName: Employee
 * Author: Dingq
 * Date: 2022/5/9 16:38
 * Description:
 */
package pojo;

public class Employee {

    private String name;
    private String gender;

    //对应的部门
    private Department department;

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", department=" + department.toString() +
                '}';
    }
}