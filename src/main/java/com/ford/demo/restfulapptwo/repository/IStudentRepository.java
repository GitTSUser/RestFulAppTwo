package com.ford.demo.restfulapptwo.repository;

import com.ford.demo.restfulapptwo.model.Student;

import java.util.List;

public interface IStudentRepository {

    public Student addStudent(Student student);
    public Student updateStudent(Student student);
    public Student getStudentById(int id);
    public boolean deleteStudent(int id);
    public List<Student> getAllStudents();
}
