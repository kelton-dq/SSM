/**
 * Copyright (C), 2020-2022, XDU
 * FileName: Department
 * Author: Dingq
 * Date: 2022/5/9 16:37
 * Description:
 */
package pojo;

public class Department {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                '}';
    }
}