package org.example.ba02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Date;

@Aspect
public class MyAspect {
    //后置通知
    //String对象是放在字符串常量池中的，改变myAfterReturning中的res参数只会新建一个String对象
    //而doOhter方法中的res还是指向“cat”这个字符串对象所以不会变，变的只是myAfterReturning中的res引用

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
    //但字符串重新赋值以后之后创建一个新的内存地址代表被赋值的字符串，原先的内存地址所指向的字符串内容不会发生改变
/*    @AfterReturning(value = "execution(* *..ba02.SomeServiceImpl.doOther(..))",
                    returning = "res")
    public void myAfterReturning(Object res){
        System.out.println("后置通知：在目标方法之后执行，获取的返回值是"+res);
        //Object ret = res;
        res = "dog";
        System.out.println(res);
        //System.out.println(ret);
    }*/

    //后置通知：在目标方法之后执行，获取的返回值是dog
    //str====cat
    /*@AfterReturning(value = "execution(* *..ba02.SomeServiceImpl.doOther(..))",
            returning = "res")
    public void myAfterReturning(Object res){
        res = "dog";
        System.out.println("后置通知：在目标方法之后执行，获取的返回值是"+res);
        //res = "dog";
    }*/

    //返回字符串
    @AfterReturning(value = "execution(* *..ba02.SomeServiceImpl.doOther(..))",
            returning = "res")
    public void myAfterReturning(Object res){
        System.out.println("后置通知：在目标方法之后执行，获取的返回值是"+res);
        //Object ret = res;
        //这里是新创建了一个字符串对象，内存中新开辟了一块空间存放"dog"并将新的地址赋给通知方法的res引用
        //但并不会改变目标对象方法返回的引用指向的内存地址
        //通知方法中的res引用仅存在于通知方法的方法栈帧之中
        res = "dog";
        System.out.println("通知方法res修改为"+res);
        //System.out.println(ret);
    }

    //返回整型
    @AfterReturning(value = "execution(* *..ba02.SomeServiceImpl1.doTest(..))",
            returning = "res")
    public void myAfterReturning1(Integer res){
        System.out.println("后置通知：在目标方法doTest之后执行，获取的返回值是"+res);
        res = 10086;
        System.out.println("通知方法res修改为"+res);
    }

    //无返回值
    @AfterReturning(value = "execution(* *..ba02.SomeServiceImpl.doSome(..))",
            returning = "res")
    public void myAfterReturning2(Object res){
        System.out.println("后置通知：在目标方法doTest之后执行，获取的返回值是"+res);
        res = 10086;
        System.out.println("通知方法res修改为"+res);
    }

    //返回对象
    @AfterReturning(value = "execution(* *..ba02.StudentServiceImpl.doOther(..))",
            returning = "res")
    public void myStudentService(JoinPoint jp,Student res){
        System.out.println("JoinPoint类型参数jp是一个包含目标类方法信息的对象"+jp.getSignature());
        System.out.println("后置通知：在目标方法doOther之后执行，获取的返回值是"+res);
        //这里直接修改了res引用对应的地址中存放的值,这个地址同时也是目标对象方法返回值所指向的地址
        res.setName("香肠");
        res.setAge(55);
    }
    //与最终通知的区别：最终通知类似异常里面的finally，即使你的方法异常错误也会执行，
    //AfterReturning就不行
    //最终通知是总是被执行的代码

}
