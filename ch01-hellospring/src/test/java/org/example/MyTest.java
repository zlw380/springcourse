package org.example;

import org.example.service.SomeService;
import org.example.service.impl.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class MyTest {
    @Test
    public void test01(){
        SomeService service = new SomeServiceImpl();
        service.doSome();
    }

    @Test
    public void test02(){
        String config = "beans.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        SomeService service = (SomeService) ac.getBean("someService");

        service.doSome();
    }

    @Test
    public void test03(){
        String config = "beans.xml";
        ApplicationContext container = new ClassPathXmlApplicationContext(config);
        int count = container.getBeanDefinitionCount();
        System.out.println("object count:"+count);
        String[] names = container.getBeanDefinitionNames();
        for (String name:names
             ) {
            System.out.println(name);
        }
    }

    @Test
    public void test04(){
        String config = "beans.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        Date my = (Date) context.getBean("mydate");
        System.out.println("Date:"+my);
    }


}
