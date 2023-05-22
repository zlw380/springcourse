package org.example.ba06;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("youSchool")
public class School {

    @Value("航天")
    private String name;
    @Value("南极")
    private String address;

    public School() {
        System.out.println("youSchool对象的无参构造方法已执行");
    }

    public void setName(String name) {
        System.out.println("setName"+name);
        this.name = name;
    }

    public void setAddress(String address) {
        System.out.println("setAddress"+address);
        this.address = address;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
