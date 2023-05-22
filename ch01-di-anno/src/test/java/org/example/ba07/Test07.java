package org.example.ba07;

import org.example.ba07.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test07 {

    @Test
    public void test01(){
        String config = "ba07/applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
        Student student = (Student) applicationContext.getBean("myStudent");
        //School school = (School) applicationContext.getBean("youSchool");


        System.out.println(student);

    }
}
