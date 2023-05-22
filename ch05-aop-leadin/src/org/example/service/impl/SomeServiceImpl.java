package org.example.service.impl;

import org.example.service.SomeService;
import org.example.util.ServiceTools;

import java.util.Date;

public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome() {
        //System.out.println("doSome:"+ new Date());
        ServiceTools.doLog();
        System.out.println("execute service method doSome");
        //System.out.println("doSome提交事务");
        ServiceTools.doTrans();
    }

    @Override
    public void doOther() {
        //ystem.out.println("doOther"+ new Date());
        ServiceTools.doLog();
        System.out.println("execute service method doOther");
        //System.out.println("doOther提交事务");
        ServiceTools.doTrans();
    }
}
