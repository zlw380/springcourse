package org.example.service.Cglib;

public class Cglib2 extends Cglib1{

    public void intensity() {
        System.out.println("before");
        //Cglib1 cglib1 = new Cglib1();
        //cglib1.execute();
        //可以通过子类所继承的父类的公共方法访问父类的私有变量
        execute();
        //display();
        System.out.println(getName()+10);
        System.out.println("after");
    }

}


