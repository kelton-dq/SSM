/**
 * Copyright (C), 2020-2022, XDU
 * FileName: Book
 * Author: Dingq
 * Date: 2022/5/9 14:30
 * Description:
 */
package pojo;

public class Book {
    private String name;
    private String author;
    private String birth;

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", birth='" + birth + '\'' +
                '}';
    }
}