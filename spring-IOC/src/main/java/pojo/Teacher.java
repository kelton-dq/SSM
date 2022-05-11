/**
 * Copyright (C), 2020-2022, XDU
 * FileName: Teacher
 * Author: Dingq
 * Date: 2022/5/9 20:04
 * Description:
 */
package pojo;

import java.util.List;

public class Teacher {

    private List<Book> books;

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "books=" + books +
                '}';
    }
}