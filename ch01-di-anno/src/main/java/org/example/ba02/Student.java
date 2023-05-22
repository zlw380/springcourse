package org.example.ba02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//创建对象，等同于bean的功能。属性value就是对象的名称，也就是bean的id值。value的值是唯一的。
//@Component(value = "myStudent")
@Component("myStudent")
//@Component
public class Student {
    @Value("张飞")
    private String name;
    @Value("29")
    private String age;

    public Student() {
        System.out.println("ba02 non-param constructor");
    }

/*    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }*/

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
