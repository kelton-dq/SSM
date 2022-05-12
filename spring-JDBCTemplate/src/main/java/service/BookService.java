package service;

import pojo.Book;

import java.util.List;

public interface BookService {

    void addBook(Book book);

    void updateBook(Book book);

    void deleteBook(String bookName);

    int bookCount();

    Book bookInfo(String bookName);

    List<Book> bookList();
}
