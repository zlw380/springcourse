package org.example.service.impl;

import org.example.service.SomeService;

public class SomeServiceImplTargetTest implements SomeService {

    private String name;

    public SomeServiceImplTargetTest() {
    }

    public SomeServiceImplTargetTest(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void doSome() {

        System.out.println("执行doSome方法打印目标对象属性name:"+name);

    }

    @Override
    public void doOther() {

        System.out.println("execute service method doOther 1");

    }
}
