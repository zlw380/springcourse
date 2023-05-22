package org.example;

import org.example.ba01.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class MyTest {
    @Test
    public void test01(){
        String config = "ba01/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        Student myStudent = (Student) ac.getBean("myStudent");
        System.out.println("student object = "+myStudent);
        System.out.println(myStudent.getName());

        Date mydate = (Date) ac.getBean("mydate");
        System.out.println(mydate);
    }



}
