/**
 * Copyright (C), 2020-2022, XDU
 * FileName: Point
 * Author: Dingq
 * Date: 2022/5/12 15:33
 * Description:
 */
package pojo;

public class Point {

    private Integer id;
    private String name;
    private Integer point;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Point{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", point=" + point +
                '}';
    }
}