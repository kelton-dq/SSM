/**
 * Copyright (C), 2020-2022, XDU
 * FileName: BookServiceImpl
 * Author: Dingq
 * Date: 2022/5/11 16:48
 * Description:
 */
package service.impl;

import dao.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Book;
import service.BookService;

import java.util.List;

@Service(value = "bookService")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Override
    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    @Override
    public void updateBook(Book book) {
        bookDAO.updateBook(book);
    }

    @Override
    public void deleteBook(String bookName) {
        bookDAO.deleteBook(bookName);
    }

    @Override
    public int bookCount() {
        return bookDAO.queryCount();
    }

    @Override
    public Book bookInfo(String bookName) {
        return bookDAO.queryBook(bookName);
    }

    @Override
    public List<Book> bookList() {
        return bookDAO.queryBookList();
    }
}