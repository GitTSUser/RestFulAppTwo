package com.ford.demo.restfulapptwo.service;

import com.ford.demo.restfulapptwo.model.Student;

import java.util.List;

public interface IStudentService {

    public Student addStudent(Student student);
    public Student updateStudent(Student student);
    public Student getStudentById(int id);
    public List<Student> getAllStudents();
    public boolean deleteStudent(int id);
}
