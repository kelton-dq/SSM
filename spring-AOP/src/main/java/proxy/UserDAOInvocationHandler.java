/**
 * Copyright (C), 2020-2022, XDU
 * FileName: UserDAOInvocationHandler
 * Author: Dingq
 * Date: 2022/5/10 16:51
 * Description:
 */
package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class UserDAOInvocationHandler implements InvocationHandler {

    //1.被代理类的对象
    private Object object;

    //2.传入被代理对象
    public UserDAOInvocationHandler(Object object){
        this.object = object;
    }

    //3.添加增强的方法逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //原方法执行之前
        System.out.println("原方法之前，方法名：" + method.getName() + "，参数：" + Arrays.toString(args));

        //原方法执行
        Object returnValue = method.invoke(object, args);

        //原方法执行之后
        System.out.println("原方法之后");

        return returnValue;
    }
}