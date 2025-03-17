package com.ford.demo.restfulapptwo.service;

import com.ford.demo.restfulapptwo.model.Student;
import com.ford.demo.restfulapptwo.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService{

    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public Student addStudent(Student student) {
        return studentRepository.addStudent(student);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.updateStudent(student);
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.getStudentById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    @Override
    public boolean deleteStudent(int id) {
        return studentRepository.deleteStudent(id);
    }
}
