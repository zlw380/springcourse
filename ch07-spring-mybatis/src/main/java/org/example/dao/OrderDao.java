package org.example.dao;

import org.example.domain.Student;

import java.util.List;

public interface OrderDao {
    int insertStudent(Student student);
    List<Student> selectStudents();
}
