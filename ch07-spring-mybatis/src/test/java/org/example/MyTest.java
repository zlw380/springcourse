package org.example;

import org.apache.ibatis.session.SqlSessionFactory;
import org.example.dao.StudentDao;
import org.example.domain.Student;
import org.example.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    @Test
    public void test01(){
        String config  = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //SqlSessionFactory factory = (SqlSessionFactory) ac.getBean("sqlSessionFactory");
        //System.out.println(factory);
        String[] names = ac.getBeanDefinitionNames();
        for (String name:names
             ) {
            //studentDao|com.sun.proxy.$Proxy8
            //通过JDK动态代理创建出了Dao对象
            System.out.println(name+"|"+ac.getBean(name).getClass().getName());
            //studentDao|org.apache.ibatis.binding.MapperProxy@5552768b
            //这个应该是它原本的目标类,通过增强其中的方法创建出Dao代理对象（个人感觉基本全是增强）
            //System.out.println(name+"|"+ac.getBean(name));
        }
    }

    @Test
    public void test02(){
        String config  = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        StudentDao dao = (StudentDao) ac.getBean("studentDao");
        Student student = new Student();
        student.setId(1011);
        student.setName("ten");
        student.setAge(18);
        student.setEmail("cheng@qq.com");
        int num = dao.insertStudent(student);
        System.out.println("插入学生信息结果为"+num);
    }

    @Test
    public void test03(){
        String config  = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        StudentDao dao = (StudentDao) ac.getBean("studentDao");
        List<Student> students = dao.selectStudents();
        for (Student stu:students
             ) {
            System.out.println(stu);
        }
    }

    //通过service去访问Dao
    @Test
    public void test04(){
        String config  = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        StudentService studentService = (StudentService) ac.getBean("studentService");
        List<Student> students = studentService.queryStudents();
        for (Student stu:students
        ) {
            System.out.println(stu);
        }
    }

    @Test
    public void test05(){
        String config  = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        StudentService studentService = (StudentService) ac.getBean("studentService");
        Student student= new Student(1012,"老哥","mingbairen@qq.com",60);
        int num = studentService.addStudent(student);
        //Spring-Mybatis整合使用事务自动提交
        System.out.println("插入学生信息结果为"+num);
    }
}
