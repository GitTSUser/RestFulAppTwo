package com.ford.demo.restfulapptwo.repository;

import com.ford.demo.restfulapptwo.model.Course;

import java.util.List;

public interface ICourseRepository {

    public Course saveCourse(Course course);
    public Course updateCourse(Course course);
    public Course  findCourse(int id);
    public List<Course> findAllCourses();
    public boolean deleteCourse(int id);

}
