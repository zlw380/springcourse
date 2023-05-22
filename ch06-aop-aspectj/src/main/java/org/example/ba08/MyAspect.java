package org.example.ba08;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {

    @After(value = "myPointCut()")
    public void myAfter(){
        System.out.println("在doThird之后执行最终通知方法");
    }

    @Before(value = "myPointCut()")
    public void myBefore(){
        System.out.println("在doThird之前执行前置通知方法");
    }

    @Pointcut(value = "execution(* *..SomeServiceImpl.doThird(..))")
    private void myPointCut(){
    }

}
