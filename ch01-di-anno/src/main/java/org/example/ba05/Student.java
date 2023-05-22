package org.example.ba05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//创建对象，等同于bean的功能。属性value就是对象的名称，也就是bean的id值。value的值是唯一的。
//@Component(value = "myStudent")
@Component("myStudent")
//@Component
public class Student {
    @Value("李飞")
    private String name;
    @Value("22")
    private String age;
    @Autowired(required = false)
    @Qualifier("youSchoo")
    private School university;

    public Student() {
        System.out.println("ba04 non-param constructor");
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
