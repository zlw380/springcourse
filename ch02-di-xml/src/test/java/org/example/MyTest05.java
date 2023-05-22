package org.example;

import org.example.ba05.ByTypeCls;
import org.example.ba05.Student;
import org.example.dao.ByType;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest05 {
    @Test
    public void test01(){
        String config = "ba05/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        Student student = (Student) ac.getBean("myStudent");
        System.out.println("test method:"+student);
    }

    @Test
    public void test02(){
        String config = "ba05/applicationContext.xml";
        ApplicationContext act = new ClassPathXmlApplicationContext(config);

        ByTypeCls byTypeCls = (ByTypeCls) act.getBean("byTypeCls");
        System.out.println(byTypeCls);

        ByType byType = (ByType) act.getBean("random");
        byType.print();
    }
}
