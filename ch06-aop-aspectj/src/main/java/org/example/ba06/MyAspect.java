package org.example.ba06;

import org.aspectj.lang.annotation.*;

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
