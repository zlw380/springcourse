package org.example.ba03;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("mySchool")
public class School {

    @Value("YU")
    private String name;
    @Value("HubeiJingzhou")
    private String address;

    public School() {
        System.out.println("myschool对象的无参构造方法已执行");
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
