import config.Config;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Book;
import pojo.User;

/**
 * Copyright (C), 2020-2022, XDU
 * FileName: TestAOP
 * Author: Dingq
 * Date: 2022/5/11 11:29
 * Description:
 */

public class TestAOP {

    @Test
    public void testAnnotation(){
        //xml开启组件扫描和代理对象，注解实现
        ApplicationContext context = new ClassPathXmlApplicationContext("bean01.xml");
        User user = context.getBean("user", User.class);
        user.add();
    }

    @Test
    public void testXML(){
        //xml方式实现
        ApplicationContext context = new ClassPathXmlApplicationContext("bean02.xml");
        Book book = context.getBean("book", Book.class);
        book.info();
    }

    @Test
    public void testAnnotation1(){
        //完全注解
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        User user = context.getBean("user", User.class);
        user.add();
    }
}