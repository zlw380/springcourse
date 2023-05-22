package org.example.ba01;

public class GetClass {
    public static void main(String[] args) {

        //简单来说反射就是在程序运行期间，动态地获取类或者对象中的属性。
        //反射的原理就是通过类的字节码文件(.class文件)反向获取该类或者对象中的属性，
        //既然是通过字节码获取，这就需要JVM的操作了。

        //Object.getClass 是构造Class类型对象的三种方法之一
        //它是Object类下面的一个方法
        //通过s对象直接获取方法区中对应字节码文件（.class文件）中的类的信息
        //并封装到一个Class类的对象当中
        //这个Class类的对象是由JVM自动创建的
        String s = "shiny!";
        Class stringClass = s.getClass();
        System.out.println(stringClass);
        System.out.println(stringClass.getName());

        Class integerClass = Integer.class;
        System.out.println(integerClass);
    }
}
