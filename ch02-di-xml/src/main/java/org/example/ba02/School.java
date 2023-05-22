package org.example.ba02;

public class School {

    private String name;
    private String address;

    public School() {
        System.out.println("myschool对象的构造方法已执行");
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
