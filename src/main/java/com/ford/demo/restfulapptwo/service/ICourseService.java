package com.ford.demo.restfulapptwo.service;

import com.ford.demo.restfulapptwo.model.Course;

import java.util.List;

public interface ICourseService {

    public Course save(Course course);

    public Course update(Course course);

    public Course searchCourseById(int id);

    //public Course searchCourseByName(String name);

   // public Course searchCourseByNameAndDuration(String name, int duration);

    //public double findSumOfAllCourseFees();

    public List<Course> findAllCourses();

    public boolean deleteCourse(int id);
    //public boolean deleteCourseByName(String name);

}
