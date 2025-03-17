package com.ford.demo.restfulapptwo.controller;

import com.ford.demo.restfulapptwo.model.Student;
import com.ford.demo.restfulapptwo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @RequestMapping(path="/new-student",method = RequestMethod.POST)
    public Student saveStudentInfo(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @RequestMapping(path = "/update-student",method = RequestMethod.PUT)
    public Student updateStudentInfo(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @RequestMapping(path = "/find-student/{sid}",method = RequestMethod.GET)
    public Student getStudentInfo(@PathVariable("sid") int studentId) {
        Student student= studentService.getStudentById(studentId);
        return student;
    }

    @RequestMapping(path = "/all-students",method = RequestMethod.GET)
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @RequestMapping(path = "/delete-student",method = RequestMethod.DELETE)
    public String removeStudent(int studentId){
        if(studentService.deleteStudent(studentId)){
            return "Student deleted successfully";
        }
        return "Student could not be deleted";
    }
}