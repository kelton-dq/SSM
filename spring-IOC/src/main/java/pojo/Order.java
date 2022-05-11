/**
 * Copyright (C), 2020-2022, XDU
 * FileName: Order
 * Author: Dingq
 * Date: 2022/5/9 14:45
 * Description:
 */
package pojo;

public class Order {
    private String name;
    private String address;

    public Order() {
        System.out.println("1.无参构造器创建对象");
    }

    public Order(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("2.调用set方法设置属性");
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void initMethod(){
        System.out.println("3.bean初始化方法");
    }

    public void destroyMethod(){
        System.out.println("5.bean销毁");
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}