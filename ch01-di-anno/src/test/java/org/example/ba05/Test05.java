package org.example.ba05;

import org.example.ba05.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test05 {

    @Test
    public void test01(){
        String config = "ba05/applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
        Student student = (Student) applicationContext.getBean("myStudent");
        //School school = (School) applicationContext.getBean("youSchool");


        System.out.println(student);

    }
}
