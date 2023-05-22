package org.example;

import org.example.ba06.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest06 {
    @Test
    public void test01(){
        String config = "ba06/applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        SomeService someService = (SomeService) ctx.getBean("someService");

        System.out.println(someService.getClass());
        System.out.println(someService.getClass().getSimpleName());
        someService.doThird();
    }
}
