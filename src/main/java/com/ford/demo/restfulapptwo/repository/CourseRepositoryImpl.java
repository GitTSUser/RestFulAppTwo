package com.ford.demo.restfulapptwo.repository;

import com.ford.demo.restfulapptwo.model.Course;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
public class CourseRepositoryImpl implements ICourseRepository {

    private static List<Course> courseList = new ArrayList<Course>();

    static {
        courseList.add(new Course(1, "Java FSD", 45000.25, 6));
    }

    @Override
    public Course saveCourse(Course course) {
        courseList.add(course);
        log.info("Saving course: " + course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        //to update, we need to check course is there or not in list
        if(findCourse(course.getId()) == null) {
            log.info("Updating is not possible as given course id is not found! ");
            return null;
        }else{
            courseList.stream().filter(c->c.getId() == course.getId()).findFirst().ifPresent(c->{
                c.setName(course.getName());
                c.setFee(course.getFee());
                c.setDuration(course.getDuration());
            });
            log.info("Course updated Successfully!");
        }
        return course;
    }

    @Override
    public Course findCourse(int id) {

        for (Course course : courseList) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    @Override
    public List<Course> findAllCourses() {
        return courseList;
    }

    @Override
    public boolean deleteCourse(int id) {
        return courseList.removeIf(c->c.getId() == id);
    }
}