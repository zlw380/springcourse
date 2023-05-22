package org.example;

import org.example.ba01.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest01 {
    @Test
    public void test01(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        SomeService someService = (SomeService) ac.getBean("someService");
//        SomeService otherService = (SomeService) ac.getBean("otherService");
//        SomeService orderService = (SomeService) ac.getBean("orderService");
        //Object.getClass 是构造Class类型对象的三种方法之一
        //通过someService对象直接获取方法区中对应字节码文件（.class文件）中的类的信息
        //并封装到一个Class类的对象当中
        //这个Class类的对象是由JVM自动创建的

        //代理对象是由代理类创建的(可以这么理解)
        //因此打印出来的对象类型也是目标类的代理对象在被创建时其原本的proxy类型
        //AspectJ框架直接将目标对象的类型转换为代理对象的类型
        //可见这里AOP框架的底层实现使用的是JDK动态代理
//        System.out.println("someService代理对象的类型："+someService.getClass().getName());
        someService.doSome("李老根",22);
//        otherService.doSome("刘老根",55);
//        orderService.doSome("马大帅",56);
    }
}
