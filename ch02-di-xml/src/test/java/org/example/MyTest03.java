package org.example;

import org.example.ba03.School;
import org.example.ba03.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

public class MyTest03 {
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
        String config = "ba03/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        School school = (School) ac.getBean("myschool");
        Student student = (Student) ac.getBean("myStudent");
        Student student1 = (Student) ac.getBean("myStudent2");
        File file = (File) ac.getBean("parentchild");
        System.out.println(school);
        System.out.println(student);
        System.out.println(student1);
        System.out.println(file);
        System.out.println(file.getName());
    }

}
