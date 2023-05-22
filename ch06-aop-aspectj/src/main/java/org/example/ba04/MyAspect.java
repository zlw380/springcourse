package org.example.ba04;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Date;

@Aspect
public class MyAspect {

    /**
     *try{
     *     Object res = SomeServiceImpl.doSecond();
     *     myAfterReturning(res);
     *}catch(Exception ex){
     *     myException(ex);
     *}finally{
     *     myAfter();
     *}
     */
    @AfterReturning(value = "execution(* *..SomeServiceImpl.doSecond(..))",
                    returning = "res")
    public void myAfterReturning(Object res){
        System.out.println("执行后置通知方法myAfterReturning:"+res);
    }

    @AfterThrowing(value = "execution(* *..SomeServiceImpl.doSecond(..))",
                    throwing = "ex")
    public void myException(Exception ex){
        System.out.println("目标方法出现异常，执行异常通知方法："+ex.getMessage());
    }

    @After(value = "execution(* *..SomeServiceImpl.doSecond(..))")
    public void myAfter(){
        System.out.println("执行最终通知方法");
    }
}
