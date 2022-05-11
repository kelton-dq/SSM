/**
 * Copyright (C), 2020-2022, XDU
 * FileName: Student
 * Author: Dingq
 * Date: 2022/5/9 19:19
 * Description:
 */
package pojo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Student {

    private String[] courses;

    private List<String> list;

    private Map<String, String> map;

    private List<Book> books;

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Student{" +
                "courses=" + Arrays.toString(courses) +
                ", list=" + list +
                ", map=" + map +
                ", books=" + books +
                '}';
    }
}