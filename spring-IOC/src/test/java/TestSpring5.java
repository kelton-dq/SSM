import config.SpringConfig;
import factorybean.MyBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.*;
import service.UserService;


/**
 * Copyright (C), 2020-2022, XDU
 * FileName: TestSpring5
 * Author: Dingq
 * Date: 2022/5/8 14:18
 * Description:
 */

public class TestSpring5 {

    @Test
    public void testAdd(){
        //IOC基本案例
        //1加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean01.xml");
        //2获取配置创建的对象
        User user = context.getBean("user", User.class);
        System.out.println(user);
        user.add();
    }

    @Test
    public void testSetDI(){
        //set方法实现依赖注入
        ApplicationContext context = new ClassPathXmlApplicationContext("bean01.xml");
        Book book = context.getBean("book", Book.class);
        System.out.println(book.toString());
    }

    @Test
    public void testConsDI(){
        //构造器实现依赖注入
        ApplicationContext context = new ClassPathXmlApplicationContext("bean01.xml");
        Order order = context.getBean("order", Order.class);
        System.out.println(order.toString());
    }

    @Test
    public void testService(){
        //外部bean
        ApplicationContext context = new ClassPathXmlApplicationContext("bean02.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }

    @Test
    public void testEmployee(){
        //内部bean
        ApplicationContext context = new ClassPathXmlApplicationContext("bean03.xml");
        Employee employee = context.getBean("employee", Employee.class);
        System.out.println(employee.toString());
    }

    @Test
    public void testEmployee1(){
        //级联赋值
        ApplicationContext context = new ClassPathXmlApplicationContext("bean04.xml");
        Employee employee = context.getBean("employee", Employee.class);
        System.out.println(employee.toString());
    }

    @Test
    public void testCollection(){
        //集合类：array、list、map类型属性的依赖注入
        ApplicationContext context = new ClassPathXmlApplicationContext("bean05.xml");
        Student student = context.getBean("student", Student.class);
        System.out.println(student);
    }

    @Test
    public void testCollection1(){
        //util提取公共注入值
        ApplicationContext context = new ClassPathXmlApplicationContext("bean06.xml");
        Student student = context.getBean("student", Student.class);
        Teacher teacher = context.getBean("teacher", Teacher.class);
        System.out.println(student);
        System.out.println(teacher);
    }

    @Test
    public void testFactoryBean(){
        //工厂bean
        ApplicationContext context = new ClassPathXmlApplicationContext("bean07.xml");
        Book myBean = context.getBean("myBean", Book.class);
        System.out.println(myBean);
    }

    @Test
    public void testLifeCycle(){
        //bean声明周期
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean08.xml");
        Order order = context.getBean("order", Order.class);
        System.out.println("4.获取使用对象");
        System.out.println(order);
        context.close();
    }

    @Test
    public void testAUTO(){
        //自动装配
        ApplicationContext context = new ClassPathXmlApplicationContext("bean09.xml");
        Employee employee = context.getBean("employee", Employee.class);
        System.out.println(employee);
    }

    @Test
    public void testComponent(){
        //使用注解
        ApplicationContext context = new ClassPathXmlApplicationContext("bean11.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }

    @Test
    public void testConfig(){
        //完全注解开发
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }
}