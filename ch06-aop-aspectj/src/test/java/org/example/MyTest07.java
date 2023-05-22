package org.example;

import org.example.ba07.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest07 {
    @Test
    public void test01(){
        String config = "ba07/applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        SomeServiceImpl someService = (SomeServiceImpl) ctx.getBean("someService");

        //class org.example.ba07.SomeServiceImpl$$EnhancerBySpringCGLIB$$58276a1c
        //SomeServiceImpl$$EnhancerBySpringCGLIB$$58276a1c
        System.out.println(someService.getClass());
        System.out.println(someService.getClass().getSimpleName());
        someService.doThird();
    }
}
