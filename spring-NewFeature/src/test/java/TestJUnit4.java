import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.BookService;

/**
 * Copyright (C), 2020-2022, XDU
 * FileName: TestJUnit4
 * Author: Dingq
 * Date: 2022/5/13 11:48
 * Description:
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean01.xml")
public class TestJUnit4 {

    @Autowired
    private BookService bookService;

    @Test
    public void test1(){
        int bookCount = bookService.bookCount();
        System.out.println(bookCount);
    }
}