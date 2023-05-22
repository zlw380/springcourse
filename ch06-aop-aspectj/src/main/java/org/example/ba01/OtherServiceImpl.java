package org.example.ba01;

public class OtherServiceImpl implements SomeService {
    @Override
    public void doSome(String name,Integer age) {
        System.out.println("执行OtherService目标方法doSome:"+name+age);
    }
}
