package org.example.ba03;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.ba02.Student;

import java.util.Date;

@Aspect
public class MyAspect {
    //环绕通知：等同于JDK动态代理的InvocationHandler接口，编写增强方法
    //参数 ProceedingJoinPoint pjp 等同于 Method method
    //Spring默认单例模式，一个实现（目标）类只会new出一个对象所以不需要像JDK动态代理一样指定是哪一个目标对象
    //返回值：就是目标方法的执行结果，可以被修改
    //环绕通知经常做事务,在目标方法之前开启事务
    //执行目标方法，在目标方法之后提交事务

    @Around(value = "execution(* *..ba03.SomeServiceImpl.doFirst(..))")
    public Object myDoFirst(ProceedingJoinPoint pjp) throws Throwable {

        String name = "";
        //获得目标方法参数
        Object[] args = pjp.getArgs();
        for (Object arg1:args
             ) {
            System.out.println(arg1);
        }

        if(args != null && args.length > 1){
            Object arg = args[0];
            name = (String) arg;
        }

        Object result = null;

        System.out.println("环绕通知：在目标方法doFirst前执行，获取时间"+ new Date());
        //1.目标方法调用
        //如果"老李"这个对象的值与name引用指向的内存地址中存放的值相同
        //"老李"本身是一个新创建的String类型的对象，其内存空间是新开辟的，位于字符串常量池中,但是没有引用
        if("老李".equals(name)){
            //符合条件，调用目标方法
            System.out.println("符合条件，调用目标方法");
            result = pjp.proceed();//相当于method.invoke();/Object result = doFirst();
        }
        System.out.println("环绕通知：在目标方法doFirst后执行，提交事务");

        if(result != null){
            //当然不可以了，这个猜都猜到底层肯定会将这个Object向下转型为你目标方法的返回值类型，放整形会报错
            result = "111";
        }

        return result;

    }

}

//初步认识equals与==的区别：
//      1.==是判断两个变量或实例是不是指向同一个内存空间，equals是判断两个变量或实例所指向的内存空间的值是不是相同
//      2.==是指对内存地址进行比较 ， equals()是对字符串的内容进行比较
//      3.==指引用是否相同， equals()指的是值是否相同
