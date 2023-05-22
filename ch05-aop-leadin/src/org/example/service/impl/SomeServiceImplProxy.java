package org.example.service.impl;

import org.example.service.SomeService;
import org.example.util.ServiceTools;

//静态代理
public class SomeServiceImplProxy implements SomeService {
    @Override
    public void doSome() {
        ServiceTools.doLog();
        SomeService someService = new SomeServiceImpl1();
        someService.doSome();
        ServiceTools.doTrans();
    }

    @Override
    public void doOther() {
        ServiceTools.doLog();
        SomeService someService = new SomeServiceImpl1();
        someService.doOther();
        ServiceTools.doTrans();
    }
}
