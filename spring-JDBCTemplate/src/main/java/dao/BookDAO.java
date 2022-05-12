package dao;

import pojo.Book;

import java.util.List;

public interface BookDAO {
    void addBook(Book book);

    void updateBook(Book book);

    void deleteBook(String bookName);

    int queryCount();

    Book queryBook(String bookName);

    List<Book> queryBookList();
}
