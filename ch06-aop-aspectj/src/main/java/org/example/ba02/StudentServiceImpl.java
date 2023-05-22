package org.example.ba02;

public class StudentServiceImpl implements StudentService {
    @Override
    public Student doOther() {
        Student student = new Student();
        student.setName("lisi");
        student.setAge(30);
        return student;
    }
}
