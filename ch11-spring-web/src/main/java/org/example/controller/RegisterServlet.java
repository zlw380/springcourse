package org.example.controller;

import org.example.domain.Student;
import org.example.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String strId = request.getParameter("id");
        String strName = request.getParameter("name");
        String strEmail = request.getParameter("email");
        String strAge = request.getParameter("age");

        //创建spring的容器对象
        //String config = "applicationContext.xml";
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
        //容器对象的信息===ClassPathXmlApplicationContext@6dadbd9d, started on Sat Mar 26 11:30:15 CST 2022
        //容器对象的信息===ClassPathXmlApplicationContext@57154c58, started on Sat Mar 26 11:33:04 CST 2022

        WebApplicationContext applicationContext = null;
//        //自己编写代码获取servletContext中的容器对象，创建好的容器对象拿来就用
//        String key = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
//        //根据Key的值从ServletContext对象中拿到spring容器对象,貌似因为是全局作用域对象所以不需要加对象引用就可以调用方法
//        Object attribute = getServletContext().getAttribute(key);
//        if(attribute != null){
//            //对象强转赋值
//            applicationContext = (WebApplicationContext) attribute;
//        }
//        //容器对象的信息===Root WebApplicationContext, started on Sat Mar 26 13:28:49 CST 2022
//        //容器对象的信息===Root WebApplicationContext, started on Sat Mar 26 13:28:49 CST 2022

        //使用框架中的方法获取容器对象
        //获取ServletContext全局作用域对象，它在整个web应用中是唯一的
        ServletContext sc = getServletContext();
        //通过工具类从全局作用域中获取spring容器对象
        applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(sc);

        System.out.println("容器对象的信息==="+applicationContext);
        //获取service对象
        StudentService studentService = (StudentService) applicationContext.getBean("studentService");
        Student student  = new Student();
        student.setId(Integer.parseInt(strId));
        student.setName(strName);
        student.setEmail(strEmail);
        student.setAge(Integer.valueOf(strAge));
        studentService.addStudent(student);
        //给一个结果页面
        request.getRequestDispatcher("/result.jsp").forward(request,response);
    }
}
