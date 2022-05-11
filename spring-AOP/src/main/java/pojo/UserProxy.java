/**
 * Copyright (C), 2020-2022, XDU
 * FileName: UserProxy
 * Author: Dingq
 * Date: 2022/5/11 11:05
 * Description:
 */
package pojo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(0)
public class UserProxy {

    @Pointcut(value = "execution(* pojo.User.add(..))")
    public void pointCut(){

    }

    @Before(value = "pointCut()")
    public void before(){
        //前置通知
        System.out.println("before……");
    }

    @After(value = "pointCut()")
    public void after(){
        //最终通知
        System.out.println("after……");
    }

    @AfterReturning(value = "pointCut()")
    public void afterReturning(){
        //后置通知
        System.out.println("afterReturning……");
    }

    @AfterThrowing(value = "pointCut()")
    public void afterThrowing(){
        //异常通知
        System.out.println("afterThrowing……");
    }

    @Around(value = "execution(* pojo.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //环绕通知
        System.out.println("around before……");
        proceedingJoinPoint.proceed();
        System.out.println("around after……");
    }
}