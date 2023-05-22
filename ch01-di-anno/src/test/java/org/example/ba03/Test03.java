package org.example.ba03;

import org.example.ba03.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {

    @Test
    public void test01(){
        String config = "ba03/applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
        Student student = (Student) applicationContext.getBean("myStudent");
        //School school = (School) applicationContext.getBean("mySchool");


        System.out.println(student);

    }
}
