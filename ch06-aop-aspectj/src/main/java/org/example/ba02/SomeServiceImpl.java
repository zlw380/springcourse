package org.example.ba02;

public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name,Integer age) {
        System.out.println("执行SomeService目标方法doSome:"+name+age);
    }

    @Override
    public String doOther(String name, Integer age) {
        System.out.println("执行SomeService目标方法doOther:"+name+age);
        return "cat";
    }

    @Override
    public Integer doTest() {
        System.out.println("执行SomeService目标方法doTest");
        return 100;
    }

}
