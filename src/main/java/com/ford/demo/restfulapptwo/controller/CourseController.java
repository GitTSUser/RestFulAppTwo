package com.ford.demo.restfulapptwo.controller;

import com.ford.demo.restfulapptwo.model.Course;
import com.ford.demo.restfulapptwo.service.CourseServiceImpl;
import com.ford.demo.restfulapptwo.service.ICourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@Slf4j
public class CourseController {
    @Autowired
    private ICourseService courseService;

    @RequestMapping(path = "/add-course", method = RequestMethod.POST)
    public Course addCourse(@RequestBody Course course){
        log.info("CourseController::addCourse(course) method begins "+course.getId());
        Course savedCourse=courseService.save(course);
        log.info("CourseController::addCourse(course) method ends "+course.getId());
        return savedCourse;
    }

    @RequestMapping(path="/update-course",method = RequestMethod.PUT)
    public Course updateCourse(@RequestBody Course course){
    Course updatedCourse=courseService.update(course);
    return updatedCourse;
    }

    @RequestMapping(path="/find-course/{id}",method = RequestMethod.GET)
    public Course findCourse(int courseId){
        Course course=courseService.searchCourseById(courseId);
        return course;
    }

    @RequestMapping(path = "/all-courses",method = RequestMethod.GET)
    public List<Course> findAllCourses(){
        List<Course>  courses=courseService.findAllCourses();
        return courses;
    }

    @RequestMapping(path = "/delete-course",method = RequestMethod.DELETE)
    public String  deleteCourse(int courseId){
        if(courseService.deleteCourse(courseId)){
            return "Course deleted Successfully";
        }
        return "Course not found";
    }
}