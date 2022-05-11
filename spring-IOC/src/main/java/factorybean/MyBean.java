/**
 * Copyright (C), 2020-2022, XDU
 * FileName: MyBean
 * Author: Dingq
 * Date: 2022/5/9 20:40
 * Description:
 */
package factorybean;

import org.springframework.beans.factory.FactoryBean;
import pojo.Book;

public class MyBean implements FactoryBean<Book> {

    @Override
    public Book getObject() throws Exception {
        Book book = new Book();
        book.setName("math");
        book.setAuthor("dd");
        book.setBirth("00");
        return book;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}