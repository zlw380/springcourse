package org.example.ba01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Date;

/*@Aspect
public class MyAspect {
    @Before(value = "execution(public void org.example.ba01.SomeServiceImpl.doSome(String,Integer))")
    public void myBefore(){
        System.out.println("前置通知，切面功能：在目标方法之前输出执行时间："+ new Date());
    }
}*/

//简化切入点表达式
//改变表达式方法参数会使AspectJ匹配不到原目标类的方法
//批量给目标对象增强
/*@Aspect
public class MyAspect {
    @Before(value = "execution(void *..*ServiceImpl.doSome(..))")
    public void myBefore(){
        System.out.println("05前置通知，切面功能：在目标方法之前输出执行时间："+ new Date());
    }
}*/

//多个前置通知
/*@Aspect
public class MyAspect {
    @Before(value = "execution(* *..SomeServiceImpl.do*(..))")
    public void myBefore(){
        System.out.println("03前置通知，切面功能：在目标方法之前输出执行时间："+ new Date());
    }

    @Before(value = "execution(* do*(..))")
    public void myBefore02(){
        System.out.println("04前置通知，切面功能：在目标方法之前输出执行时间："+ new Date());
    }
}*/

//指定通知方法中的参数：JoinPoint
@Aspect
public class MyAspect {
    @Before(value = "execution(void *..SomeServiceImpl.doSome(..))")
    //JoinPoint是一个接口，包含目标方法信息的对象是由它下面的某个实现类创建的
    public void myBefore(JoinPoint jp){
        System.out.println("方法签名（定义）:"+jp.getSignature());
        System.out.println("方法名称:"+jp.getSignature().getName());

        //Object args [] = jp.getArgs();
        Object[] args = jp.getArgs();
        for (Object arg:args
             ) {
            System.out.println("参数:"+arg);
        }

        System.out.println("05前置通知，切面功能：在目标方法之前输出执行时间："+ new Date());
    }
}
