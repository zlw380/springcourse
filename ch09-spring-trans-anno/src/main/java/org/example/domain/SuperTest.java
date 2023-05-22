package org.example.domain;

public class SuperTest {
    public static void main(String[] args) {
        //grandson a = new grandson("祖父","父亲","儿子","孙子");
        //System.out.println(a.grandpa+a.father+a.son+a.grandson);
        //grandson b = new grandson();
        grandson c = new grandson("祖父");
        System.out.println(c.grandpa);
    }
}

class grandpa {

    String grandpa = "";

    public grandpa() {
        System.out.println("执行了grandpa的无参构造方法");
    }

    public grandpa(String grandpa){
        this.grandpa = grandpa;
        System.out.println("grandpa一个参数的构造方法,传入的参数值是："+grandpa);
    }
}

class father extends grandpa {

    String father = "";

    public father(){
        System.out.println("执行了father的无参构造方法");
    }

    public father(String grandpa) {
        super(grandpa);
        System.out.println("father一个参数的构造方法");
    }

    public father(String grandpa, String father) {
        super(grandpa);
        this.father = father;
        System.out.println("father两个参数的构造方法");
    }
}

class son extends father {

    String son = "";

    public son(){
        System.out.println("执行了son的无参构造方法");
    }

    public son(String grandpa) {
        super(grandpa);
        System.out.println("son一个参数的构造方法");
    }

    public son(String grandpa, String father, String son) {
        super(grandpa,father);
        this.son = son;
        System.out.println("son三个参数的构造方法");
    }
}

class grandson extends son {

    String grandson = "";

    public grandson(){
        System.out.println("执行了grandson的无参构造方法");
    }

    public grandson(String grandpa) {
        super(grandpa);
        System.out.println("grandson一个参数的构造方法");
    }

    public grandson(String grandpa,String father,String son,String grandson) {
        super(grandpa,father,son);
        this.grandson = grandson;
        System.out.println("grandson四个参数的构造方法");
    }
}