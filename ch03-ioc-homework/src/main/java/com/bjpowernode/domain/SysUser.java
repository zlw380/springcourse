package com.bjpowernode.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//默认 通过service 类调用 dao类完成 SysUser插入到数据库的操作
@Component("sysUser")
public class SysUser {
     @Value("大哥")
     private String name;
     @Value("33")
     private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
