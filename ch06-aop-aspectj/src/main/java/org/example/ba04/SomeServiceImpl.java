package org.example.ba04;

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

    @Override
    public String doFirst(String name, Integer age) {
        System.out.println("执行业务方法doFirst()"+name+age);
        return "doFirst";
    }

    @Override
    public String doSecond() {
        //System.out.println("执行业务方法doSecond()"+(10/0));
//        执行最终通知方法
//        目标方法出现异常，执行异常通知方法：/ by zero

        System.out.println("执行业务方法doSecond()");
//        执行业务方法doSecond()
//        执行最终通知方法
//        执行后置通知方法myAfterReturning:spring!

        return "spring!";
    }

}
