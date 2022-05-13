/**
 * Copyright (C), 2020-2022, XDU
 * FileName: Book
 * Author: Dingq
 * Date: 2022/5/11 17:11
 * Description:
 */
package pojo;

public class Book {

    private Integer id;
    private String bookName;
    private String author;
    private Double price;
    private Integer salCount;
    private Integer bookCount;
    private String bookImg;

    public Book() {
    }

    public Book(String bookName, String author, Double price, Integer salCount, Integer bookCount, String bookImg) {
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.salCount = salCount;
        this.bookCount = bookCount;
        this.bookImg = bookImg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getSalCount() {
        return salCount;
    }

    public void setSalCount(Integer salCount) {
        this.salCount = salCount;
    }

    public Integer getBookCount() {
        return bookCount;
    }

    public void setBookCount(Integer bookCount) {
        this.bookCount = bookCount;
    }

    public String getBookImg() {
        return bookImg;
    }

    public void setBookImg(String bookImg) {
        this.bookImg = bookImg;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", salCount=" + salCount +
                ", bookCount=" + bookCount +
                ", bookImg='" + bookImg + '\'' +
                '}';
    }
}