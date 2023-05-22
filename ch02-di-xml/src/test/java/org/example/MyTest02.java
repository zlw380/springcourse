package org.example;

import org.example.ba02.School;
import org.example.ba02.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest02 {
    @Test
    public void test01(){
        Student student = new Student();
        student.setName("zhangsan");
        student.setAge(22);
        School school = new School();
        school.setName("cjdx");
        school.setAddress("hubeijingzhou");
        student.setSchool(school);
        System.out.println(student);
    }

    @Test
    public void test02(){
        String config = "ba02/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        School school = (School) ac.getBean("myschool");
        Student student = (Student) ac.getBean("myStudent");
        System.out.println(school);
        System.out.println(student);
    }
}
