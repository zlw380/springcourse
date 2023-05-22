package org.example.domain;

class SuperClass {
    private int n;
    SuperClass(){
        System.out.println("SuperClass()");
    }
    SuperClass(int n) {
        System.out.println("SuperClass(int n)");
        this.n = n;
        System.out.println(n);
    }
}
// SubClass 类继承
class SubClass extends SuperClass{
    private int n;

    SubClass(){ // 自动调用父类的无参数构造器
        System.out.println("SubClass");
    }

    public SubClass(int n){
        super(300);  // 调用父类中带有参数的构造器
        System.out.println("SubClass(int n):"+n);
        System.out.println(n);
        this.n = n;
        System.out.println(n);
    }
}
// SubClass2 类继承
class SubClass2 extends SuperClass{
    private int n;

    SubClass2(){
        super(300);  // 调用父类中带有参数的构造器
        System.out.println("SubClass2");
    }

    public SubClass2(int n){ // 自动调用父类的无参数构造器
        //super();
        System.out.println("SubClass2(int n):"+n);
        System.out.println(this.n);
        this.n = n;
        System.out.println(this.n);
    }
}

class TestSuperSub{
    public static void main (String args[]){
        System.out.println("------SubClass 类继承------");
        SubClass sc1 = new SubClass();
        Class c = sc1.getClass();
        System.out.println(c);
        System.out.println("---------------------------");
        SubClass sc2 = new SubClass(100);
        System.out.println("------SubClass2 类继承------");
        SubClass2 sc3 = new SubClass2();
        System.out.println("---------------------------");
        SubClass2 sc4 = new SubClass2(200);
    }
}
