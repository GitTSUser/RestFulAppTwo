package com.ford.demo.restfulapptwo.repository;

import com.ford.demo.restfulapptwo.model.Course;
import com.ford.demo.restfulapptwo.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
public class StudentRepositoryImpl implements IStudentRepository{

    private static List<Student> students = new ArrayList<Student>();

    static {
        List<Course> courses=new ArrayList<>();
        courses.add(new Course(100,"Java FSD",78000.25,6));
        courses.add(new Course(200,"UI Design",45000.25,3));

        Student s1=new Student(1,"arun","arun@yahoo.com","044-2354-26",courses);
        students.add(s1);
    }

    @Override
    public Student addStudent(Student student) {
        log.info("StudentRepositoryImpl.addStudent(student) method begins");
         students.add(student);
         log.info("StudentRepositoryImpl.addStudent(student) method ends");
        return  student;
    }

    @Override
    public Student updateStudent(Student student) {
        log.info("StudentRepositoryImpl.updateStudent(student) method begins");
        if(getStudentById(student.getId())!=null){
            students.stream().filter(st->st.getId()==student.getId()).findFirst().ifPresent(st->{
                st.setName(student.getName());
                st.setEmail(student.getEmail());
                st.setPhone(student.getPhone());
                st.setCourseList(student.getCourseList());
            });
            log.info("Student is updated successfully");
            return student;
        }else{
            log.info("Student is not found to update");
        }
        return null;
    }

    @Override
    public Student getStudentById(int id) {
        return students.stream().filter(st->st.getId()==id).findFirst().orElse(null);
    }

    @Override
    public boolean deleteStudent(int id) {
        return students.remove(getStudentById(id));
    }

    @Override
    public List<Student> getAllStudents() {
        return students;
    }
}