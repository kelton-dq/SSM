import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import service.BookService;

/**
 * Copyright (C), 2020-2022, XDU
 * FileName: TestJUnit5
 * Author: Dingq
 * Date: 2022/5/13 12:45
 * Description:
 */

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:bean01.xml")
@SpringJUnitConfig(locations = "classpath:bean01.xml")//复合注解代替以上两个
public class TestJUnit5 {

    @Autowired
    private BookService bookService;

    @Test
    public void test2(){
        int bookCount = bookService.bookCount();
        System.out.println(bookCount);
    }
}