import org.junit.Test;
import org.springframework.context.support.GenericApplicationContext;
import pojo.User;

/**
 * Copyright (C), 2020-2022, XDU
 * FileName: TestGeneric
 * Author: Dingq
 * Date: 2022/5/13 11:32
 * Description:
 */

public class TestGeneric {

    //函数式风格创建对象，交给spring管理
    @Test
    public void testGenericApplicationContext(){
        //1.创建GenericApplicationContext
        GenericApplicationContext context = new GenericApplicationContext();
        //2.用context注册对象
        context.refresh();
        context.registerBean("user",User.class, ()->new User());
        //3.获取注册的对象
//        User user = (User) context.getBean("pojo.User");
        User user = (User) context.getBean("user");
        System.out.println(user);
    }
}