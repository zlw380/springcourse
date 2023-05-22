package org.example.handler;

import org.example.service.SomeService;
import org.example.util.ServiceTools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler1{

    //定义目标（SomeServiceImpl1）类的对象
    //在创建MyInvocationHandler实现类的对象时，目标类的对象引用作为构造方法的参数赋值给target
    private SomeService target;

    //目标类对象赋值给引用类型target
    public MyInvocationHandler1(SomeService target) {
        this.target = target;
    }

    public void targetIntensity(){
        ServiceTools.doLog();
        target.doSome();
        ServiceTools.doTrans();

        ServiceTools.doLog();
        target.doOther();
        ServiceTools.doTrans();
    }
}
