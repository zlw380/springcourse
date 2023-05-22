package org.example.service.impl;

import org.example.service.SomeService;

public class SomeServiceImpl implements SomeService {

    public SomeServiceImpl() {
        System.out.println("constructor method");
    }

    @Override
    public void doSome() {
        System.out.println("execute impl's doSome method");
    }
}
