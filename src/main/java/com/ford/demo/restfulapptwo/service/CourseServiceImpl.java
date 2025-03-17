package com.ford.demo.restfulapptwo.service;

import com.ford.demo.restfulapptwo.model.Course;
import com.ford.demo.restfulapptwo.repository.CourseRepositoryImpl;
import com.ford.demo.restfulapptwo.repository.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService{

    @Autowired
    private ICourseRepository courseRepository;

    @Override
    public Course save(Course course) {
        return courseRepository.saveCourse(course);
    }

    @Override
    public Course update(Course course) {
        return courseRepository.updateCourse(course);
    }

    @Override
    public Course searchCourseById(int id) {
        return courseRepository.findCourse(id);
    }

    @Override
    public List<Course> findAllCourses() {
        return courseRepository.findAllCourses();
    }

    @Override
    public boolean deleteCourse(int id) {
        return courseRepository.deleteCourse(id);
    }
}