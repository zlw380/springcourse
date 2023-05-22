package org.example.ba01;

public class OrderServiceImpl implements SomeService {
    @Override
    public void doSome(String name,Integer age) {
        System.out.println("执行OrderService目标方法doSome:"+name+age);
    }
}
