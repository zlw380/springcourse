package org.example.ba01;

public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name,Integer age) {
        System.out.println("执行SomeService目标方法doSome:"+name+age);
    }
}
