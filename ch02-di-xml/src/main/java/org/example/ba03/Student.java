package org.example.ba03;

public class Student {

    private String name;
    private int age;
    private School school;

    public Student() {
        System.out.println("non-param-constructor has been executed");
    }

    public Student(String name, int age, School school) {
        System.out.println("Student的有参数构造方法已执行");
        this.name = name;
        this.age = age;
        this.school = school;
    }

    public void setSchool(School school) {
        //System.out.println("setSchool : "+school);
        this.school = school;
    }

    public School getSchool() {
        return school;
    }

    public void setName(String name) {
        //System.out.println("setName"+name);
        this.name = name;
    }

    public void setAge(int age) {
        //System.out.println("setAge"+age);
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
