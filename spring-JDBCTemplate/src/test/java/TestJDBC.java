import config.Config;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Book;
import service.BookService;
import service.PointService;

import java.util.List;

/**
 * Copyright (C), 2020-2022, XDU
 * FileName: TestJDBC
 * Author: Dingq
 * Date: 2022/5/11 17:34
 * Description:
 */

public class TestJDBC {

    @Test
    public void testBookAdd(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean01.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.addBook(new Book("三体", "刘慈欣", 55.0, 10, 100, "santi.jpg"));
    }

    @Test
    public void testBookUpdate(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean01.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.updateBook(new Book("三体", "刘慈欣", 55.0, 50, 50, "santi.jpg"));
    }

    @Test
    public void testBookCount(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean01.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        int bookCount = bookService.bookCount();
        System.out.println(bookCount);
    }

    @Test
    public void testBookInfo(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean01.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = bookService.bookInfo("三体");
        List<Book> books = bookService.bookList();
        System.out.println(book);
        System.out.println(books);
    }

    @Test
    public void testTX(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean01.xml");
        PointService pointService = context.getBean("pointService", PointService.class);
        System.out.println(pointService.getPoints());
        pointService.transfer("wangwei", "liming", 300);
        System.out.println(pointService.getPoints());
    }

    @Test
    public void testTX1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean02.xml");
        PointService pointService = context.getBean("pointService", PointService.class);
        System.out.println(pointService.getPoints());
        pointService.transfer("wangwei", "liming", 300);
        System.out.println(pointService.getPoints());
    }

    @Test
    public void testTX2(){
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        PointService pointService = context.getBean("pointService", PointService.class);
        System.out.println(pointService.getPoints());
        pointService.transfer("wangwei", "liming", 300);
        System.out.println(pointService.getPoints());
    }

}