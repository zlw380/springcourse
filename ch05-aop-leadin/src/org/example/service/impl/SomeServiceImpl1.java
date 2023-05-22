package org.example.service.impl;

import org.example.service.SomeService;
import org.example.util.ServiceTools;

public class SomeServiceImpl1 implements SomeService {
    @Override
    public void doSome() {

        System.out.println("execute service method doSome 1");

    }

    @Override
    public void doOther() {

        System.out.println("execute service method doOther 1");

    }
}
