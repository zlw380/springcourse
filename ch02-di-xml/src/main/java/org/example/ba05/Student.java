package org.example.ba05;

public class Student {

    private String name;
    private int age;
    private School school;

    public void setSchool(School school) {

        System.out.println("setSchool : "+school);
        this.school = school;
    }

    public Student() {
        //System.out.println("non-param-constructor has been executed");
    }

    public void setName(String name) {
        //System.out.println("setName"+name);
        this.name = name;
    }

    public void setAge(int age) {
        //System.out.println("setAge"+age);
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
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
