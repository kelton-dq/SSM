/**
 * Copyright (C), 2020-2022, XDU
 * FileName: BookDAOImpl
 * Author: Dingq
 * Date: 2022/5/11 16:46
 * Description:
 */
package dao.impl;

import dao.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pojo.Book;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addBook(Book book) {
        int update = jdbcTemplate.update("insert into t_book values(0, ?, ?, ?, ?, ?, ?)", book.getBookName(), book.getAuthor(), book.getPrice(), book.getSalCount(), book.getBookCount(), book.getBookImg());
        System.out.println(update);
    }

    @Override
    public void updateBook(Book book) {
        int update = jdbcTemplate.update("update t_book set price = ?,salCount = ?, bookCount = ?, bookImg = ? where bookName = ?", book.getPrice(), book.getSalCount(), book.getBookCount(), book.getBookImg(), book.getBookName());
        System.out.println(update);
    }

    @Override
    public void deleteBook(String bookName) {
        int update = jdbcTemplate.update("delete from t_book where bookName = ?", bookName);
        System.out.println(update);
    }

    @Override
    public int queryCount() {
        return jdbcTemplate.queryForObject("select count(1) from t_book", Integer.class);
    }

    @Override
    public Book queryBook(String bookName) {
        RowMapper<Book> rowMapper = new BeanPropertyRowMapper<>(Book.class);
        Book book = jdbcTemplate.queryForObject("select * from t_book where bookName = ?", rowMapper, bookName);
        return book;
    }

    @Override
    public List<Book> queryBookList() {
        RowMapper<Book> rowMapper = new BeanPropertyRowMapper<>(Book.class);
        List<Book> bookList = jdbcTemplate.query("select * from t_book", rowMapper);
        return bookList;
    }
}