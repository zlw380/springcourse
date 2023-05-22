package org.example;

import org.example.handler.MyInvocationHandler;
import org.example.handler.MyInvocationHandler1;
import org.example.service.SomeService;
import org.example.service.impl.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class MyApp {
    public static void main(String[] args) {
/*        SomeService service = new SomeServiceImplProxy();
        service.doSome();
        service.doOther();*/

/*        SomeService target = new SomeServiceImpl1();
        MyInvocationHandler1 handler = new MyInvocationHandler1(target);
        handler.targetIntensity();*/

        //使用jdk的Proxy创建代理对象
        //创建目标对象
        //SomeService target = new SomeServiceImpl1();
        SomeService target = new SomeServiceImplTargetTest("张三");
        SomeService targetTest = new SomeServiceImplTargetTest("李四");
//        System.out.println(target.getClass());
//        System.out.println(target.getClass().getClassLoader());
        //创建InvocationHandler对象
        InvocationHandler handler = new MyInvocationHandler(targetTest);
//        System.out.println(target.getClass().getInterfaces()[0]);
//        System.out.println(Arrays.toString(target.getClass().getInterfaces()));
        //使用Proxy创建代理
        //代理的是SomeService接口中的功能
        //传入的参数是目标类的类加载器、目标类实现的接口（实现的是SomeService接口），
        //InvocationHandler对象（传入目标类对象target）
        //用以创建目标类的代理对象
        SomeService proxy = (SomeService) Proxy.newProxyInstance(
                //目标类的类加载器
                target.getClass().getClassLoader(),
                //目标类实现了哪些接口
                target.getClass().getInterfaces(),
                //要如何增强目标对象、目标对象是哪个（通过handler对象间接传入）
                handler
                );

        System.out.println("=================");
        System.out.println(proxy);
        System.out.println("=================");
        System.out.println(proxy.getClass());
        System.out.println("=================");
        //执行代理对象中增强后的方法时会反过来调用handler对象中的invoke方法
        //方法的参数包含
        //Object proxy:代理对象,包含了目标类的信息(打印proxy:org.example.service.impl.SomeServiceImplTargetTest@2503dbd3)
        //Method method:Method类的method对象，该对象包含目标类实现的接口的要执行的方法名
        // (打印method:public abstract void org.example.service.SomeService.doSome())
        // (是否包含实现方法的具体代码有待考证,毕竟传了目标对象给method的invoke方法进去)
        //Object[] args:目标对象方法（doSome、doOther）的参数
        proxy.doSome();
        System.out.println("=================");
        proxy.doOther();
        //target.doSome();
        //target.doOther();
    }
    //target是目标对象
    //handler是增强对象
    //proxy是代理对象
    //将目标对象的目标类信息与增强对象作为参数传入Proxy类中创建代理对象的方法，创建出代理对象
    //先将handler对象作为参数创建出代理对象，再在执行代理对象中增强后的方法时反过来调用handler对象中的invoke方法
}
