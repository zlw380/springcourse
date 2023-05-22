package org.example;

import org.example.ba02.SomeService;
import org.example.ba02.Student;
import org.example.ba02.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest02 {
    @Test
    public void test01(){
        String config = "ba02/applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        SomeService someService = (SomeService) ctx.getBean("someService");
        SomeService someService1 = (SomeService) ctx.getBean("someService1");
        StudentService studentService = (StudentService) ctx.getBean("studentService");

        //String对象是放在字符串常量池中的，改变myAfterReturning中的res参数只会新建一个String对象
        //而doOther方法中的res还是指向“cat”这个字符串对象所以不会变，变的只是myAfterReturning中的res引用

        //但在这里doOther方法的res返回值之所以在传入通知方法后修改再在测试方法中打印没有发生变化的原因是
        //通知方法中接收的res参数只是作为其局部变量，这个变量的值不论如何修改都只存在于通知方法的方法栈帧当中
        //不影响外部测试方法中的doOther方法返回值
        //相当于
        //Object res = doOther(carry,33);
        //myAfterReturning(res);
        //System.out.println(res);

        //以上的理解还是存在错误，上面的例子仅针对字符串或基本数据类型的目标对象方法返回值
        //如果通知方法接收的是其他引用数据类型如对象的返回值，再在通知方法内对该返回值做出修改
        //那么测试方法中的返回值是会改变的，
        //因为目标对象方法返回的值是学生对象的引用，是一个地址，通知方法接收的参数也是同一个地址
        //通知方法接收的与目标对象方法返回的res引用指向的都是同一个内存地址，
        //当学生对象重新赋值后，测试类所指向的内存地址的值也会发生改变
        //但字符串重新赋值以后会创建一个新的内存地址代表被赋值的字符串，原先的内存地址所指向的字符串内容不会发生改变
        String str = someService.doOther("carry",33);
        System.out.println("str===="+str);
        System.out.println("======================");
        Integer mua = someService1.doTest();
        System.out.println("mua===="+mua);
        System.out.println("======================");
        someService.doSome("大哥大",777);
        System.out.println("======================");
        Student student = studentService.doOther();
        System.out.println("student===="+student);
    }
}
