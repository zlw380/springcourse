package org.example.ba07;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

//创建对象，等同于bean的功能。属性value就是对象的名称，也就是bean的id值。value的值是唯一的。
//@Component(value = "myStudent")
@Component("myStudent")
//@Component
public class Student {
    @Value("${myname}")
    private String name;
    @Value("${myage}")
    private String age;
    //@Resource(description = "youSchool")
    @Resource(name = "youSchool")
    private School university;

    public Student() {
        System.out.println("ba06 non-param constructor");
    }

/*    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setSchool(School school) {
        this.university = school;
    }*/

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", university=" + university +
                '}';
    }
}
